package br.com.matheushajer.alugames.modelo.jogador

import br.com.matheushajer.alugames.modelo.jogo.Jogo
import java.util.*
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

    val jogosPesquisados = mutableListOf<Jogo?>()

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
    private fun validarEmail(): String {

        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")

        if (regex.matches(email)) {
            return email
        } else {
            throw IllegalArgumentException("E-mail informado é inválido")
        }

    }

    init {

        if (nome.isBlank()) {
            throw IllegalArgumentException("Campo nome obrigatório")
        }

        this.email = validarEmail()

    }

    override fun toString(): String {
        return "Dados do usuário: \n" +
                "(Nome: $nome, E-mail: $email, Data de Nascimento: $dataNascimento, Usuário=$usuario, idInterno=$idInterno)"
    }

    //////////////////////
    //Métodos staticos
    //////////////////////
    companion object {

        fun criarJogador(leitura: Scanner): Jogador {

            println("************************************************")
            println("*             Bem-vindo ao AluGames            *")
            println("*      Inseria as informações de cadastro      *")
            println("************************************************")
            print("Informe seu nome: ")
            val nome = leitura.nextLine()

            print("Informe seu E-mail: ")
            val email = leitura.nextLine()

            print("Deseja informar seu usuário e data de nascimento (S/N)? ")
            val opcao = leitura.nextLine()

            if (opcao.equals("s", true)) {
                print("Informe sua data de nascimento: ")
                val dataNascimento = leitura.nextLine()

                print("Informe seu nome de usuário: ")
                val nomeUsuario = leitura.nextLine()

                val dadosUsuario = Jogador(nome, email, dataNascimento, nomeUsuario)

                println("Cadastro concluído com sucesso!")

                return dadosUsuario
            } else {

                val dadosUsuario = Jogador(nome, email)

                println("Cadastro concluído com sucesso!")

                return dadosUsuario

            }


        }

    }

}