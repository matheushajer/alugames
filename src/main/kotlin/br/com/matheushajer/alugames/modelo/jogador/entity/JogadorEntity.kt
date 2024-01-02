package br.com.matheushajer.alugames.modelo.jogador.entity

import javax.persistence.*

@Entity
@Table(name = "jogadores")
class JogadorEntity(
    val nome: String = "Nome",
    val email: String = "email@email.com",
    val dataNascimento: String? = "01/01/2000",
    val usuario: String? = "User",

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0
) {
}