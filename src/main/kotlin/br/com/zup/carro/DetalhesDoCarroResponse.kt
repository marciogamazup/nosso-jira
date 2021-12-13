package br.com.zup.carro

import io.micronaut.core.annotation.Introspected
import io.micronaut.data.model.Pageable
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Introspected
data class DetalhesDoCarroResponse(@field:NotBlank val placa: String,
                              @field:NotBlank @field:Size(max=60) val modelo: String){


    fun paraCarro() :Carro{
        return Carro(placa, modelo)
    }
//
//    override fun toString(): String {
//        return "DetalhesDoCarroResponse(placa='$placa', modelo='$modelo')"
//    }
}
