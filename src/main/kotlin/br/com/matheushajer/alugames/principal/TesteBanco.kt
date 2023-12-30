package br.com.matheushajer.alugames.principal

import br.com.matheushajer.alugames.dados.Banco
import br.com.matheushajer.alugames.dados.JogosDAO
import br.com.matheushajer.alugames.modelo.jogo.Jogo

fun main() {

    val manager = Banco.getEntityManager()
    val jogoDAO = JogosDAO(manager)

    val jogo = Jogo("Dandara", "https://cdn.cloudflare.steamstatic.com/steam/apps/612390/header.jpg?t=1674055293", 9.99,"Um jogo de plataforma e ação com elementos de metroidvania, onde você controla a heroína Dandara em sua luta para libertar um mundo repleto de opressão e tirania.")


    jogoDAO.adicionarJogo(jogo)

    val listaJogos: List<Jogo> = jogoDAO.getJogos()

    listaJogos.forEach{
        println()
        println(it)
    }

    manager.close()

}