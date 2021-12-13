package br.com.zup

import br.com.zup.carro.Carro
import br.com.zup.carro.CarroRepository
import io.micronaut.test.annotation.TransactionMode
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@MicronautTest(
    rollback = false,
    transactionMode = TransactionMode.SINGLE_TRANSACTION,  // TransactionMode.SEPARATE_TRANSACTIONS
    transactional = false
)
class CarrosGrpcTest {

    @Inject
    lateinit var repository: CarroRepository

    @BeforeEach
    internal fun setUp() {
        repository.deleteAll()
    }

    @AfterEach
    internal fun tearDown() {
        repository.deleteAll()
    }

    @Test
    fun `deve inserir um novo carro`() {
        // cenário // @BeforeEach


        // ação
        repository.save(Carro(modelo = "Gol", placa = "HPX-1234"))

        // validação
        Assertions.assertEquals( 1, repository.count())
    }

    @Test
    fun `deve encontrar carro por placa`() {
        // cenário
        repository.save(Carro(modelo = "Palio", placa = "OIP-9876"))

        // ação
        val encontrado = repository.existsByPlaca("OIP-9876")

        // validação
        Assertions.assertTrue(encontrado)
    }
}