package stanic.pptgame.model

class GameModel(
    var player1: Int,
    var player2: Int,
    var choice1: Int?,
    var choice2: Int?,
    var image1: Int? = null,
    var image2: Int?= null,
    var duo: Boolean
)