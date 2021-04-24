package com.example.diceRoller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val rollButton: Button = findViewById(R.id.Roll)
        rollButton.setOnClickListener { rollDice() }

    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {

        // Create new Dice object with 6 sides and roll it
        val myFirstDice = Dice(6)
        val rollFirstDice = myFirstDice.roll()


        // Find the ImageView in the layout
        val firstDice: ImageView = findViewById(R.id.diceImage3)

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (rollFirstDice) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //create a second dice
        val mySecondDice = Dice(6)
        val rollSecondDice = mySecondDice.roll()
        // find the ImageView in the layout
        val secondDice: ImageView = findViewById(R.id.diceImage2)
        val drawableResource1 = when (rollSecondDice) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Update the ImageView with the correct drawable resource ID
        firstDice.setImageResource(drawableResource)
        secondDice.setImageResource(drawableResource1)
        // Update the content description
        firstDice.contentDescription = rollFirstDice.toString()
        secondDice.contentDescription = rollSecondDice.toString()


        //create a lucky number game

        val luckyNumber = true
        val luckyNumber1 = true
        val message: TextView = findViewById(R.id.secondDice)
        val showMessage = when (rollFirstDice==rollSecondDice) {
            luckyNumber==luckyNumber1 -> "You win"
            else -> "sucker"
        }
        message.setText(showMessage)

    }


}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()

    }
}