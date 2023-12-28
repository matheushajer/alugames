package br.com.matheushajer.alugames.modelo.plano

import br.com.matheushajer.alugames.modelo.aluguel.Aluguel

class PlanoAvulso(tipo: String) : Plano(tipo) {

    override fun obterValorDoAluguel(aluguel: Aluguel): Double {

        var valorOriginal = super.obterValorDoAluguel(aluguel)

        if (aluguel.jogador.media >= 8) {
            valorOriginal -= valorOriginal * 0.1
        }

        return valorOriginal

    }


}
