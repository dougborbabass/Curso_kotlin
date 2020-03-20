fun main() {
    operacao(10, 10, "Somar")
    operacao(10, 10, "Subtrair")
}

fun operacao(a: Int, b: Int, c: String) {
//    return when (c) {
//        "Soma" -> a + b
//        "Subtração" -> a - b
//        else -> 999
//    }

    when {
        a > 0 && b > 0 -> {
            println("valores ok")
        }
    }

    when (a) {
        in 1..99 -> {
            println("Século")
        }
    }
}