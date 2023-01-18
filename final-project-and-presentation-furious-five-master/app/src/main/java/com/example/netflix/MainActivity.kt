package com.example.netflix

import android.content.Intent



import android.widget.Button
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView

import android.widget.RelativeLayout
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.example.netflix.R
import com.example.netflix.ViewPagerAdapter
import com.example.netflix.LoginActivity
import kotlinx.android.synthetic.main.activity_home_page.*


class MainActivity : AppCompatActivity() {

    private lateinit var sign_in_button : Button

    private lateinit var netflix : ImageView
    private lateinit var viewPager : ViewPager
    private lateinit var viewPagerAdapter: ViewPagerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sign_in_button = findViewById(R.id.sign_in_button)

        sign_in_button.setOnClickListener{
            intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
        }



        netflix = findViewById(R.id.netflix)


        netflix.setOnClickListener{
            intent = Intent(this@MainActivity, VideoActivity::class.java)
            startActivity(intent)
        }




        viewPager = findViewById(R.id.viewpager)
        viewPagerAdapter = ViewPagerAdapter(this)
        viewPager.adapter = viewPagerAdapter

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                Log.i("TAG" , position.toString())

            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })

    }
}