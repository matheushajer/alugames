package br.com.matheushajer.alugames.dados

import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

object Banco {

    /**
     * Método para criar conexão com o banco de dados
     */
    fun getEntityManager(): EntityManager{

        val factory: EntityManagerFactory = Persistence.createEntityManagerFactory("alugames")

        return  factory.createEntityManager()

    }



}