package com.example.binar_challenge_chp5.ui.onboard

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.binar_challenge_chp5.databinding.FragmentOnBoarding3Binding
import com.example.binar_challenge_chp5.ui.main.GameMenuActivity

class OnBoarding3 : Fragment() {

    private lateinit var binding: FragmentOnBoarding3Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoarding3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etNama.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                binding.imgNext?.isVisible = p0.toString().trim().isNotEmpty()
            }
        })
        binding.imgNext?.setOnClickListener {
            if (binding.etNama.text.isNotEmpty()) {
                val name = binding.etNama.text.toString()
                binding.etNama.text.clear()
                val intent = Intent(activity, GameMenuActivity::class.java)
                intent.putExtra("nama1", name)
                startActivity(intent)
            }
        }
    }
}