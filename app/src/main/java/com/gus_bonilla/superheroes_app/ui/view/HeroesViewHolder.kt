package com.gus_bonilla.superheroes_app.ui.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gus_bonilla.superheroes_app.R
import de.hdodenhof.circleimageview.CircleImageView

class HeroesViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
    val heroName: TextView = itemView.findViewById(R.id.heroName)
    val heroImage: CircleImageView = itemView.findViewById(R.id.heroImage)
}