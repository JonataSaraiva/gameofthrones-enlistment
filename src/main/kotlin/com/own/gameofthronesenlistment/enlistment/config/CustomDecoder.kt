package com.own.gameofthronesenlistment.enlistment.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import feign.codec.Decoder
import feign.jackson.JacksonDecoder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class CustomDecoder {

    @Bean
    fun feignDecoder() : Decoder = JacksonDecoder(objectMapper())

    @Bean
    fun objectMapper() : ObjectMapper = ObjectMapper().registerKotlinModule()

}