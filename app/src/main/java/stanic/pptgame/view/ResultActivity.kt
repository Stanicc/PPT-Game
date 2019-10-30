package stanic.pptgame.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import stanic.pptgame.R
import stanic.pptgame.utils.GameUtils

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val resultText = findViewById<TextView>(R.id.resultText)
        val scoreText = findViewById<TextView>(R.id.scoreText)

        val image1 = findViewById<ImageView>(R.id.choice1)
        val image2 = findViewById<ImageView>(R.id.choice2)

        val result: Int

        if (GameUtils.game["Game"]!!.duo) {
            result = GameUtils().verifyMatch(
                GameUtils.game["Game"]!!.choice1!!,
                GameUtils.game["Game"]!!.choice2!!
            )
            image1.setImageResource(GameUtils.game["Game"]!!.image1!!)
            image2.setImageResource(GameUtils.game["Game"]!!.image2!!)
        } else {
            val botChoice = GameUtils().getRandomChoice()

            image1.setImageResource(GameUtils.game["Game"]!!.image1!!)

            when (botChoice + 1) {
                1 -> {
                    image2.setImageResource(R.drawable.rock)
                }
                2 -> {
                    image2.setImageResource(R.drawable.paper)
                }
                3 -> {
                    image2.setImageResource(R.drawable.scissors)
                }
            }

            result = GameUtils().verifyMatch(
                GameUtils.game["Game"]!!.choice1!!,
                botChoice + 1
            )
        }

        when (result) {
            0 -> {
                resultText.text = "Deu empate!"
                scoreText.text =
                    "${GameUtils.game["Game"]!!.player1}     |     ${GameUtils.game["Game"]!!.player2}"
            }
            1 -> {
                resultText.text = "Player1 venceu!"
                GameUtils.game["Game"]!!.player1 += 1
                scoreText.text =
                    "${GameUtils.game["Game"]!!.player1}     |     ${GameUtils.game["Game"]!!.player2}"
            }
            2 -> {
                resultText.text = "Player2 venceu!"
                GameUtils.game["Game"]!!.player2 += 1
                scoreText.text =
                    "${GameUtils.game["Game"]!!.player1}     |     ${GameUtils.game["Game"]!!.player2}"
            }
        }

        val animation = AnimationUtils.loadAnimation(this, R.anim.fadein_anim)
        findViewById<Button>(R.id.retryButton).startAnimation(animation)

    }

    fun onRetryClick(view: View) {
        GameUtils.game["Game"]!!.choice1 = null
        GameUtils.game["Game"]!!.choice2 = null

        val intent = Intent(this, ChoiceActivity::class.java)
        startActivity(intent)
    }

}
