import br.com.matheushajer.alugames.modelo.jogo.InfoJogoJson
import br.com.matheushajer.alugames.modelo.jogo.Jogo


fun InfoJogoJson.converterParaJogo(): Jogo{

    return Jogo(this.titulo, this.capa, this.preco, this.descricao)

}