package app.myoji.nickname.appjam


import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

//最初の秒数の数字を０に表示
//ランダムにお題の数字を取得する
    var figure: TextView = findViewById(R.id.figure)

    fun main(args: Array<String>){
        val randomInt = Random.nextInt(60)
        figure.text = randomInt.toString()


    }
    val handler = Handler()
    var timer = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var figure: TextView = findViewById(R.id.figure)
        var timer: TextView = findViewById(R.id.timer)
        val startButton: Button = findViewById(R.id.startButton)
        val stopButton: Button = findViewById(R.id.stopButton)
        val resetButton: Button = findViewById(R.id.resetButton)

        val nunnable = object : Runnable{
            override fun run(){
                timer++
                timeToText(timer)?.let{

                    timer.text = it
                }
                handler.postDelayed(this,1000)


            }

        }







        startButton.setOnClickListener{

          timer.isVisible= false
          handler.post(runnable)


        }
        stopButton.setOnClickListener {

            timer.isVisible= true
            handler.removeCallbacks(runnable)


        }
        resetButton.setOnClickListener {
            timer.isVisible =true
            handler.removeCallbacks(runnable)

            timer = 0

            timeToText()?.let{

                timer.text = it
            }

        }


    }

    private fun timeToText(time: Int =0): String
    return if(time <0)
    {
        null
    }else if (time == 0)
        "00:00:00"
    }else
        val h = time /3600
        val m = time % 3600 /60
        val s = time % 60
        "%1$02d:%2$02d:%3$02d".format(h,m,s)


    }
}
