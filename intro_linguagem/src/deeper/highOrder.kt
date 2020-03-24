package deeper

fun main(){
    operator(1,2, :: mult)
    operator(1,2, :: sum)

    // Lambda
    operator(10, 20) { x, y -> x + y}

    // Fun anonima
    operator(10, 20, fun(n1: Int, n2: Int): Int {
        return n1 + n2
    })

    val list = listOf(1,2,3)
    list.paraCada { println(it) }

    val str = listOf("oi","oi2", "oi3", "oi4")
    str.paraCada { println(it) }
}

fun operator(x: Int, y: Int, op: (Int, Int) -> Int) : Int {
    return op(x, y)
}

fun <T> Iterable<T>.paraCada(op: (T) -> Unit){
    for (i in this) op(i)
}

fun sum(x: Int, y: Int) = x + y
fun mult(x: Int, y: Int) = x * y
