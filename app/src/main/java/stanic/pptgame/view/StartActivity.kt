package stanic.pptgame.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import stanic.pptgame.R
import stanic.pptgame.model.GameModel
import stanic.pptgame.utils.GameUtils

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val animation = AnimationUtils.loadAnimation(this, R.anim.fadein_anim)

        findViewById<Button>(R.id.playSoloButton).startAnimation(animation)
        findViewById<Button>(R.id.playDuoButton).startAnimation(animation)
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.playSoloButton -> {
                val model = GameModel(0, 0, null, null, duo = false)
                GameUtils.game["Game"] = model
            }
            R.id.playDuoButton -> {
                val model = GameModel(0, 0, null, null, duo = true)
                GameUtils.game["Game"] = model
            }
        }
        val intent = Intent(this, ChoiceActivity::class.java)
        startActivity(intent)
    }

}
