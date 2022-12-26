package com.owino.basics

object LaunchPad {
    var location: String? = null
    var capacity: Int = 0;

    fun details(){
        println("Launch pad ==> $location $capacity")
    }


}

class LaunchRegion(val preciseLocation: String) {
    fun padDetails(){
        LaunchPad.location = "Houston TX, $preciseLocation"
        LaunchPad.capacity = 5 //can hold 5 rockets at one time
        println(LaunchPad.details())
    }
}

fun main(){
    val johnsonSpaceCenter: LaunchRegion = LaunchRegion("NASA Johnson Space Center")
    johnsonSpaceCenter.padDetails()
}