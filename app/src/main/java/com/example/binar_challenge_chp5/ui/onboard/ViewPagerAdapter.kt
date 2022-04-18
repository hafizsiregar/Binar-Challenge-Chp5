package com.example.binar_challenge_chp5.ui.onboard

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(private val items: ArrayList<Fragment>, activity: AppCompatActivity) :

    FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = items.size

    override fun createFragment(position: Int): Fragment = items[position]
}
