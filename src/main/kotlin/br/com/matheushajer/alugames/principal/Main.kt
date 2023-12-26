package br.com.matheushajer.alugames.principal

import br.com.matheushajer.alugames.modelo.Jogo
import br.com.matheushajer.alugames.servicos.ConsumoAPI
import java.util.*

fun main() {

    val leitura = Scanner(System.`in`)

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

        if (opcao.equals("s", true)){
            println()
            print("Digite a descrição: ")
            meuJogo?.descricao = leitura.nextLine()

        }else{
            meuJogo?.descricao = meuJogo?.titulo
        }

    }

    println()
    println(meuJogo)

}