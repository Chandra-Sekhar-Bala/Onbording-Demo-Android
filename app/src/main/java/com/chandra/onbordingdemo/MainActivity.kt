package com.chandra.onbordingdemo

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator

class MainActivity : AppCompatActivity() {

    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var viewPager2: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        viewPager2 = findViewById(R.id.viewPager2)
        viewPagerAdapter = ViewPagerAdapter()
        viewPager2.adapter = viewPagerAdapter
        val springDotsIndicator = findViewById<DotsIndicator>(R.id.spring_dots_indicator)
        springDotsIndicator.attachTo(viewPager2)

    }
}