package br.com.matheushajer.alugames.dados;

import javax.persistence.*

@Entity
@Table(name = "jogos")
class JogoEntity(val titulo: String = "Titulo",
                 val capa: String = "Capa",
                 val preco: Double = 0.0,
                 val descricao: String = "Descrição",

                 @Id
                 @GeneratedValue(strategy = GenerationType.IDENTITY)
                 val id: Int = 0) {


}
