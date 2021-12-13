package br.com.zup.ticket

import io.micronaut.core.annotation.AnnotationValue
import io.micronaut.validation.validator.constraints.ConstraintValidator
import io.micronaut.validation.validator.constraints.ConstraintValidatorContext
import jakarta.inject.Singleton
import java.time.LocalDateTime
import java.util.*
import javax.validation.Constraint


@MustBeDocumented
@Target(AnnotationTarget.FIELD, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [DataDeNascimentoValidator::class])
annotation class MaiorQue18 (
    val message: String = "Cliente precisa ter 18 anos ou mais !!"
)

@Singleton
class DataDeNascimentoValidator : ConstraintValidator<MaiorQue18, Date>{

    override fun isValid(
        value: Date,
        annotationMetadata: AnnotationValue<MaiorQue18>,
        context: ConstraintValidatorContext
    ): Boolean {

        if (value==null) {
            return true
        }
        return calculoIdade(value)>18
    }

    fun calculoIdade(dataNascimento: Date): Int {
        val hoje = Calendar.getInstance()
        var idade: Int = hoje[Calendar.YEAR] - dataNascimento.year
        // se ainda não chegou o aniversário, diminui 1 ano
        val mesAtual = hoje[Calendar.MONTH] + 1
        if (mesAtual == dataNascimento.month && hoje[Calendar.DAY_OF_MONTH] < dataNascimento.day
            || mesAtual < dataNascimento.month
        ) {
            idade--
        }
        return idade
    }
}

