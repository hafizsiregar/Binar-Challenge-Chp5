package com.example.binar_challenge_chp5.ui.main

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.binar_challenge_chp5.R
import com.example.binar_challenge_chp5.data.Callback
import com.example.binar_challenge_chp5.data.CallbackDialog
import com.example.binar_challenge_chp5.data.Controller
import com.example.binar_challenge_chp5.databinding.ActivityVersusPemainBinding
import com.example.binar_challenge_chp5.ui.onboard.DialogHasilFragment

@RequiresApi(Build.VERSION_CODES.M)
class VersusPemainActivity : AppCompatActivity(), Callback, CallbackDialog {
    private lateinit var binding: ActivityVersusPemainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVersusPemainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("nama1")
        binding.txtPlayer1.text = name

        val btnPlayer1 = arrayOf(
            binding.imgBatu1,
            binding.imgKertas1,
            binding.imgGunting1,
        )
        val btnPlayer2 = arrayOf(
            binding.imgBatu2,
            binding.imgKertas2,
            binding.imgGunting2,
        )

        var resultPlayer1 = ""
        var resultPlayer2 = ""
        disableClick2(false)
        val controller = Controller(this)
        btnPlayer1.forEachIndexed { index, imageView ->
            imageView.setOnClickListener {
                resultPlayer1 = btnPlayer1[index].contentDescription.toString()
                Log.d(resultPlayer1, "Pemain click")
                Log.d(resultPlayer2, "Pemain 2 Memilih")
                disableClick(false)
                disableClick2(true)

                Toast.makeText(
                    this, resultPlayer1, Toast.LENGTH_SHORT
                ).show()
                btnPlayer1.forEach {
                    it.setBackgroundResource(android.R.color.transparent)
                }
                btnPlayer1[index].setBackgroundResource(R.drawable.shape_rectangle_8_ffc700)
            }
        }

        btnPlayer2.forEachIndexed { index, imageView ->
            imageView.setOnClickListener {
                resultPlayer2 = btnPlayer2[index].contentDescription.toString()
                Log.d(resultPlayer1, "Pemain click")
                Log.d(resultPlayer2, "Pemain 2 Memilih")
                disableClick2(false)
                if (resultPlayer1 != "") {
                    controller.checkResult(
                        resultPlayer1, resultPlayer2, name, "Pemain 2"
                    )
                }
                Toast.makeText(
                    this, resultPlayer2, Toast.LENGTH_SHORT
                ).show()
                btnPlayer2.forEach {
                    it.setBackgroundResource(android.R.color.transparent)
                }
                btnPlayer2[index].setBackgroundResource(R.drawable.shape_rectangle_8_ffc700)
            }
        }

        binding.imgRefresh.setOnClickListener {
            Toast.makeText(this, "Reset", Toast.LENGTH_SHORT).show()
            Log.d("Reset", "Reset click")
            resetGame(android.R.color.transparent, "", "")
        }

        //buat btn close
        val ivClose2 = findViewById<ImageView>(R.id.imgClose)
        ivClose2.setOnClickListener {
            finish()
        }
    }

    private fun disableClick(isEnable: Boolean) {
        binding.imgBatu1.isEnabled = isEnable
        binding.imgKertas1.isEnabled = isEnable
        binding.imgGunting1.isEnabled = isEnable
    }

    private fun disableClick2(isEnable: Boolean) {
        binding.imgBatu2.isEnabled = isEnable
        binding.imgKertas2.isEnabled = isEnable
        binding.imgGunting2.isEnabled = isEnable
    }

    override fun result(result: String) {
        val dialogHasil = DialogHasilFragment()
        val bundle = Bundle()
        bundle.putString("result", result)
        dialogHasil.arguments = bundle
        dialogHasil.show(supportFragmentManager, "DialogResult")
    }

    override fun resetGame(background: Int, resultPlayer1: String, resultPlayer2: String) {
        binding.imgBatu1.setBackgroundResource(background)
        binding.imgKertas1.setBackgroundResource(background)
        binding.imgGunting1.setBackgroundResource(background)
        binding.imgBatu2.setBackgroundResource(background)
        binding.imgKertas2.setBackgroundResource(background)
        binding.imgGunting2.setBackgroundResource(background)
        disableClick(true)
        disableClick2(false)
    }

}