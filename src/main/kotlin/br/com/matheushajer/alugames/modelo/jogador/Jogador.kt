package br.com.matheushajer.alugames.modelo.jogador

import br.com.matheushajer.alugames.modelo.aluguel.Aluguel
import br.com.matheushajer.alugames.modelo.aluguel.Periodo
import br.com.matheushajer.alugames.modelo.jogo.Jogo
import br.com.matheushajer.alugames.modelo.plano.Plano
import br.com.matheushajer.alugames.modelo.plano.PlanoAvulso
import br.com.matheushajer.alugames.modelo.recomendacao.Recomendavel
import java.util.*
import kotlin.random.Random

data class Jogador(var nome: String, var email: String) : Recomendavel {

    var id : Int = 0
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

    var plano: Plano = PlanoAvulso("BRONZE")
    val jogosPesquisados = mutableListOf<Jogo?>()
    val jogosAlugados = mutableListOf<Aluguel>()
    private val listaDeNotas = mutableListOf<Int>()
    val jogosRecomendados = mutableListOf<Jogo>()

    override val media: Double
        get() = listaDeNotas.average()

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
     * Método para validar se o endereço eletrónico informado é válido
     */
    private fun validarEmail(): String {

        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")

        if (regex.matches(email)) {
            return email
        } else {
            throw IllegalArgumentException("E-mail informado é inválido")
        }

    }

    /**
     * Método para a função alugar um jogo
     * @return um objeto do tipo Aluguel, com os dados do jogador e
     * do Jogo alugado
     */
    fun alugarJogo(jogo: Jogo, periodo: Periodo): Aluguel {

        val aluguel = Aluguel(this, jogo, periodo)
        jogosAlugados.add(aluguel)

        return aluguel

    }

    /**
     * Método para filtrar os jogos alugados em determinado mês
     * @param mes
     * @return uma lista de Jogo, com os jogos do mes informado
     */
    fun jogosAlugadosNoMes(mes: Int): List<Jogo> {

        return jogosAlugados.filter {
            it.periodo.dataInicial.monthValue == mes
        }.map {
            it.jogo
        }
    }

    /**
     * Método para atribuir uma nota ao Jogador
     * @param nota
     */
    override fun recomendar(nota: Int) {

        if(nota in 1..10){
            listaDeNotas.add(nota)
        } else{
            println("A nota $nota esta inválida, inserir uma nova válida!")
        }
    }

    /**
     * Método para efetuar recomendação de um Jogo e atribuir uma nota
     * @param jogo
     * @param nota
     */
    fun recomendarJogo(jogo: Jogo, nota: Int){
        jogo.recomendar(nota)
        jogosRecomendados.add(jogo)
    }

    //////////////////////
    //init
    //////////////////////
    init {

        if (nome.isBlank()) {
            throw IllegalArgumentException("Campo nome obrigatório")
        }

        this.email = validarEmail()

    }

    override fun toString(): String {
        return "Dados do usuário: \n" +
                "(Nome: $nome, E-mail: $email, Data de Nascimento: $dataNascimento, " +
                "Usuário=$usuario, idInterno=$idInterno) \n" +
                "Reputação: $media"
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