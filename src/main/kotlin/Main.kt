import com.google.gson.Gson
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

    val gson = Gson()

    val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)

    val meuJogo = Jogo(meuInfoJogo.info.title, meuInfoJogo.info.thumb, "Descrição teste")

    println("=================")
    println(meuJogo)




}