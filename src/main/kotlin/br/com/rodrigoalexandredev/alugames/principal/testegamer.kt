import br.com.rodrigoalexandredev.alugames.modelo.Gamer

fun main(){
    val gamer1= Gamer("rodrigo", "rodrigo@qqcoisa.com")
    println(gamer1)

    val gamer2 = Gamer("Gabi", "gabi@email.com", "10/11/2017", "gabi17" )
    println(gamer2)

    gamer1.let {
        it.dataNascimento = "31/03/1979"
        it.usuario="narradorww"


    }.also{
        println(gamer1.idInterno)
    }

    println(gamer1)
    gamer1.usuario = "Narrador"
    println(gamer1)
}