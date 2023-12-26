package br.com.matheushajer.alugames.modelo.jogador

import java.lang.IllegalArgumentException
import kotlin.random.Random

data class Jogador(var nome: String, var email: String) {

    var dataNascimento: String? = null

    var usuario: String? = null
        set(value) {
            field = value
            if (idInterno.isNullOrBlank()) {
                criarIdInterno()
            }
        }

    var idInterno: String? = null
        private set

    //////////////////////
    //Construtores
    //////////////////////

    constructor(nome: String, email: String, dataNascimento: String, usuario: String) : this(nome, email) {
        this.dataNascimento = dataNascimento
        this.usuario = usuario
        criarIdInterno()
    }

    //////////////////////
    //Métodos
    //////////////////////

    /**
     * Método para criação do idInterno do Jogador
     */
    private fun criarIdInterno() {

        val numero = Random.nextInt(10000)
        val tag = String.format("%04d", numero)

        idInterno = "$usuario#$tag"

    }

    /**
     * Método para validar se o e-mail informado é válido
     */
    fun validarEmail(): String {

        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")

        if (regex.matches(email)) {
            return email
        } else {
            throw IllegalArgumentException("E-mail informado é inválido")
        }

    }

    init {

        if (nome.isBlank()){
            throw IllegalArgumentException("Campo nome obrigatório")
        }

        this.email = validarEmail()

    }

    override fun toString(): String {
        return "Dados do usuário: \n" +
                "(Nome: $nome, E-mail: $email, Data de Nascimento: $dataNascimento, Usuário=$usuario, idInterno=$idInterno)"
    }

}