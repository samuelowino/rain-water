package com.owino.basics

/**
 * Interfaces
 * Interfaces in kotlin contain declaration of abstract methods
 * as well as method implementations
 *
 */
interface Rocket {
    fun launch()

    fun cutOffMainEngin()

    fun performPayloadSeparation()

    fun runOrbitalCheckout()

    fun takeOverManualControl(commander: String)

    /**
     * Implemented interface method
     */
    fun flyUnder() {
        print("Performing default rocket fly under stage, not custom controls")
    }
}