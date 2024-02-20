enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        usuario.formacao = this 
        inscritos.add(usuario)
    }
}

fun main() { val usuario1 = Usuario("Maria") val usuario2 = Usuario("Carmen") val usuario3 = Usuario("Clara")
	val conteudo1 = ConteudoEducacional("Introdução ao HTML", 120)
	val conteudo2 = ConteudoEducacional("Introdução ao CSS", 180)
	val conteudo3 = ConteudoEducacional("Introdução ao JavaScript", 240)

    val formacao1 = Formacao("Densevolvimento Web I", listOf(conteudo1, conteudo2, conteudo3))
    val formacao2 = Formacao("Desenvolvimento Web II", listOf(conteudo3, conteudo1))
    val formacao3 = Formacao("Desenvolvimento Web III", listOf(conteudo2, conteudo3))

    formacao1.matricular(usuario1)
    formacao2.matricular(usuario2)
    formacao3.matricular(usuario3)

    println("${usuario1.nome}, Matriculado em: ${usuario1.formacao?.nome}")
    println("${usuario2.nome}, Matriculado em: ${usuario2.formacao?.nome}")
    println("${usuario3.nome}, Matriculado em: ${usuario3.formacao?.nome}")
    }
