package br.com.zup.carro

import io.micronaut.data.annotation.Query
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import java.util.*
import kotlin.contracts.CallsInPlace

@Repository
interface CarroRepository : JpaRepository<Carro, Long>{

    fun existsByPlaca(placa: String): Boolean

    @Query("SELECT c FROM Carro c WHERE c.placa = :placa")
    fun buscaPorPlaca(placa: String): Optional<Carro>


//    fun  findByPlaca(placa: String): Optional<Carro>  // isso funciona


//    fun findAllByPlacaOrderByModeloAsc(placa: String): Pageable
}