package br.com.zup.carro

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Put
import io.micronaut.validation.Validated

@Validated
@Controller("/carros")
class AtualizaCarroController (val carroRepository: CarroRepository)  {

    @Put("/{id}")
    fun atualiza(@PathVariable id: Long, modelo: String) : HttpResponse<Any>{
        // buscar o objeto no banco
        val possivelCarro = carroRepository.findById(id)

        if (possivelCarro.isEmpty) {
            return HttpResponse.notFound()
        }
        // atualizar o campo

        val carro = possivelCarro.get()

        carro.modelo = modelo
        carroRepository.update(carro)

        // retornar ok

        return HttpResponse.ok(carro.toString())

    }
}