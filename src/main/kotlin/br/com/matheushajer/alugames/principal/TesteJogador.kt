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
    }

    println()
    println(jogador1)

    println()
    jogador1.usuario = "Hajer"
    println(jogador1)


}