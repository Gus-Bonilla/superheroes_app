package com.gus_bonilla.superheroes_app.ui.view

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.gus_bonilla.superheroes_app.R
import com.gus_bonilla.superheroes_app.data.model.HeroModel


class HeroesAdapter(val heroes:List<HeroModel>, val context:Context):
    RecyclerView.Adapter<HeroesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_hero_layout,
            parent,
            false)

        return HeroesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HeroesViewHolder, position: Int) {
        val hero = heroes[position]
        var imageUrl = "${hero.heroImage.heroImagePath}/standard_medium.${hero.heroImage.heroImageExt}"

        if (position == this.itemCount - 11) {
            // load more data here.
            Log.d("TAG", "Faltan 10 elementos para llegar a fin")

        }

        imageUrl = "https" + imageUrl.substring(4)
        holder.heroName.text = hero.heroName
        //Log.d("TAG", imageUrl)
        Glide.with(context)
            .load(imageUrl)
            .placeholder(R.drawable.ic_no_image)
            .error(R.mipmap.ic_launcher)
            .into(holder.heroImage);
    }

    override fun getItemCount(): Int {
        return heroes.size
    }

}