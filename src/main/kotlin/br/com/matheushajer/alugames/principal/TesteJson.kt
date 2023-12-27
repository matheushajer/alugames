package br.com.matheushajer.alugames.principal

import br.com.matheushajer.alugames.modelo.aluguel.Periodo
import br.com.matheushajer.alugames.servicos.ConsumoAPI
import java.time.LocalDate

fun main() {

    val consumo = ConsumoAPI()
    val listaDeJogadores = consumo.buscarJogadaor()
    val listaDeJogos = consumo.buscarJogos()

    val jogador1 = listaDeJogadores[2]
    val jogo1 = listaDeJogos[5]
    val jogo2 = listaDeJogos[6]

    val periodo = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(3))

    println(jogador1)
    println("************************************************")
    println(jogo1)

    val aluguel = jogador1.alugarJogo(jogo1, periodo)

    println("************************************************")
    println(aluguel)

    println("************************************************")
    val aluguel2 = jogador1.alugarJogo(jogo2, periodo2)
    println(aluguel2)

    println("************************************************")
    jogador1.jogosAlugados.forEach {
        println(it)
    }


}