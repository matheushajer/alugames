package br.com.matheushajer.alugames.principal

import br.com.matheushajer.alugames.dados.JogosDAO
import br.com.matheushajer.alugames.modelo.jogo.Jogo

fun main() {

    val jogoDAO = JogosDAO()

    val jogo = Jogo("Grand Theft Auto V",
        "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554", 2.99,
        "Um jogo de ação em mundo aberto, onde você pode assumir o papel de três protagonistas e " +
                "explorar uma cidade cheia de possibilidades.")

    jogoDAO.adicionarJogo(jogo)

    val listaJogos: List<Jogo> = jogoDAO.getJogos()

    listaJogos.forEach{
        println()
        println(it)
    }

}