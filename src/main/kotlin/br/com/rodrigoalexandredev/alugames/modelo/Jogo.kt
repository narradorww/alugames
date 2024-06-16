package br.com.rodrigoalexandredev.alugames.modelo

data class Jogo(val titulo:String, val capa: String)   {

    var descricao:String? = null
    override fun toString(): String {
        return "Meu br.com.rodrigoalexandredev.alugames.modelo.Jogo:\n" +
                "Título: '$titulo' \n" +
                "Capa'$capa' \n" +
                "Descrição '$descricao'"
    }
}