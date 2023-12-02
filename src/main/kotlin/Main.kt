import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

const val URL_API_GAMES = "https://www.cheapshark.com/api/1.0/games?id="

fun main() {

    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create(URL_API_GAMES + 612)).build()

    val response = client.send(request, BodyHandlers.ofString())

    val json = response.body()

    println(json)

    val meuJogo = Jogo()
    meuJogo.titulo = "jogo teste"
    meuJogo.capa = "url teste"

    println(meuJogo)


}