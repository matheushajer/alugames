package br.com.matheushajer.alugames.modelo.aluguel

import java.time.LocalDate
import java.time.Period

data class Periodo(
    val dataInicial: LocalDate, val dataFinal: LocalDate){

    val valorEmDias = Period.between(dataInicial, dataFinal).days


}
