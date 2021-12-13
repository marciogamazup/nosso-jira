package br.com.zup.ticket

import io.micronaut.core.annotation.Introspected
import java.time.LocalDateTime
import java.util.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Introspected
class NovoTicketRequest(
    @field:NotBlank @field:Size(max = 60) val titulo: String,
    @field:NotBlank @field:Size(max = 4000) val descricao: String,
) {

    fun paraTicket(): Ticket {

        return Ticket(titulo, descricao)
    }
}


