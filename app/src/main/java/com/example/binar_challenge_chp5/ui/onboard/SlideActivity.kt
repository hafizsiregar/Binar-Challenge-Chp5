package com.example.binar_challenge_chp5.ui.onboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.binar_challenge_chp5.R
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class SlideActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slide)

        val dotIndicator = findViewById<DotsIndicator>(R.id.dots_indicator)
        val viewPager2 = findViewById<ViewPager2>(R.id.viewPager)
        val fragment: ArrayList<Fragment> = arrayListOf(
            OnBoarding1(),
            OnBoarding2(),
            OnBoarding3(),
        )

        val adapter = ViewPagerAdapter(fragment, this)
        viewPager2.adapter = adapter
        dotIndicator.setViewPager2(viewPager2)
    }
}