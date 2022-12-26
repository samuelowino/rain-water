package com.owino.basics

enum class MissionStatus {
    INITIALIZED,
    RUNNING,
    CANCELLED,
    COMPLETED;

    fun description(): String {
        return when(this){
            INITIALIZED -> "Mission initialized 🚀"
            RUNNING -> "Mission Running 🏃🏽‍♀️"
            CANCELLED -> "Mission Cancelled 😢"
            COMPLETED -> "Mission Accomplished 🤓"
        }
    }
}

data class Apollo13Mission(val status: MissionStatus, val name: String = "Apollo 13")

fun main(){
    val mission: Apollo13Mission = Apollo13Mission(MissionStatus.CANCELLED)

    println("${mission.name} ${mission.status.description()}")
}