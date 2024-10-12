import kotlin.random.Random

fun main() {
    println("Добро пожаловать в игру 'Камень-Ножницы-Бумага'!")
    println("1 - Камень, 2 - Ножницы, 3 - Бумага")

    while (true) {
        val playerChoice = getPlayerChoice()
        val computerChoice = getComputerChoice()

        println("Вы выбрали: ${getChoiceName(playerChoice)}")
        println("Компьютер выбрал: ${getChoiceName(computerChoice)}")

        val result = getResult(playerChoice, computerChoice)

        when (result) {
            "win" -> {
                println("Вы выиграли!")
                break
            }
            "lose" -> {
                println("Вы проиграли!")
                break
            }
            "draw" -> {
                println("Ничья! Попробуйте снова.")
            }
        }
    }
}

fun getPlayerChoice(): Int {
    while (true) {
        print("Введите ваш выбор (1 - Камень, 2 - Ножницы, 3 - Бумага): ")
        val input = readLine()?.toIntOrNull()

        if (input != null && input in 1..3) {
            return input
        } else {
            println("Неверный ввод. Попробуйте снова.")
        }
    }
}

fun getComputerChoice(): Int {
    return Random.nextInt(1, 4)
}

fun getChoiceName(choice: Int): String {
    return when (choice) {
        1 -> "Камень"
        2 -> "Ножницы"
        3 -> "Бумага"
        else -> "Неизвестно"
    }
}

fun getResult(playerChoice: Int, computerChoice: Int): String {
    return if (playerChoice == computerChoice) {
        "draw"
    } else if ((playerChoice == 1 && computerChoice == 2) ||
        (playerChoice == 2 && computerChoice == 3) ||
        (playerChoice == 3 && computerChoice == 1)) {
        "win"
    } else {
        "lose"
    }
}
