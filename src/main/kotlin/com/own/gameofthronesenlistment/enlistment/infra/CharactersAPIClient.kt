package com.own.gameofthronesenlistment.enlistment.infra

import com.own.gameofthronesenlistment.enlistment.domain.CharactersResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod


@FeignClient(value = "got-characters", url = "http://localhost:9090")
interface CharactersAPIClient {

    @RequestMapping(method = [RequestMethod.GET], value = ["/characters/{house}"], produces = ["application/json"])
    fun getCharactersByHouse(@PathVariable("house") house: String): CharactersResponse

}