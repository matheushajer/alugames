package br.com.matheushajer.alugames.modelo.aluguel

import br.com.matheushajer.alugames.modelo.jogador.Jogador
import br.com.matheushajer.alugames.modelo.jogo.Jogo

data class Aluguel(
    val jogador: Jogador, val jogo: Jogo, val periodo: Periodo) {

    var id : Int = 0
    val valorDoAlguel = jogador.plano.obterValorDoAluguel(this)

    override fun toString(): String {
        return "Dados do Aluguel \n" +
                "Usuário: ${jogador.nome}, Jogo Alugado: ${jogo.titulo} \n" +
                "Valor total do aluguel: R$$valorDoAlguel"
    }
}