# Object expressions and declarations

Object expressions create objects of **anonymous innner classes**, also called **anonymous objects**.

```kotlin
val rover = object {
    val fuelCapacity: Int = 1_200
    val loadLimit: Double = 2

    override fun launch(): Boolean  = true
}
```

You can inherit anonymous object from supertypes by specifying this type after object and **:** . You can then implement or override the members of the class as if you were inheriting from it.

```kotlin 
interface Callback {
    fun onCallback(): Int 
    fun onCallback(): Boolean 
}

class Runner(private val callback: Callback) {
    init {
        val count: Int = callback.onCallback()
        val condition: Boolean = callbac.onCallback()
    }
}

val runner = Runner(object: Callback() {
    override onCallback(): Int {
        return 0
    }

    override onCallback(): Boolean {
        return true
    }
})

```


