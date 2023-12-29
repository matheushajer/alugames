package br.com.matheushajer.alugames.modelo.plano

import br.com.matheushajer.alugames.modelo.aluguel.Aluguel

sealed class Plano(val tipo: String, var id : Int = 0) {

    /**
     * Método para calcular o valor pago ao alugar jogos
     * @param aluguel
     * @return um Double representando o valor total a serpago
     */
    open fun obterValorDoAluguel(aluguel: Aluguel): Double {
        return aluguel.jogo.preco * aluguel.periodo.valorEmDias
    }

}
