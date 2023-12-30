package br.com.matheushajer.alugames.modelo.jogo

import br.com.matheushajer.alugames.modelo.recomendacao.Recomendavel
import com.google.gson.annotations.Expose

data class Jogo(@Expose val titulo: String, @Expose val capa: String): Recomendavel {

    var id : Int = 0
    var descricao: String? = null
    var preco : Double = 0.0

    private val listaDeNotas = mutableListOf<Int>()

    override val media: Double
        get() = listaDeNotas.average()

    //////////////////////
    //Construtores
    //////////////////////

    constructor(titulo: String, capa: String, preco: Double, descricao: String, id: Int = 0) : this (titulo, capa){
        this.descricao = descricao
        this.preco = preco
        this.id = id
    }

    //////////////////////
    //Métodos
    //////////////////////

    /**
     * Método para atribuir uma nota ao Jogo
     * @param nota
     */
    override fun recomendar(nota: Int) {

        if(nota in 1..10){
            listaDeNotas.add(nota)
        } else{
            println("A nota $nota esta inválida, inserir uma nova válida!")
        }
    }

    override fun toString(): String {
        return "Dados do Jogo: \n" +
                "Titulo: $titulo \n" +
                "Capa: $capa \n" +
                "Preço: R$$preco \n" +
                "Descricao: $descricao \n" +
                "Nota: $media"
    }


}