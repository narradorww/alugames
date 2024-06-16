package br.com.rodrigoalexandredev.alugames.principal
import br.com.rodrigoalexandredev.alugames.modelo.Gamer
import br.com.rodrigoalexandredev.alugames.modelo.Jogo
import br.com.rodrigoalexandredev.alugames.servicos.ConsumoApi
import java.util.*


fun main() {
    val leitura = Scanner(System.`in`)
    val gamer = Gamer.criarGamer(leitura)

    println("Cadastro concluído com sucesso. Dados do Gamer")
    println(gamer)

    do {
        println("Digite um código de jogo para buscar:")
        val busca = leitura.nextLine()

        val buscaApi = ConsumoApi()
        val informacaoJogo = buscaApi.buscaJogo(busca)

        var meuJogo: Jogo? = null

        val resultado = runCatching {
            meuJogo = Jogo(
                informacaoJogo.info.title,
                informacaoJogo.info.thumb
            )
        }

        resultado.onFailure {
            println("br.com.rodrigoalexandre.dev.alugames. Jogo Inexistente. Tente outro id")
        }

        resultado.onSuccess {
            println("Deseja inserir uma descrição personalizada? S/N")
            val opcao = leitura.nextLine()
            if (opcao.equals("s", ignoreCase = true)) {
                println("Insira a descrição personalizada para o jogo:")
                val descricaoPersonalizada = leitura.nextLine()
                meuJogo?.descricao = descricaoPersonalizada
            } else {
                meuJogo?.descricao = meuJogo?.titulo
            }
            gamer.jogosBuscados.add(meuJogo)
        }

        println("Deseja buscar um novo jogo? S/N")

        val resposta = leitura.nextLine()

    } while (resposta.equals("s", ignoreCase = true))

    println("Jogos Buscados: \n")
    println(gamer.jogosBuscados)

    println("\n Jogos por título:")

    gamer.jogosBuscados.sortBy {
        it?.titulo
    }

    gamer.jogosBuscados.forEach {
        println("Título: " + it?.titulo)
    }

    println("Busca finalizada com sucesso.")
}
