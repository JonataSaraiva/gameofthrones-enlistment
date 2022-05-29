package com.own.gameofthronesenlistment

import com.own.gameofthronesenlistment.enlistment.service.StarkEnlistment
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class GameofthronesEnlistmentApplication(val starkEnlistment: StarkEnlistment) : CommandLineRunner {
    override fun run(vararg args: String?) {
        runBlocking {
            starkEnlistment.enlist()
            delay(15000)
        }
    }
}

fun main(args: Array<String>) {
    runApplication<GameofthronesEnlistmentApplication>(*args)
}