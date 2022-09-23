package com.example.shortsapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.shortsapp.data.Meme
import com.example.shortsapp.databinding.ActivityMainBinding
import com.example.shortsapp.databinding.FragmentSecondBinding
import com.example.shortsapp.databinding.ItemMemeBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


class FragmentShorts : Fragment() {

    @Inject
    lateinit var requestManager: RequestManager

    companion object {
        const val MEME = "meme"
        const val MEME_NAME = "meme_name"
        const val MEME_URL = "meme_url"
        fun getInstance(memeItem: Meme): Fragment {
            val fragment = Fragment()
            val bundle = Bundle()
            bundle.putString(MEME_URL, memeItem.name)
            bundle.putString(MEME_NAME, memeItem.url)
            fragment.arguments = bundle
            return fragment
        }
    }

    val name: String? by lazy {
        arguments?.getString(MEME_NAME)
    }

    val url :String? by lazy{
        arguments?.getString(MEME_URL)
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.v("AAA","OnCreate called")
        Toast.makeText(requireActivity(),"showwww",Toast.LENGTH_LONG).show()
        return inflater.inflate(R.layout.fragment_second,container,false)

    }

}