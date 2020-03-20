package collections

data class Food(val name: String, val calories: Double, val ingredients: List<Ingredients> = listOf())

data class Ingredients(val name: String, val quantity: Int)

fun main(args: Array<String>) {

    val data = listOf(
        Food("Lazanha", 1200.0,
            listOf(
                Ingredients("Farinha", 1),
                Ingredients("Presunto", 5),
                Ingredients("Queijo", 10),
                Ingredients("Molho de tomate", 2),
                Ingredients("Manjericão", 3)
            )
        ),
        Food("Panqueca", 500.0),
        Food("Omelete", 200.0),
        Food("Parmegiana", 700.0),
        Food("Sopa de feijão", 300.0),
        Food(
            "Hamburguer", 2000.0,
            listOf(
                Ingredients("Pão", 1),
                Ingredients("Hamburguer", 3),
                Ingredients("Queijo", 1),
                Ingredients("Catupiry", 1),
                Ingredients("Bacon", 3),
                Ingredients("Alface", 1),
                Ingredients("Tomate", 1)
            )
        )
    )

    // Tenho receitas na lista?
    println("Tenho receitas? ${if (data.any()) "Sim" else "Não"}")

    // Quantas receitas tenho na coleção
    println("Tenho ${data.count()} receitas")

    // Qual a primeira e ultima receita?
    println("A primeira receita é: ${data.first().name}")
    println("A ultima receita é: ${data.last().name}")

    // Qual a soma de calorias
    val sumCalories = data.sumByDouble{ it.calories }
    println("A soma de calorias é $sumCalories")

    // Me de as duas primeiras receitas
    val firstTwo = data.take(2)
    for (x in firstTwo.withIndex()){
        println("${x.index+1} - ${x.value.name}")
    }
}