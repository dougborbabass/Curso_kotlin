open class Maquina2(val marca: String){
    fun minhaMarca(){
        println("Minha marca é $marca")
    }
}

class Computador(marca: String, val nucleos: Int) : Maquina2(marca){
    fun ligar(){}
    fun processar(){}
}

fun main(){
    val c = Computador("DELL", 10)
    with(c){
        ligar()
        processar()
        minhaMarca()
    }
}