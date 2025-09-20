fun main(args: Array<String>) {
    val options = arrayOf("Rock","Paper","Scissors")
    var userScore = 0
    var gameScore = 0

   //Game loop - continues untill the user chooses to exit
    while (true){
    val gameChoice = getGameChoice(options)
    val userChoice = getUserChoice(options)
    val res = printResult(gameChoice,userChoice)
    val(newUserScore, newGameScore) = updateScore(res, userScore, gameScore)

        userScore = newUserScore
        gameScore = newGameScore

        //Ask the user whether to continue or exit
        var cont: Int? = null
        var isValidChoice = false

        while (!isValidChoice){

            println("Do you want to continue or exit this round?" +
                    " [0 for exit,1 for continue]")
            val userInput = readLine()

            if(userInput!=null && (userInput=="0" || userInput=="1")){
                cont = userInput.toInt()
                isValidChoice = true
            }

            if(!isValidChoice) println("You must enter a valid choice!.")
    }
        if(cont==0)break
}
    println("Final score -> Your score: $userScore, Game score: $gameScore")
}

/**
 * Updates the scores based on the round result.
 * @param s The result string (You win! / You lose! / Tie!)
 * @param userScore Current user score
 * @param gameScore Current computer score
 * @return A Pair of updated scores (user, game)
 */
fun updateScore(s:String,userScore:Int,gameScore:Int): Pair<Int,Int>{
 var user = userScore
 var game = gameScore
    when(s){
        "You win!" -> user++
        "You lose!" -> game++
    }
    return Pair(user,game)
}

/**
 * Prints the round result and returns it.
 * @param gameChoice Computer's choice
 * @param userChoice User's choice
 * @return The result as a String (Tie!, You win!, or You lose!)
 */
fun printResult(gameChoice : String,userChoice:String):String {
    var result = ""
    when{
        userChoice == gameChoice-> result = "Tie!"
        (gameChoice == "Rock" && userChoice == "Paper") ||
        (gameChoice == "Paper" && userChoice == "Scissors") ||
        (gameChoice == "Scissors" && userChoice == "Rock") -> result= "You win!"
        else -> result = "You lose!"
    }
    println("You chose $userChoice. I chose $gameChoice. $result")
    return result
}

/**
 * Returns a random choice for the computer.
 * @param optionsParam Array of possible options
 * @return The computer's choice
 */
fun getGameChoice(optionsParam:Array<String>) = optionsParam[(Math.random()*optionsParam.size).toInt()]

/**
 * Gets a valid choice from the user.
 * Keeps asking until the input is valid.
 * @param optionsParam Array of possible options
 * @return The user's choice
 */
fun getUserChoice(optionsParam: Array<String>):String{
    var isValidChoice = false
    var userChoice=""

    while (!isValidChoice){

        print("Please enter one of the following: ")
        for(item in optionsParam) print(" $item")
        println(".")

        val userInput = readLine()
        if(userInput!=null && userInput in optionsParam){
            isValidChoice = true
            userChoice = userInput
        }
        if(!isValidChoice) println("You must enter a valid choice!.")
    }
    return userChoice;
}