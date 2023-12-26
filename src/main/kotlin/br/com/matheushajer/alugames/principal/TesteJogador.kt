import br.com.matheushajer.alugames.modelo.jogador.Jogador

fun main() {

    val jogador1 = Jogador("Jogador um", "jogador1@email.com")
    println(jogador1)

    println()

    val jogador2 = Jogador("Jogador dois", "jogador2@email.com", "01/01/1997",
        "SuperJogador2")
    println(jogador2)

    jogador1.let {
        it.dataNascimento = "01/01/2000"
        it.usuario = "Jogador1_Super"
        it.idInterno = "Jogador1_Super#12356"
    }

    println()
    println(jogador1)


}