package com.chandra.onbordingdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView

class ViewPagerAdapter() : RecyclerView.Adapter<ViewPagerAdapter.MyHolder>() {

    var onContinueButtonClicked: (() -> Unit?)? = null

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val heading: TextView = itemView.findViewById(R.id.heading)
        val descriptions: TextView = itemView.findViewById(R.id.descriptions)
        val animationView: LottieAnimationView = itemView.findViewById(R.id.animationView)
        val continue_btn: Button = itemView.findViewById(R.id.btn_continue)
    }

    val animations = arrayOf(
        R.raw.looking_at_phone,
        R.raw.help_others,
        R.raw.family_time,
    )
    val titles = arrayOf(
        "You're missing out",
        "Help to be Helped",
        "Family Priority++"
    )
    val desc = arrayOf(
        "Don't you always look at your digital device you dummy",
        "Helps other it helps you to maintain a peace of ming and a better person",
        "Spend some time with family, this will cure all of problems"
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.slide_layout, parent, false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.animationView.setAnimation(animations[position])
        holder.heading.text = titles[position]
        holder.descriptions.text = desc[position]

        if (position == titles.size-1) {
            holder.continue_btn.visibility = View.VISIBLE
        }

        holder.continue_btn.setOnClickListener{
            onContinueButtonClicked?.invoke()
        }
    }
}