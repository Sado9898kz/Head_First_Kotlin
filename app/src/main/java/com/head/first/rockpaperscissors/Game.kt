package com.head.first.rockpaperscissors

fun main() {
    val options = arrayOf("Камень", "Бумага", "Ножницы")
    val gameChoice = getGameChoice(options)
    val userChoice = getUserChoice(options)
    printResult(userChoice, gameChoice)
}

fun getGameChoice(optionsParam: Array<String>) =
    optionsParam[(Math.random() * optionsParam.size).toInt()]

fun getUserChoice(optionsParam: Array<String>): String {
    var isValidChoice = false
    var userChoice = ""
    //Выполнять цикл, пока пользователь не введет допустимый вариант
    while (!isValidChoice) {
        //Запросить у пользователя его выбор
        print("Пожалуйста, введите один из следующих:")
        for (item in optionsParam) print(" $item")
        println(".")
        //Прочитать пользовательский ввод
        val userInput = readLine()
        //Проверить пользовательский ввод
        if (userInput != null && userInput in optionsParam) {
            isValidChoice = true
            userChoice = userInput
        }
        //Если выбран недопустимый вариант, сообщить пользователю
        if (!isValidChoice) println("Вы должны ввести правильный выбор.")
    }
    return userChoice
}

fun printResult(userChoice: String, gameChoice: String) {
    val result: String
    //Опредилть результат
    if (userChoice == gameChoice) result = "Ничья!"
    else if ((userChoice == "Rock") && (gameChoice == "Scissors") ||
        (userChoice == "Paper") && (gameChoice == "Rock") ||
        (userChoice == "Scissors") && (gameChoice == "Paper")
    ) result = "Ты победил!"
    else result = "Ты проиграл!"
    //Вывести результат
    println("Твой выбар $userChoice. Я выбрал $gameChoice. $result")
}