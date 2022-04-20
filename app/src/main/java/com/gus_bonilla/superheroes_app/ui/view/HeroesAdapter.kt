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
import com.gus_bonilla.superheroes_app.ui.viewmodel.HeroViewModel


class HeroesAdapter(private val heroes: List<HeroModel>, private val context: Context,
                    private val heroViewModel: HeroViewModel): RecyclerView.Adapter<HeroesViewHolder>() {

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
            // Load more data here
            //Log.d("TAG", "There are just 10 heroes ahead in the recyclerView")
            heroViewModel.getMoreHeroes(this.itemCount)
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