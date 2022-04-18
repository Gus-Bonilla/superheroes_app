package com.gus_bonilla.superheroes_app.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gus_bonilla.superheroes_app.R
import com.gus_bonilla.superheroes_app.data.model.HeroModel
import com.gus_bonilla.superheroes_app.data.model.HeroProvider
import com.gus_bonilla.superheroes_app.databinding.ActivityMainBinding
import com.gus_bonilla.superheroes_app.ui.viewmodel.HeroViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val heroViewModel: HeroViewModel by viewModels()
    private lateinit var recyclerView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        heroViewModel.onCreate()

        heroViewModel.heroModel.observe(this, Observer { currentHero ->
            binding.textView.text = currentHero.heroName
        })

        heroViewModel.heroesList.observe(this, Observer {
            binding.recyclerView.layoutManager = LinearLayoutManager(this)
            binding.recyclerView.adapter = HeroesAdapter(it, this@MainActivity)
        })

        heroViewModel.isLoading.observe(this, Observer {
            binding.progressBar.isVisible = it
        })

        binding.viewContainer.setOnClickListener{heroViewModel.randomHero()}
    }
}
