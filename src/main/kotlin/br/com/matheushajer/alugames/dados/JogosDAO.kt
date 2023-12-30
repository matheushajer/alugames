package br.com.matheushajer.alugames.dados

import br.com.matheushajer.alugames.modelo.jogo.Jogo
import javax.persistence.EntityManager

class JogosDAO(val manager: EntityManager) {

    /**
     * Método que cria uma lista com todos os Jogos cadastrados no banco
     */
    fun getJogos(): List<Jogo> {

        val query = manager.createQuery("FROM JogoEntity", JogoEntity::class.java)
        return query.resultList.map { jogoEntity ->
            Jogo(
                jogoEntity.titulo, jogoEntity.capa, jogoEntity.preco,
                jogoEntity.descricao, jogoEntity.id
            )
        }


    }

    /**
     * Método para insersão de um Jogo no banco
     * @param jogo
     */
    fun adicionarJogo(jogo: Jogo) {

        val entity = jogo.descricao?.let { JogoEntity(jogo.titulo, jogo.capa, jogo.preco, it) }

        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()

    }

}