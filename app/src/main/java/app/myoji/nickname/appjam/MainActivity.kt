package app.myoji.nickname.appjam

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    var secondText: TextView = findViewById(R.id.secondText)
    val startButton: Button = findViewById(R.id.startButton)
    var second =60

    val timer : CountDownTimer = object : CountDownTimer(60000,1000){

        override fun onFinish() {
            secondText.isVisible = true
            second=60
            secondText.text= second.toString()
            TODO("Not yet implemented")


        }

        override fun onTick(millisUntilFinished: Long) {
            second = second -1
            secondText.text = second.toString()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        secondText.text =second.toString()

        startButton.setOnClickListener {
            secondText.isVisible=false

            timer.start()
        }
    }

}
