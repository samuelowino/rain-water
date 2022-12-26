package com.owino.basics

data class Company(val name: String = "NASA Third Party", val isThirdParty: Boolean)

data class InstrumentUnit(val rocket: Rocket, val installed: Boolean)

data class RetroRocket(val manufacturer: Company, val shippingStatus: String)

data class InterTank(val capacity: Double,val manufacturer: Company, val installed: Boolean)