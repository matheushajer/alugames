import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.*

const val URL_API_GAMES = "https://www.cheapshark.com/api/1.0/games?id="

fun main() {

    val leitura = Scanner(System.`in`)

    print("Digite o código do jogo desejado: ")
    val busca = leitura.nextLine()

    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create(URL_API_GAMES + busca)).build()

    val response = client.send(request, BodyHandlers.ofString())

    val json = response.body()

    val gson = Gson()

    var meuJogo:Jogo? = null

    val resultadoDaBusca = runCatching {

        val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)
        meuJogo = Jogo(meuInfoJogo.info.title, meuInfoJogo.info.thumb)

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