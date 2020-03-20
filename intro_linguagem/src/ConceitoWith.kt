class Maquina(var marca: String){

    fun ligar (){
    }

    fun desligar() {
    }
}

fun main(){
    var maquina = Maquina("Sthill")

    with(maquina){
        ligar()
        desligar()
    }
}