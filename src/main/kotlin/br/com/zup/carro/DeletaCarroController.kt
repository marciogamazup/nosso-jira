package br.com.zup.carro

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.PathVariable

@Controller("/carros")
class DeletaCarroController (val carroRepository: CarroRepository){


    @Delete("/{id}")
    fun deleta(@PathVariable id: Long) :HttpResponse<Any>{

        val possivelCarro = carroRepository.findById(id)
        if (possivelCarro.isEmpty()) {
            return HttpResponse.ok()
        }

        val carro = possivelCarro.get()
        carroRepository.delete(carro)

        //carroRepository.deleteById(id)

        return HttpResponse.ok()

    }

}