package br.com.matheushajer.alugames.utils

import br.com.matheushajer.alugames.modelo.jogador.InfoJogadorJson
import br.com.matheushajer.alugames.modelo.jogador.Jogador

fun InfoJogadorJson.converterParaJogador(): Jogador {

    return Jogador(this.nome, this.email, this.dataNascimento, this.usuario)

}