package com.chandra.onbordingdemo

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class OnbordingScreen : AppCompatActivity() {

    private lateinit var adapter: ViewPagerAdapter
    private lateinit var viewPager2: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onbording)
        viewPager2 = findViewById(R.id.viewPager2)
        adapter = ViewPagerAdapter()
        viewPager2.adapter = adapter
        val springDotsIndicator = findViewById<DotsIndicator>(R.id.spring_dots_indicator)
        springDotsIndicator.attachTo(viewPager2)
    }

    override fun onResume() {
        super.onResume()
        findViewById<TextView>(R.id.txt_next).setOnClickListener {
            if (viewPager2.currentItem == viewPager2.adapter?.itemCount?.minus(1)) {
               welcomeScreen()
            }
            viewPager2.setCurrentItem(viewPager2.currentItem + 1, true)
        }
        findViewById<TextView>(R.id.txt_skip).setOnClickListener {
            welcomeScreen()
        }

        adapter.onContinueButtonClicked = {
            welcomeScreen()
            finish()
        }
    }

    private fun welcomeScreen() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}