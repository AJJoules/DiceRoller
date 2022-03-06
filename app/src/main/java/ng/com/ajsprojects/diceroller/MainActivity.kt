package ng.com.ajsprojects.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


/*
* This activity allows the user to roll a dice and view the result
* on the screen.
* */

class MainActivity : AppCompatActivity() {
    lateinit var diceImage: ImageView
    lateinit var diceImage2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
        rollDice()
        // Update the screen with th dice roll
        diceImage = findViewById(R.id.imageView)
        diceImage2 = findViewById(R.id.imageView2)

        /*val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show()
            val resultTextView: TextView = findViewById(R.id.textView)
            resultTextView.text = "6"*/
    }

    /*
    * Roll the dice and update the screen with the result
    * */

    private fun rollDice() {
        //Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Determine which resource ID to use based on the dice roll
        val drawableResource = when(diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

//        This updates the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)
        diceImage2.setImageResource(drawableResource)

//        Updates the content description
        diceImage.contentDescription = diceRoll.toString()
        diceImage2.contentDescription = diceRoll.toString()
    }
}


class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}