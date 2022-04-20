package com.gus_bonilla.superheroes_app.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.gus_bonilla.superheroes_app.data.model.HeroProvider
//import androidx.recyclerview.widget.RecyclerView
import com.gus_bonilla.superheroes_app.databinding.ActivityMainBinding
import com.gus_bonilla.superheroes_app.ui.viewmodel.HeroViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val heroViewModel: HeroViewModel by viewModels()
    //private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        heroViewModel.onCreate()

        heroViewModel.heroModel.observe(this, Observer { currentHero ->
            //binding.textView.text = currentHero.heroName
        })

        heroViewModel.heroesList.observe(this, Observer {
            binding.recyclerView.layoutManager = LinearLayoutManager(this)
            binding.recyclerView.adapter = HeroesAdapter(it, this@MainActivity, heroViewModel)
            (binding.recyclerView.layoutManager as LinearLayoutManager).scrollToPosition(it.size-56)
        })

        heroViewModel.isLoading.observe(this, Observer {
            binding.progressBar.isVisible = it
        })

        //binding.viewContainer.setOnClickListener{heroViewModel.randomHero()}
    }
}
