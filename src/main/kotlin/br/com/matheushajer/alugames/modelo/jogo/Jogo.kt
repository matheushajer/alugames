package br.com.matheushajer.alugames.modelo.jogo

data class Jogo(val titulo: String, val capa: String) {

    var descricao: String? = null
    var preco : Double = 0.0

    //////////////////////
    //Construtores
    //////////////////////

    constructor(titulo: String, capa: String, descricao: String, preco: Double) : this (titulo, capa){
        this.descricao = descricao
        this.preco = preco
    }

    override fun toString(): String {
        return "Dados do Jogo: \n" +
                "Titulo: $titulo \n" +
                "Capa: $capa \n" +
                "Preço: R$$preco \n" +
                "Descricao: $descricao"
    }


}