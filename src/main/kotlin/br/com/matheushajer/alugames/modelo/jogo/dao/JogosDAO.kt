package br.com.matheushajer.alugames.modelo.jogo.dao

import br.com.matheushajer.alugames.dados.dao.DAO
import br.com.matheushajer.alugames.modelo.jogo.Jogo
import br.com.matheushajer.alugames.modelo.jogo.entity.JogoEntity
import javax.persistence.EntityManager

class JogosDAO(manager: EntityManager) : DAO<Jogo, JogoEntity>(manager, JogoEntity::class.java) {

    override fun toEntity(objeto: Jogo): JogoEntity {
        return JogoEntity(objeto.titulo, objeto.capa, objeto.preco, objeto.descricao, objeto.id)
    }

    override fun toModel(entity: JogoEntity): Jogo {
        return Jogo(entity.titulo, entity.capa, entity.preco, entity.descricao, entity.id)
    }


}