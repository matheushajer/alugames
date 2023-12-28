package br.com.matheushajer.alugames.modelo.plano

import br.com.matheushajer.alugames.modelo.aluguel.Aluguel

class PlanoAvulso(tipo: String) : Plano(tipo) {


    override fun obterValorDoAluguel(aluguel: Aluguel): Double {

        return aluguel.jogo.preco * aluguel.periodo.valorEmDias

    }


}
