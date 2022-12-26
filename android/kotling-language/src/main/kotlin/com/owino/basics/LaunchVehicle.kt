package com.owino.basics

class LaunchVehicle(val vehicleName: String, var mission: Mission): Rocket {

    override fun launch() {
        println("Launching $vehicleName rocket : Mission ${mission.label}")
    }

    override fun cutOffMainEngin() {
        println("Performing engine cut of stage: Vehicle $vehicleName rocket : Mission ${mission.label}")
    }

    override fun performPayloadSeparation() {
        println("Performing payload separation stage: Vehicle $vehicleName rocket : Mission ${mission.label}")
    }

    override fun runOrbitalCheckout() {
        println("Running orbital checkout stage: Vehicle $vehicleName rocket : Mission ${mission.label}")
    }

    override fun takeOverManualControl(commander: String) {
        println("Commander $commander is taking over manual control of the ship: Vehicle $vehicleName rocket : Mission ${mission.label}")
    }
}