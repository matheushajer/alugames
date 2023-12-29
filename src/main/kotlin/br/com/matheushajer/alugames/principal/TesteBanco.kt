package br.com.matheushajer.alugames.principal

import br.com.matheushajer.alugames.dados.Banco
import br.com.matheushajer.alugames.modelo.jogo.Jogo

fun main() {

    val listaJogos: List<Jogo> = Banco.getJogos()

    println(listaJogos)


}