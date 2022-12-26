fun main(){
    val properties = "onboarded.key" to false

    println("key ${properties.first} value ${properties.second}")

    val (dob, age) = Pair(1995,27)

    println("dob ${dob} age ${age}")
}
