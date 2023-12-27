package br.com.matheushajer.alugames.principal

import br.com.matheushajer.alugames.servicos.ConsumoAPI

fun main(){

    val consumo = ConsumoAPI()
    val listaJogadores = consumo.buscarJogadaor()

    listaJogadores.forEach{ jogador ->
        println(jogador)
    }

}