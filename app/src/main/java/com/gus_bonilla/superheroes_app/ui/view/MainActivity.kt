package com.gus_bonilla.superheroes_app.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.gus_bonilla.superheroes_app.databinding.ActivityMainBinding
import com.gus_bonilla.superheroes_app.ui.viewmodel.HeroViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val heroViewModel: HeroViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        heroViewModel.onCreate()

        heroViewModel.heroModel.observe(this, Observer { currentHero ->
            binding.textView.text = currentHero.heroName
        })

        heroViewModel.isLoading.observe(this, Observer {
            binding.progressBar.isVisible = it
        })

        binding.viewContainer.setOnClickListener{heroViewModel.randomHero()}
    }
}
