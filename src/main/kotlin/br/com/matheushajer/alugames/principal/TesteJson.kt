package br.com.matheushajer.alugames.principal

import br.com.matheushajer.alugames.modelo.aluguel.Periodo
import br.com.matheushajer.alugames.modelo.plano.PlanoAssinatura
import br.com.matheushajer.alugames.servicos.ConsumoAPI
import java.time.LocalDate

fun main() {

    val consumo = ConsumoAPI()
    val listaDeJogadores = consumo.buscarJogadaor()
    val listaDeJogos = consumo.buscarJogos()

    // Jogadores
    val jogador1 = listaDeJogadores[2]
    val jogador2 = listaDeJogadores[1]

    // Jogos
    val jogo1 = listaDeJogos[5]
    val jogo2 = listaDeJogos[6]
    val jogo3 = listaDeJogos[9]
    val jogo4 = listaDeJogos[1]
    val jogo5 = listaDeJogos[10]

    val periodo = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(3))
    val periodo3 = Periodo(LocalDate.now().minusMonths(2),
        LocalDate.now().plusMonths(2).plusDays(8))
    val periodo4 = Periodo(LocalDate.now().plusMonths(4),
        LocalDate.now().plusMonths(4).plusDays(10))

    //Testes usando o jogador1
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

    //Testes usando o jogador2
    println("************************************************")
    jogador2.plano = PlanoAssinatura("PLATA", 9.90, 3)

    jogador2.alugarJogo(jogo3,periodo3)
    jogador2.alugarJogo(jogo5, periodo3)
    jogador2.alugarJogo(jogo4, periodo3)
    jogador2.alugarJogo(jogo1, periodo3)

    println("************************************************")
    jogador2.jogosAlugados.forEach {
        println(it)
        println()
    }



}