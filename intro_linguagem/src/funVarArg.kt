fun main(){
    media(10f, 8f)

    qualquerTipo(1,false,"doi", 2f)
}

fun media(vararg notas: Float){
    if(notas.isNotEmpty()){
        var soma = 0f
        for (nota in notas){
            soma += nota
        }
        println("A média é: ${soma/notas.size}")
    }
}

fun <T> qualquerTipo(vararg valores: T){
    for(valor in valores){
        println(valor)
    }
}