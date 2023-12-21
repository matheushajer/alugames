import com.google.gson.annotations.SerializedName

class Jogo(
    @SerializedName("title") val titulo: String,
    @SerializedName("thumb") val capa: String,
    val descricao: String) {

    override fun toString(): String {
        return "Dados do Jogo: \n \n" +
                "Titulo: $titulo \n" +
                "Capa: $capa \n" +
                "Descricao: $descricao"
    }


}