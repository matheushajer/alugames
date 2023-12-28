package br.com.matheushajer.alugames.modelo.recomendacao

interface Recomendavel {

    val media: Double


    /**
     * Método para atribuir uma nota ao Jogo e Jogador
     * @param nota
     */
    fun recomendar(nota: Int)

}