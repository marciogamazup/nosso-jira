package br.com.zup.carro

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.Pattern

@Entity
class Carro (@Column(nullable = false, unique = true)
             @Pattern(regexp = "[A-Z]{3}[0-9][0-9A-Z][0-9]{2}") val placa: String,
             @Column(nullable = false, length = 60) var modelo: String
) {
    @Id
    @GeneratedValue
    var id: Long?=null
}