package br.com.matheushajer.alugames.modelo

data class Jogo(val titulo: String, val capa: String) {

    var descricao: String? = null

    override fun toString(): String {
        return "Dados do Jogo: \n \n" +
                "Titulo: $titulo \n" +
                "Capa: $capa \n" +
                "Descricao: $descricao"
    }


}