package br.com.matheushajer.alugames.modelo.jogador

import kotlin.random.Random

data class Jogador(var nome: String, var email: String ) {

    var dataNascimento: String? = null

    var usuario: String? = null
        set(value){
            field = value
            if (idInterno.isNullOrBlank()){
                criarIdInterno()
            }
        }

    var idInterno: String? = null
        private set



    //Construtores
    constructor(nome: String, email: String, dataNascimento: String, usuario: String): this(nome, email){
        this.dataNascimento = dataNascimento
        this.usuario = usuario
        criarIdInterno()
    }



    //Métodos
    /**
     * Método para criação do idInterno do Jogador
     */
    fun criarIdInterno(){
        val numero = Random.nextInt(10000)
        val tag = String.format("%04d", numero)

        idInterno = "$usuario#$tag"
    }





    override fun toString(): String {
        return "Dados do usuário: \n" +
                "(Nome: $nome, E-mail: $email, Data de Nascimento: $dataNascimento, Usuário=$usuario, idInterno=$idInterno)"
    }

}