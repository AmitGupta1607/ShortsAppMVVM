package com.example.shortsapp

import android.os.Bundle
import android.view.*
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.shortsapp.common.Resource
import com.example.shortsapp.data.Meme
import com.example.shortsapp.databinding.ActivityMainBinding
import com.example.shortsapp.presentation.MainActivityViewModel
import com.example.shortsapp.presentation.MemesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        viewModel.liveDataMemes.observe(this, {
            when (it) {
                is Resource.Success -> {
                    renderViewPager(it.data)
                }

                is Resource.Error -> {
                    Toast.makeText(this@MainActivity, it.message ?: "", Toast.LENGTH_LONG).show()
                }

                is Resource.Loading -> {
                    if (it.isLoading) {
                        binding.progressBar.visibility = View.VISIBLE
                    } else {
                        binding.progressBar.visibility = View.GONE
                    }
                }
            }
        })

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    private fun renderViewPager(listItems: ArrayList<Meme>?) {
        listItems?.let {
            val adapter = MemesAdapter(it)
            binding.viewPager.adapter = adapter
        }

    }


}