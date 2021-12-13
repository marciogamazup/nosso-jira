package br.com.zup.ticket

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*
import javax.validation.constraints.PastOrPresent

@Entity
class Ticket (
    @Column(nullable = false, length = 60)
    val titulo: String,
    @Column(nullable = false, length = 4000)
    val descricao: String)
    {
    @Id
    @GeneratedValue
    var id: Long?=null
    @Enumerated(EnumType.STRING)
    val status: Status = Status.ABERTO
    @PastOrPresent
    val dataCriacao: LocalDateTime = LocalDateTime.now()


}