package br.com.zup.carro

import io.micronaut.data.model.Pageable
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated
import javax.transaction.Transactional

@Validated
@Controller("/carros")
class BuscaCarrosController (val carroRepository: CarroRepository) {


    // Resposta em HTML
//    @Produces(MediaType.TEXT_HTML)
//    @Get(value = "/xml")
//    fun listaHtml(): String {
//
//        // pegar do banco de dados
//
//        val carros = carroRepository.findAll()
//
//        // conversao para um dto de saída
//
//        val retorno = carros.map { carro -> DetalhesDoCarroResponse(carro) }
//
//        return "<html><title><h1>HTML</h1></title><body>${retorno.toString()}</body></html>"
//    }

//    @Get
//    fun listaJson() : HttpResponse<Any>{
//
//        // pegar do banco de dados
//
//        val carros = carroRepository.findAll()
//
//        // conversao para um dto de saída
//
//        val retorno = carros.map { carro -> DetalhesDoCarroResponse(carro) }
//
//        // retornar essa lista como JSON
//        println(retorno)
//        return HttpResponse.ok(retorno)
//    }

      //placas?placa=CAO1A94
    @Get
   @Transactional
    fun lista(@QueryValue(defaultValue = "") placa: String) : HttpResponse<Any> {

        if (placa.isBlank()) {
            val carros = carroRepository.findAll()
            val resposta = carros.map { carro -> DetalhesDoCarroResponse(carro.placa, carro.modelo)}
            return HttpResponse.ok(resposta)
        }

        val possivelCarro = carroRepository.buscaPorPlaca(placa)
        if (possivelCarro.isEmpty) {
            return HttpResponse.notFound()
        }

        val carro = possivelCarro.get()

        return HttpResponse.ok(carro)
    }

//    // Testando busca paginada - Não funcionou bem Tem que rever a busca no repository
//    @Get("/{placa}")
////    @Transactional
//    fun lista(@PathVariable placa: String) : HttpResponse<Any> {
//
//        val possivelCarro: Pageable = carroRepository.findAllByPlacaOrderByModeloAsc(placa)
//
////        val carro = possivelCarro.ge;
//
//        return HttpResponse.ok(DetalhesDoCarroResponse(possivelCarro))
//    }
}