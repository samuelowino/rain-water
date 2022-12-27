# Apache Maven Compiler Plugin

The compiler plugin is used to compiler the source of the project.

The compiler plugin has 2 **goals**:

* **compiler:compile** - compiles the main source files
* **compiler:testCompile** - compiles the test source files

**GroupId: org.apache.maven.plugins**
**ArtifactId: maven-compiler-plugin**

```xml
<dependency>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-compiler-plugin</artifactId>
  <version>3.10.1</version>
  <type>maven-plugin</type>
</dependency>
```

## Setting the source and target of the Java compiler

You can do this by **adding as properties or configure the plugin directly**

**Optiona 1: add properties**

```xml
<properties>
    <maven.compiler.source>17</maven.compiler.source>
    <maven.compiler.target>17</maven.compiler.source>
</properties>
```

**Option 2: configure the plugin directly**

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.10.1</version>
            <configuration>
                <source>17</source>
                <target>17</target>
            </configuration>
        </plugin>
    </plugins>
</build>
```


