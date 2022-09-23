package com.example.shortsapp.domain

import com.example.shortsapp.data.Meme

interface MemeRepository {
   suspend fun fetchMemes() :ArrayList<Meme>
}