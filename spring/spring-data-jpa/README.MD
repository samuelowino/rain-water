# Spring Data JPA

Spring Data JPA provide persistence support for **Jakarta Persistence API (JPA)**.

## Core Concepts
The core interface in Spring JPA is **Repository**. Repository take the domain class to manage as well as the ID of the domain class as type arguments.

```java
//T - Domain class
//ID = Id of the domain class
public interface JpaRepository<T, ID>  
```

The **CrudRepository** and **ListCrudeRepository** provide sophisticated functionality for the entity class that is being managed.

Spring data supports persistence technology specific abstractions such as **JpaRepository** and **MongoRepository**. Those interfaces extend **CrudRepository** and expose the capabilities of the underlying persistence technology.

```java
/*
 * Copyright 2008-2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
...
public interface JpaRepository<T, ID> extends ListCrudRepository<T, ID>, ListPagingAndSortingRepository<T, ID>, QueryByExampleExecutor<T> {

	/**
	 * Flushes all pending changes to the database.
	 */
	void flush();

	/**
	 * Saves an entity and flushes changes instantly.
	 *
	 * @param entity entity to be saved. Must not be {@literal null}.
	 * @return the saved entity
	 */
	<S extends T> S saveAndFlush(S entity);

	/**
	 * Saves all entities and flushes changes instantly.
	 *
	 * @param entities entities to be saved. Must not be {@literal null}.
	 * @return the saved entities
	 * @since 2.5
	 */
	<S extends T> List<S> saveAllAndFlush(Iterable<S> entities);

	/**
	 * Deletes the given entities in a batch which means it will create a single query. This kind of operation leaves JPAs
	 * first level cache and the database out of sync. Consider flushing the {@link EntityManager} before calling this
	 * method.
	 *
	 * @param entities entities to be deleted. Must not be {@literal null}.
	 * @deprecated Use {@link #deleteAllInBatch(Iterable)} instead.
	 */
	@Deprecated
	default void deleteInBatch(Iterable<T> entities) {
		deleteAllInBatch(entities);
	}

	/**
	 * Deletes the given entities in a batch which means it will create a single query. This kind of operation leaves JPAs
	 * first level cache and the database out of sync. Consider flushing the {@link EntityManager} before calling this
	 * method.
	 *
	 * @param entities entities to be deleted. Must not be {@literal null}.
	 * @since 2.5
	 */
	void deleteAllInBatch(Iterable<T> entities);

	/**
	 * Deletes the entities identified by the given ids using a single query. This kind of operation leaves JPAs first
	 * level cache and the database out of sync. Consider flushing the {@link EntityManager} before calling this method.
	 *
	 * @param ids the ids of the entities to be deleted. Must not be {@literal null}.
	 * @since 2.5
	 */
	void deleteAllByIdInBatch(Iterable<ID> ids);

	/**
	 * Deletes all entities in a batch call.
	 */
	void deleteAllInBatch();

	/**
	 * Returns a reference to the entity with the given identifier. Depending on how the JPA persistence provider is
	 * implemented this is very likely to always return an instance and throw an
	 * {@link jakarta.persistence.EntityNotFoundException} on first access. Some of them will reject invalid identifiers
	 * immediately.
	 *
	 * @param id must not be {@literal null}.
	 * @return a reference to the entity with the given identifier.
	 * @see EntityManager#getReference(Class, Object) for details on when an exception is thrown.
	 * @deprecated use {@link JpaRepository#getReferenceById(ID)} instead.
	 */
	@Deprecated
	T getOne(ID id);

	/**
	 * Returns a reference to the entity with the given identifier. Depending on how the JPA persistence provider is
	 * implemented this is very likely to always return an instance and throw an
	 * {@link jakarta.persistence.EntityNotFoundException} on first access. Some of them will reject invalid identifiers
	 * immediately.
	 *
	 * @param id must not be {@literal null}.
	 * @return a reference to the entity with the given identifier.
	 * @see EntityManager#getReference(Class, Object) for details on when an exception is thrown.
	 * @deprecated use {@link JpaRepository#getReferenceById(ID)} instead.
	 * @since 2.5
	 */
	@Deprecated
	T getById(ID id);

	/**
	 * Returns a reference to the entity with the given identifier. Depending on how the JPA persistence provider is
	 * implemented this is very likely to always return an instance and throw an
	 * {@link jakarta.persistence.EntityNotFoundException} on first access. Some of them will reject invalid identifiers
	 * immediately.
	 *
	 * @param id must not be {@literal null}.
	 * @return a reference to the entity with the given identifier.
	 * @see EntityManager#getReference(Class, Object) for details on when an exception is thrown.
	 * @since 2.7
	 */
	T getReferenceById(ID id);

	/*
	 * (non-Javadoc)
	 * @see org.springframework.data.repository.query.QueryByExampleExecutor#findAll(org.springframework.data.domain.Example)
	 */
	@Override
	<S extends T> List<S> findAll(Example<S> example);

	@Override
	<S extends T> List<S> findAll(Example<S> example, Sort sort);
}
```

Additional to the CrudRepository there is **PagingAndSortingRepository** abstraction that adds additional methods to ease paginated access to entities.

```java
public interface PagingAndSortingRepository<T, ID>  {

  Iterable<T> findAll(Sort sort);

  Page<T> findAll(Pageable pageable);
}
```

**Pageable** is an abstract interface for pagination information. **JpaRepository** already extends PagingAndSortingRepository as well. You can use **PageRequest** to create a pageable with a page size.

```java
var pageable = PageRequest.of(1, 5)
```
## Page
A page is a sublist of a list of objects.

```java
var page = repository.findAll(PageRequest.of(0, 25));
```

Query derivation for **delete** and **count** is available.

# Using @Query
Using named queries allows you to tie the queries to the java method on which they are declared on. 

```java
@Query(value = "SELECT contents FROM tweet", nativeQuery = true)
List<String> findAllTweetContents();
```

# Modifying Queries
A Query method annotated with @Modifying marks the query as an **updating one** instead of a **selecting one**. Make the **EntityManager** clear any endities after the update by setting **clearAutomatically attribute to true**

The Modifying annotation is only relevant with the **@Query annoted methods**, derived query methods and custom methods do not require this annotation.

sources
-> https://docs.spring.io/spring-data/jpa/docs/current/reference/html/