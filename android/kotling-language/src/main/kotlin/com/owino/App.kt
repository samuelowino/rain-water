package com.owino

import com.owino.basics.*

fun main() {

    val apollo11 = Mission(1978, "Collect space rocks", "Saturn V", "Apollo 11");
    val apollo12 = Mission(1879, "Collect some more moon rocks", "Saturn V", "Apollo 12");

    val spaceProgram = ApolloMissions(apollo11, apollo12)
    val missionsDescription = spaceProgram.allMissions()

    val astronauts = listOf<Astronaut>(
        Astronaut("","","", 43)
    )

    apollo11.assignAstronauts(apollo11, astronauts)

    println(missionsDescription)

    val saturnV: Rocket = LaunchVehicle("Saturn V", apollo11)
    val apollo11MissionControl = MissionControl(saturnV);

    apollo11MissionControl.launch()

    val blackRock : Company = Company("Black Rock",true);


}