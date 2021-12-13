package br.com.zup.carro

import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.uri.UriBuilder
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller("/carros")
class NovoCarroController (val carroRepository: CarroRepository){

    @Post
    fun cadastra(@Body @Valid request: NovoCarroRequest) :MutableHttpResponse<Any>? {

        val carro = request.paraCarro()

        carroRepository.save(carro)

//        Nesse formato devolve um header com informações do id do carro criado
        val uri = UriBuilder.of("/carros/{id}").expand(mutableMapOf(Pair("id",carro.id)))
        return HttpResponse.created(uri)


//        Nesse formato devolve um Json no header mas sem muitas informações
//        return HttpResponse.created(request)
    }
}