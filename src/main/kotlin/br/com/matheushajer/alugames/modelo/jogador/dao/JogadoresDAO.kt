package br.com.matheushajer.alugames.modelo.jogador.dao

import br.com.matheushajer.alugames.dados.dao.DAO
import br.com.matheushajer.alugames.modelo.jogador.Jogador
import br.com.matheushajer.alugames.modelo.jogador.entity.JogadorEntity
import javax.persistence.EntityManager

class JogadoresDAO(manager: EntityManager) : DAO<Jogador, JogadorEntity>(manager, JogadorEntity::class.java) {

    override fun toEntity(objeto: Jogador): JogadorEntity {
        return JogadorEntity(objeto.nome, objeto.email, objeto.dataNascimento, objeto.usuario, objeto.id)
    }

    override fun toModel(entity: JogadorEntity): Jogador {
        return Jogador(entity.nome, entity.email, entity.dataNascimento, entity.usuario, entity.id)
    }


}