package com.example.apicomretrofit

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.apicomretrofit.commons.Resultado
import com.example.apicomretrofit.databinding.ActivityMainBinding
import com.example.apicomretrofit.ui.CharactersViewModel
import com.example.apicomretrofit.ui.adapters.CharacterAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CharacterAdapter
    private val charactersViewModel: CharactersViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configureRecycler()
        observer()
    }

    private fun configureRecycler(){
        adapter = CharacterAdapter()
        binding.rcCharacters.adapter = adapter
    }
    private fun observer(){
        charactersViewModel.fetchCharacters().observe(this){result ->
            when(result) {
                is Resultado.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }

                is Resultado.Success -> {
                    binding.progressBar.visibility = View.GONE
                    adapter.setUpCharacters(result.data)
                }

                is Resultado.Error -> {
                    binding.progressBar.visibility = View.GONE
                }
            }
        }
    }
}
