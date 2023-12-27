package br.com.matheushajer.alugames.principal

import br.com.matheushajer.alugames.modelo.jogo.Jogo
import br.com.matheushajer.alugames.modelo.jogador.Jogador
import br.com.matheushajer.alugames.servicos.ConsumoAPI
import transformarEmIdade
import java.util.*

fun main() {

    val leitura = Scanner(System.`in`)
    val jogador = Jogador.criarJogador(leitura)

    println(jogador)
    println("Idade  do usuário: " + jogador.dataNascimento?.transformarEmIdade())

    do {

        println("************************************************")
        print("Digite o código do jogo desejado: ")
        val busca = leitura.nextLine()

        val buscaApi = ConsumoAPI()
        val dadosJogo = buscaApi.buscarjogo(busca)

        var meuJogo: Jogo? = null
        val resultadoDaBusca = runCatching {

            meuJogo = Jogo(dadosJogo.info.title, dadosJogo.info.thumb)

        }

        resultadoDaBusca.onFailure {
            println("ID não encontrado, informar um ID valido!")
        }

        resultadoDaBusca.onSuccess {

            println("Deseja inserir uma descrição para o jogo? S/N")
            val opcao = leitura.nextLine()

            if (opcao.equals("s", true)) {
                println("************************************************")
                print("Digite a descrição: ")
                meuJogo?.descricao = leitura.nextLine()

            } else {
                meuJogo?.descricao = meuJogo?.titulo
            }

            jogador.jogosPesquisados.add(meuJogo)
        }

        print("Deseja procurar por um novo jogo? S/N: ")
        val resposta = leitura.nextLine()

    } while (resposta.equals("s", true))

    jogador.jogosPesquisados.sortBy {
        it?.titulo
    }

    println("************************************************")
    println("Jogos Pesquisados: ")
    println(jogador.jogosPesquisados)

    println("Busca finalizada!")

    println("************************************************")
    println("Deseja remover algum jogo da lista (S/N)? ")

    if (leitura.nextLine().equals("s", true)) {
        println("Informe a posição do jogo a ser removido")
        jogador.jogosPesquisados.removeAt(leitura.nextInt())

        println("Remoção efetuada com sucesso!")

    }

    println("************************************************")
    println("Lista atualizada:")
    println(jogador.jogosPesquisados)


}