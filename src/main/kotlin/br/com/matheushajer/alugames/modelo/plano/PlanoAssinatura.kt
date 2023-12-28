package br.com.matheushajer.alugames.modelo.plano

import br.com.matheushajer.alugames.modelo.aluguel.Aluguel

class PlanoAssinatura(
    tipo: String, val mensalidade: Double, val quantidadeDeJogosIncluidos: Int,
    val percentualDescontoReputacao: Double
) : Plano(tipo) {

    override fun obterValorDoAluguel(aluguel: Aluguel): Double {

        val totalJogosAlugadosNoMes = aluguel.jogador.jogosAlugadosNoMes(
            aluguel.periodo.dataInicial.monthValue
        ).size + 1

        return if (totalJogosAlugadosNoMes <= quantidadeDeJogosIncluidos) {
            0.0
        } else {
           var valorOriginal =  super.obterValorDoAluguel(aluguel)

            if (aluguel.jogador.media >= 8){
                valorOriginal -= valorOriginal * percentualDescontoReputacao
            }
            valorOriginal
        }

    }

}
