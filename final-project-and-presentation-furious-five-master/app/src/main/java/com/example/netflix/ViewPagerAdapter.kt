package com.example.netflix

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.netflix.R

class ViewPagerAdapter(val context: Context) : PagerAdapter(){

    var layoutInflater: LayoutInflater? = null

    // arrays of images , head , description

    val imgArray = arrayOf(
        R.drawable.img_0337 ,
        R.drawable.img_0338 ,
        R.drawable.img_0339,
        R.drawable.img_4
    )

    val headArray = arrayOf(
        "Watch on any device" ,
        "Download and go",
        "No pesky contracts",
        "How do I watch?"
    )

    val arrayDescription = arrayOf(
        "Stream on your phone, tablet , laptop and TV without paying more",
        "Save your data, watch offline on a phone , train , or submarine...",
        "Join today, cancel anytime",
        "Members that subscribe to Netflix can watch here in the app"

    )

    override fun getCount(): Int {
        return headArray.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {

        return view == `object`  as RelativeLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater!!.inflate(R.layout.slider,container,false)

        val img = view.findViewById<ImageView>(R.id.image)
        val text_head = view.findViewById<TextView>(R.id.text_head)
        val txt_description = view.findViewById<TextView>(R.id.txt_description)


        img.setImageResource(imgArray[position])
        text_head.text = headArray[position]
        txt_description.text = arrayDescription[position]

        container.addView(view)
        return view


    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as RelativeLayout)
    }
}