class Jogo(val titulo: String, var capa: String, val descricao: String) {

    override fun toString(): String {
        return "Dados do Jogo: \n \n" +
                "Titulo: $titulo \n" +
                "Capa: $capa \n" +
                "Descricao: $descricao"
    }


}