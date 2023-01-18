package com.example.netflix

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_gesture.*
import kotlin.math.abs

class GestureActivity : AppCompatActivity() , GestureDetector.OnGestureListener{

    lateinit var gestureDetector : GestureDetector
    var x2:Float = 0.0f
    var x1:Float = 0.0f
    var y2:Float = 0.0f
    var y1:Float = 0.0f

    companion object{
        const val MIN_DISTANCE = 150
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gesture)

        gestureDetector= GestureDetector(this ,  this)
    }

    @SuppressLint("ResourceAsColor")
    override fun onTouchEvent(event: MotionEvent?): Boolean {


        gestureDetector.onTouchEvent(event)

        when (event?.action){

            0->
            {
                x1 = event.x
                y1 = event.y
            }

            1 ->
            {
                x2 = event.x
                y2 = event.y

                val valueX : Float = x2-x1
                val valueY : Float = y2-y1

                if (abs(valueX) > MIN_DISTANCE)
                {
                    if (x2 > x1)
                    {

                        rl1.setBackgroundColor(R.color.Aqua)
                        Toast.makeText(this , "Right Swipe" , Toast.LENGTH_SHORT).show()
                    }

                    else
                    {
                        rl1.setBackgroundColor(R.color.Green)
                        Toast.makeText(this , "Left Swipe" , Toast.LENGTH_SHORT).show()
                    }
                }
                else if (abs(valueY) > MIN_DISTANCE)
                {
                    if (y2 > y1)
                    {
                        rl1.setBackgroundColor(R.color.Red)
                        Toast.makeText(this , "Bottom Swipe" , Toast.LENGTH_SHORT).show()
                    }

                    else
                    {
                        rl1.setBackgroundColor(R.color.Brown)
                        Toast.makeText(this , "Top Swipe" , Toast.LENGTH_SHORT).show()
                    }
                }

            }

        }
        return super.onTouchEvent(event)
    }

    override fun onDown(p0: MotionEvent?): Boolean {
        //TODO("Not yet implemented")
        return false
    }

    override fun onShowPress(p0: MotionEvent?) {
        //TODO("Not yet implemented")
    }

    override fun onSingleTapUp(p0: MotionEvent?): Boolean {
        //TODO("Not yet implemented")
        return false
    }

    override fun onScroll(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {
        //TODO("Not yet implemented")
        return false
    }

    override fun onLongPress(p0: MotionEvent?) {
        //TODO("Not yet implemented")
    }

    override fun onFling(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {
        //TODO("Not yet implemented")
        return false
    }
}