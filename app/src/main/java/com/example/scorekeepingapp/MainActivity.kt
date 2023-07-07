// We took cricket as the game for score keeping.
// In this project we worked in group with Rohan Yesudasan (A00278674) Kamaljit Kaur (A00278618) and myself Gokul Saji Kumar(A00273682)
// We did brainstorming together to develop layouts and logic Gokul Saji Kumar worked on text views along with the spinner on activity_main.xml
// Rohan Yesudasan worked on buttons in mainActivity.kt
// Kamaljit Kaur worked on the OnClickListeners
package com.example.scorekeepingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.Switch
import android.widget.TextView
import android.widget.ToggleButton
import com.example.scorekeepingapp.R.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        //Here we are intializing text views elements of both team
        val team1Score = findViewById<TextView>(id.team1_score)
        val team2Score = findViewById<TextView>(id.team2_score)
        val increment1 = findViewById<Spinner>(id.score1_increment)
        val increment2 = findViewById<Spinner>(id.score2_increment)
        val teamIncrease = findViewById<Button>(id.team_increase)
        val teamDecrease = findViewById<Button>(id.team_decrease)
        val teamToggleButton = findViewById<Switch>(id.team_toggle_button)

        //Initially the scores of each time is set to 0 before the game starts
        team1Score.text = "0"
        team2Score.text = "0"
        var currentTeam = 1


        // This variable is used to keep track of currently selected team initially we are selecting the first team.
        // Added code for toggle listener
        val onCheckedChangeListener = teamToggleButton.setOnCheckedChangeListener { _, isChecked ->
            // Update the value of currentTeam based on the state of the toggle button
            currentTeam = if (isChecked) 2 else 1
        }
        // OnclickListeners is used to increase the values
        teamIncrease.setOnClickListener {
            // Get the score increment value selected from the spinner
            val scoreIncrement = increment1.selectedItem.toString().toInt()
            if (currentTeam == 1) {
                val currentScore = team1Score.text.toString().toInt()
                val newScore = currentScore + scoreIncrement
                team1Score.text = newScore.toString()
            } else {
                val scoreIncrement = increment2.selectedItem.toString().toInt()
                val currentScore = team2Score.text.toString().toInt()
                val newScore = currentScore + scoreIncrement
                team2Score.text = newScore.toString()
            }
        }
        // OnclickListeners inorder to decrease the values
        teamDecrease.setOnClickListener {
            // Get the score decrement value selected from the spinner
            val scoreIncrement = increment1.selectedItem.toString().toInt()
            if (currentTeam == 1) {
                val scoreIncrement = increment1.selectedItem.toString().toInt()
                val currentScore = team1Score.text.toString().toInt()
                val newScore = currentScore - scoreIncrement
                if (newScore >= 0) {
                    team1Score.text = newScore.toString()
                }
            } else {
                val scoreIncrement = increment2.selectedItem.toString().toInt()
                val currentScore = team2Score.text.toString().toInt()
                val newScore = currentScore - scoreIncrement
                if (newScore >= 0) {
                    team2Score.text = newScore.toString()
                }
            }
        }
    }
}