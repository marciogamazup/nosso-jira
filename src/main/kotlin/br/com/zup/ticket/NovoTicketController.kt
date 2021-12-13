package br.com.zup.ticket

import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller("/tickets")
class NovoTicketController(val ticketRepository: TicketRepository) {

    @Post
    fun cadastra(@Body @Valid request: NovoTicketRequest): MutableHttpResponse<Any>? {

        val ticket = request.paraTicket()

        println(ticket.titulo)
        ticketRepository.save(ticket)
        return HttpResponse.ok(request)

    }
}