package com.example.apicomretrofit.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apicomretrofit.data.Character
import com.example.apicomretrofit.databinding.CharacterItemBinding

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {
    private lateinit var binding: CharacterItemBinding
    private lateinit var context: Context
    private var listCharacters: List<Character> = emptyList()


    //binding do viewholder
    inner class ViewHolder(private val bindingHolder: CharacterItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(character: Character){
            bindingHolder.character = character
        }
    }

    fun setUpCharacters(characters: List<Character>) {
        this.listCharacters = characters
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        binding = CharacterItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = listCharacters.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listCharacters[position])
        binding.executePendingBindings()
    }
}

