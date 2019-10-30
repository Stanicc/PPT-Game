package stanic.pptgame.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import stanic.pptgame.R
import stanic.pptgame.utils.GameUtils

class ChoiceActivity : AppCompatActivity() {

    private lateinit var player: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice)

        player = if (!GameUtils.game["Game"]!!.duo) "player1"
        else if (GameUtils.game["Game"]!!.choice1 != null) "player2" else "player1"

        findViewById<TextView>(R.id.playerText).text = player

        val animation = AnimationUtils.loadAnimation(this, R.anim.fadein_anim)
        findViewById<TextView>(R.id.playerText).startAnimation(animation)
    }

    fun onClickInChoice(view: View) {
        val intent: Intent =
            if (GameUtils.game["Game"]!!.duo && player != "player2") Intent(this, this::class.java)
            else Intent(this, ResultActivity::class.java)

        when (view.id) {
            R.id.rockButton -> {
                when (player) {
                    "player1" -> {
                        GameUtils.game["Game"]!!.choice1 = 1
                        GameUtils.game["Game"]!!.image1 = R.drawable.rock
                    }
                    "player2" -> {
                        GameUtils.game["Game"]!!.choice2 = 1
                        GameUtils.game["Game"]!!.image2 = R.drawable.rock
                    }
                }
                startActivity(intent)
            }
            R.id.paperButton -> {
                when (player) {
                    "player1" -> {
                        GameUtils.game["Game"]!!.choice1 = 2
                        GameUtils.game["Game"]!!.image1 = R.drawable.paper
                    }
                    "player2" -> {
                        GameUtils.game["Game"]!!.choice2 = 2
                        GameUtils.game["Game"]!!.image2 = R.drawable.paper
                    }
                }
                startActivity(intent)
            }
            R.id.scissorsButton -> {
                when (player) {
                    "player1" -> {
                        GameUtils.game["Game"]!!.choice1 = 3
                        GameUtils.game["Game"]!!.image1 = R.drawable.scissors
                    }
                    "player2" -> {
                        GameUtils.game["Game"]!!.choice2 = 3
                        GameUtils.game["Game"]!!.image2 = R.drawable.scissors
                    }
                }
                startActivity(intent)
            }
        }
    }

}
