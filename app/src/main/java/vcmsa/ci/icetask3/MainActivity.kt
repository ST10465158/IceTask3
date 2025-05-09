package vcmsa.ci.icetask3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    val numberToGuess = Random.nextInt(1, 101)
    var attempts = 0

    println("Welcome to the Number Guessing Game!")
    println("I'm thinking of a number between 1 and 100. Can you guess it?")

    while (true) {
        print("Enter your guess: ")
        val input = readLine()

        val guess = input?.toIntOrNull()
        if (guess == null) {
            println("That's not a valid number. Try again.")
            continue
        }

        attempts++

        when {
            guess < numberToGuess -> println("Too low!")
            guess > numberToGuess -> println("Too high!")
            else -> {
                println("Congratulations! You guessed the number in $attempts attempts.")
                exitProcess(0)
            }
        }
}