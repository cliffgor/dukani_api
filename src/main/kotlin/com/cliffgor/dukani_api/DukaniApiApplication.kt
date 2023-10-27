package com.cliffgor.dukani_api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class DukaniApiApplication

fun main(args: Array<String>) {
    runApplication<DukaniApiApplication>(*args)
}
