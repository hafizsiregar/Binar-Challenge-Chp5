package com.example.binar_challenge_chp5.data

import android.util.Log

class Controller(private val callback: Callback) : Result {

    override fun checkResult(resultPlayer1: String, resultPlayer2: String, player1: String?, com: String) {
        if (resultPlayer1 == resultPlayer2) {
            callback.result("Seri")
            Log.d("Seri", "Click")
        } else if (resultPlayer1 == "Batu" && resultPlayer2 == "Gunting" ||
            resultPlayer1 == "Kertas" && resultPlayer2 == "Batu" ||
            resultPlayer1 == "Gunting" && resultPlayer2 == "Kertas") {
            callback.result("$player1 Menang")
            Log.d("resultPlayer1_menang", "Click")
        } else {
            callback.result("$com Menang")
            Log.d("Result: ", "$resultPlayer1 vs $resultPlayer2")
        }
    }
}