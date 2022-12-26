package com.owino.basics

/**
 * Properties of a class are listed in the declaration body
 * The default constructor is available automatically
 */
class Mission(var launchYear: Int, var objectives: String, var rocket: String, var label: String) {

    fun description(): String {
        return "Year: $launchYear, Objectives $objectives, Rocket $rocket, Mission Label $label";
    }

    fun assignAstronauts(mission: Mission, astronauts: List<Astronaut>){
        for (astronaut in astronauts){
            println("Assigning ${astronaut.name} to mission ${mission.label}")
        }
    }
}