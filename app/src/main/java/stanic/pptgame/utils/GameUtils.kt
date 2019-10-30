package stanic.pptgame.utils

import stanic.pptgame.model.GameModel
import kotlin.random.Random

class GameUtils {

    companion object {
        val game = HashMap<String, GameModel>()
    }

    fun getRandomChoice(): Int {
        return Random.nextInt(3)
    }

    fun verifyMatch(choiceOne: Int, choiceTwo: Int): Int {
        return when (choiceOne) {
            choiceTwo -> 0
            else -> if (choiceOne == 2 && choiceTwo == 1 || choiceOne == 3 && choiceTwo == 2 || choiceOne == 1 && choiceTwo == 3) 1
            else 2
        }
    }

}