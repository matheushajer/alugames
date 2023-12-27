package br.com.matheushajer.alugames.servicos

import br.com.matheushajer.alugames.modelo.jogador.InfoJogadorJson
import br.com.matheushajer.alugames.modelo.jogo.InfoJogo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

const val URL_API_GAMES = "https://www.cheapshark.com/api/1.0/games?id="
const val URL_API_JOGADORES = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"

class ConsumoAPI {

    fun buscarjogo(id: String): InfoJogo {

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(URL_API_GAMES + id)).build()

        val response = client.send(request, HttpResponse.BodyHandlers.ofString())

        val json = response.body()
        val gson = Gson()

        return gson.fromJson(json, InfoJogo::class.java)

    }

    fun buscarJogadaor(): List<InfoJogadorJson> {

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(URL_API_JOGADORES)).build()

        val response = client.send(request, HttpResponse.BodyHandlers.ofString())

        val json = response.body()
        val gson = Gson()
        val tipoJogador = object : TypeToken<List<InfoJogadorJson>>() {}.type

        return gson.fromJson(json, tipoJogador)

    }


}