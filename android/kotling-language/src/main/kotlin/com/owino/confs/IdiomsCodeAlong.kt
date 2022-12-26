package com.owino.confs

fun main(){
    //mutable map
    val scores: MutableMap<String, Int> = mutableMapOf()

    scores["Serina"] = 34
    scores["Jemmy"] = 5

    for ((player, score) in scores){
        println("$player ==> $score")
    }

    //immutable map
    val pyramids = mapOf("Giza" to 139, "Saqqara" to 62)

    pyramids.forEach { (name, height) -> println("$name, height $height") }

    //pyramids["Jakina"] = 2300 : error ==> unresolved reference
    //pyramids.put("Jakina", 7900L) : error ==> unresolved reference [put]

    val counties = mutableListOf("Kiambu","Kakamega","Garrisa","Uasin Gishu")

    counties.forEach { county -> println("County: $county") }

    val richCountries = listOf("Sri Lanka","Venezuela","Yemen","Cambodia")

    richCountries.forEach { country -> println(country) }

    fun sing(vararg bars: String){
        for (bar in bars){
            println(bar)
        }
    }

    sing("It's been a week without me","And she feel weak without me","She wanna talk it out, but")

    class DatabaseConnection {
        constructor(url: String, password: String, connectionPool: Int)

        init {
           println("Connecting to database... this might take some time and memory")
        }
    }

    val databaseConnection = DatabaseConnection("localhost:3306/nsa", "verysecurepassword", 10)

    //This won't be initialized unless it is actually required
    val lazyDbConnection by lazy {
        DatabaseConnection("localhost:3306/sputnik", "verysecurepassword", 5)
    }

    //extension functions

    fun Int.prefixCurrency(currency: String): String {
        return "$currency $this"
    }

    val rent: Int = 120000

    println("Rent is ${rent.prefixCurrency("KES")}")

    fun String.EMPTY(): String {
        return "";
    }

    var emptyString: String? = null
    emptyString = "".EMPTY()

    println("Emptu string is ${emptyString.EMPTY()}")

}
