package br.com.matheushajer.alugames.dados.dao

import javax.persistence.EntityManager

abstract class DAO<TModel, TEntity>(protected val manager: EntityManager, protected val entityType: Class<TEntity>) {

    abstract fun toEntity(objeto: TModel): TEntity
    abstract fun toModel(entity: TEntity): TModel

    /**
     * Método que cria uma lista com todos os cadastros de um objeto no banco
     */
    open fun getLista(): List<TModel> {

        val query = manager.createQuery("FROM ${entityType.simpleName}", entityType)
        return query.resultList.map { entity -> toModel(entity) }

    }

    /**
     * Método para insersão de um objeto no banco
     * @param objeto
     */
    open fun adicionar(objeto: TModel) {

        val entity = toEntity(objeto)

        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }

    /**
     * Método que busca um registro no banco pelo id
     * @param id
     */
    open fun recuperarById(id: Int): TModel {

        val query = manager.createQuery("FROM ${entityType.simpleName} WHERE id=:id", entityType)
        query.setParameter("id", id)

        val entity = query.singleResult

        return toModel(entity)

    }

    /**
     * Método que remove um registro do banco pelo id
     * @param id
     */
    open fun apagar(id: Int) {

        val query = manager.createQuery("FROM ${entityType.simpleName} WHERE id=:id", entityType)
        query.setParameter("id", id)

        val entity = query.singleResult

        manager.transaction.begin()
        manager.remove(entity)
        manager.transaction.commit()

    }

}