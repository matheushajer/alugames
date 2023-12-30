package br.com.matheushajer.alugames.dados

import br.com.matheushajer.alugames.modelo.jogo.Jogo
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object Banco {

    fun obterConexao(): Connection? {
        return try {
            DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/alugames",
                "root", "admin123"
            )
        } catch (e: SQLException) {
            e.printStackTrace()
            null
        }
    }

}