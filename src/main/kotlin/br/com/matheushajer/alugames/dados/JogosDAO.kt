package br.com.matheushajer.alugames.dados

import br.com.matheushajer.alugames.modelo.jogo.Jogo

class JogosDAO {

    /**
     * Método que cria uma lista com todos os Jogos cadastrados no banco
     */
    fun getJogos(): List<Jogo> {
        val listaJogos = mutableListOf<Jogo>()
        val conexao = Banco.obterConexao()

        if (conexao != null) {
            try {
                val statement = conexao.createStatement()
                val resultado = statement.executeQuery("SELECT * FROM JOGOS")

                while (resultado.next()) {
                    val id = resultado.getInt("id")
                    val titulo = resultado.getString("titulo")
                    val capa = resultado.getString("capa")
                    val descricao = resultado.getString("descricao")
                    val preco = resultado.getDouble("preco")

                    val jogo = Jogo(titulo, capa, preco, descricao, id)
                    listaJogos.add(jogo)
                }

                statement.close()
            } finally {
                conexao.close()
            }
        }

        return listaJogos
    }

    /**
     * Método para insersão de um Jogo no banco
     * @param jogo
     */
    fun adicionarJogo(jogo: Jogo) {

        val conexao = Banco.obterConexao()
        val insert = "INSERT INTO JOGOS (TITULO, CAPA, PRECO, DESCRICAO) VALUES (?, ?, ?, ?)"

       if (conexao != null){
           try {

               val statement = conexao.prepareStatement(insert)

               statement.setString(1, jogo.titulo)
               statement.setString(2, jogo.capa)
               statement.setDouble(3, jogo.preco)
               statement.setString(4, jogo.descricao)

               statement.executeUpdate()
               statement.close()
           } finally {
               conexao.close()
           }
       }


    }

}