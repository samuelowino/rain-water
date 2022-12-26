package com.owino.basics

class ApolloMissions(var apollo11Mission: Mission, var apollo12Mission: Mission) {
    var apollo11: Mission? = apollo11Mission;
    var apollo12: Mission? = apollo12Mission;

    fun allMissions(): String {
        return "${apollo11?.description()}\n${apollo12?.description()}";
    }
}