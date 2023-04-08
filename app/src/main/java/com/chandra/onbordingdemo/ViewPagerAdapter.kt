package com.chandra.onbordingdemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter

class ViewPagerAdapter() : RecyclerView.Adapter<ViewPagerAdapter.MyHolder>() {
    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title : TextView = itemView.findViewById(R.id.txt_title)
        val image : ImageView = itemView.findViewById(R.id.img_header)
    }

    val images = arrayOf(
        R.drawable.img1,
        R.drawable.img2,
        R.drawable.img3
    )
    val titles = arrayOf(
        "Don't you always look at your phone you dummy",
        "Spend some time with family",
        "Helps other it helps you to maintain a good health"
    )
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.slide_layout, parent, false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.image.setImageResource(images[position])
        holder.title.text = titles[position]
    }
}