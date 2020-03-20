interface Funcionario {
    fun calculaBonus()
}

class Gerente : Funcionario {
    override fun calculaBonus() {
        println("Bonus 500")
    }

}

class Tecnico : Funcionario {
    override fun calculaBonus() {
        println("Bonus 200")
    }

}

fun calculo(funcionario: Funcionario) {
    funcionario.calculaBonus()
}

fun main() {
    val f1: Funcionario = Gerente()
    val f2: Funcionario = Tecnico()

    // A função recebe dois tipos diferentes e trata corretamente pelo polimorfismo
    calculo(f1)
    calculo(f2)
}