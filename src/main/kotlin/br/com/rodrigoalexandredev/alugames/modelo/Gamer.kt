package br.com.rodrigoalexandredev.alugames.modelo

import java.util.*
import kotlin.random.Random

data class Gamer(var nome:String, var email: String ){
    var dataNascimento: String? = null
    var usuario: String? = null
        set(value){
            field = value
            if (idInterno.isNullOrBlank()){
                criarIdInterno()
            }
        }

    var idInterno: String? = null
        private set

    val jogosBuscados = mutableListOf<Jogo?>()

    constructor( nome: String, email: String, dataNascimento:String, usuario: String): this(nome, email){
        this.dataNascimento = dataNascimento
        this.usuario = usuario
        criarIdInterno() }

//    init{
//        this.email = validarEmail(this.email)
//        if (nome.isNullOrBlank()){
//            throw IllegalArgumentException("Nome está em vazio")
//        }
//    }


    override fun toString(): String {
        return "Gamer(nome='$nome', email='$email', dataNascimento=$dataNascimento, usuario=$usuario, idInterno=$idInterno)"
    }

    fun criarIdInterno(){
        val numero = Random.nextInt(10000)
        val tag = String.format("%d04d", numero)
        idInterno = "$usuario#$tag"
    }

    fun validarEmail(email: String): String {
        val emailRegex = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
        return if (email.matches(emailRegex.toRegex())) {
            email
        } else {
            throw IllegalArgumentException("Email Inválido")
        }

        }
    companion object{
        fun criarGamer(leitura: Scanner): Gamer {
            println("Bem vindo ao AluGames! Vamos fazer seu cadastro. Digite seu nome: \n")
            val nome = leitura.nextLine()

            println("Digite seu e-mail")
            val email = leitura.nextLine()

            println("Deseja completar seu cadastro com usuario e data de nascimento? (S/N)")
            val opcao = leitura.nextLine()

            if(opcao.equals("s",true)){
                println("Digite sua data de nascimento(DD/MM/AAAA):")
                val nascimento = leitura.nextLine()
                println("Digite seu nome de usuário:")
                val  usuario = leitura.nextLine()

                return Gamer(nome, email, nascimento, usuario)
            }
        return  Gamer(nome, email)

        }
    }

}


