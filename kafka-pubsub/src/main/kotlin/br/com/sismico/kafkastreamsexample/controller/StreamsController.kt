package br.com.sismico.kafkastreamsexample.controller

import br.com.sismico.kafkastreamsexample.producer.CustomerProducer
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class StreamsController(
    val clientProducer: CustomerProducer
) {

    @GetMapping("/version")
    fun version() = mapOf("version" to 1)

    @PostMapping("/user")
    fun user(
        @RequestParam username: String,
        @RequestParam fullname: String,
        @RequestParam document: String
    ) {
        clientProducer.send(username, fullname, document)
    }
    
    @PostMapping("/looping")
    fun looping() {
        for (i in 1..100) {
            clientProducer.send("Usuário ${i}", "Nome Completo ${i}", "${i}")
        }
    }

    @PostMapping("/looping-key")
    fun loopingKey() {
        for (x in 1..5) {
            for (y in 1..10) {
                clientProducer.send("Usuário ${y}", "Nome Completo ${y}", "${y}", "GROUP ${x}")
            }
        }
    }
}
