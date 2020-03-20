package basics

fun main(){
    val q1 = Quadrado(10f)
    val q2 = Quadrado(10f)
    val t1 = Triangulo(10f)
    val t2 = Triangulo(10f)

    //aqui teriamos que sobrescrever o toString para termos o valor
    println(q1)
    //o data class já imprime o valor do atributo
    println(t1)

    //aqui estaria comparando as posições de uma memória
    println(q1 == q2)
    //aqui já compara os valores dos atribuitos pois é uma data class
    println(t1 == t2)

}

class Quadrado(val area: Float)

data class Triangulo(val area: Float)

// a data class serve para transitar dados como parametros
data class Param(var b: Boolean, var s: String, var i: Int)
fun teste(p: Param){

}

//fun basics.teste(b: Boolean, s: String, i: Int){
//
//}