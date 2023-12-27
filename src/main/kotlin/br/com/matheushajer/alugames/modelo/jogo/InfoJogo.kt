package br.com.matheushajer.alugames.modelo.jogo

import br.com.matheushajer.alugames.modelo.api.InfoApiShark

data class InfoJogo(val info: InfoApiShark) {

    override fun toString(): String {
        return info.toString()
    }
}