fun main(){

    val a = 10
    val b = 20
    val c = 30

    /****Operador Elvis****/
    //Para dizer pro kotlin que a variável pode ser nula, usar o "?"
    val test: Int? = null

    //Se a variável for nula, atribua o valor 100
    val op = test ?: 100

    println(op)

    calculaBonus(a,b,c)
    println(hello("Douglas"))
    println(hello2("Douglas 2"))
}

fun calculaBonus(a: Int, b: Int, c: Int) {
    println("O bonus é: ${a + b * c}")
}

fun hello(nome: String) : String {
    return "olá $nome"
}

fun hello2(nome: String) = "olá $nome"