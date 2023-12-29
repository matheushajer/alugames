package br.com.matheushajer.alugames.servicos

import br.com.matheushajer.alugames.modelo.jogador.InfoJogadorJson
import br.com.matheushajer.alugames.modelo.jogador.Jogador
import br.com.matheushajer.alugames.modelo.jogo.InfoJogo
import br.com.matheushajer.alugames.modelo.jogo.InfoJogoJson
import br.com.matheushajer.alugames.modelo.jogo.Jogo
import br.com.matheushajer.alugames.utils.converterParaJogador
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import converterParaJogo
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

const val URL_API_GAMES_BY_ID = "https://www.cheapshark.com/api/1.0/games?id="
const val URL_API_JOGADORES = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"
const val URL_API_JOGOS = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"

class ConsumoAPI {

    /**
     * Método para efetuar a chamada das APIs
     * Devolvendo o retorno no formado String
     * @param endereco
     * @return reponse com os dados do Json
     */
    private fun consomeDadosApi(endereco: String): String {
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco)).build()

        val response = client.send(request, HttpResponse.BodyHandlers.ofString())

        return response.body()
    }

    /**
     * Método para busca dos dados de Jogos da API, recebe um InfoJogo
     * e converte para um objeto do tipo Jogo.
     * Pesquisa é efetuada pelo id do Jogo
     * @param id
     * @return Jogo com os dados do Jogo
     */
    fun buscarjogo(id: String): InfoJogo {

        val json = consomeDadosApi(URL_API_GAMES_BY_ID + id)

        val gson = Gson()

        return gson.fromJson(json, InfoJogo::class.java)

    }

    /**
     * Método para busca dos dados de Jogadores da API, recebe um InfoJogadorJson
     * e converte para um objeto do tipo Jogador
     * @return listaJogadorConvertida com os dados dos Jogadores
     */
    fun buscarJogadaor(): List<Jogador> {

        val json = consomeDadosApi(URL_API_JOGADORES)
        val gson = Gson()
        val tipoJogador = object : TypeToken<List<InfoJogadorJson>>() {}.type

        val listaDeJogadores: List<InfoJogadorJson> = gson.fromJson(json, tipoJogador)

        val listaJogadorConvertida = listaDeJogadores.map { infoJogadorJson ->
            infoJogadorJson.converterParaJogador()
        }

        return listaJogadorConvertida

    }

    /**
     * Método que busca a lista de jogos da API
     */
    fun buscarJogos(): List<Jogo>{

        val json = consomeDadosApi(URL_API_JOGOS)
        val gson = Gson()

        val tipoJogo = object : TypeToken<List<InfoJogoJson>>() {}.type

        val listaDeJogos: List<InfoJogoJson> = gson.fromJson(json, tipoJogo)

        val listaJogosConvertiva = listaDeJogos.map { infoJogoJson ->
            infoJogoJson.converterParaJogo()
        }

        return listaJogosConvertiva

    }


}