package com.own.gameofthronesenlistment.enlistment.service

import com.own.gameofthronesenlistment.enlistment.infra.CharactersAPIClient
import kotlinx.coroutines.*
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

val army = mutableListOf<String>()

@Service
class StarkEnlistment(val charactersAPIClient: CharactersAPIClient) {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun enlist() {
        log.info("Lennister are declared waaaaar!!")
        log.info("The lord of the north summons all houses loyal to house stark to come to Winterfell, It's war time")

        log.info("Sending letters... ")
        val timeLettersSent = System.currentTimeMillis()

        val callToWar = CoroutineScope(CoroutineName("The Lord of North called"))
            .launch {
                repeat(20) {
                    launch {
                        val soldiersWhoArrived = callSoldiers().characters.map { it.name }
                        army.addAll(soldiersWhoArrived)
                    }
                }
            }

        callToWar.invokeOnCompletion {
            val timeSoldierArrived = System.currentTimeMillis()

            log.info("Total time: ${timeSoldierArrived - timeLettersSent}")
            log.info("Number of soldiers on army: ${army.size}")
            log.info("Army: $army")
        }
    }

    suspend fun callSoldiers() =
        withContext(Dispatchers.IO) {
            charactersAPIClient.getCharactersByHouse("Stark")
        }



}


