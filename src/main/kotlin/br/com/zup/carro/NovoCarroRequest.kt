package br.com.zup.carro

import io.micronaut.core.annotation.Introspected
import javax.persistence.Column
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

@Introspected
data class NovoCarroRequest(@field:NotBlank
                        @field:Pattern(regexp = "[A-Z]{3}[0-9][0-9A-Z][0-9]{2}")
                       val placa: String,
                       @field:NotBlank @field:Size(max=60) val modelo: String)
{
    fun paraCarro(): Carro {
        return Carro(placa, modelo)
    }
}