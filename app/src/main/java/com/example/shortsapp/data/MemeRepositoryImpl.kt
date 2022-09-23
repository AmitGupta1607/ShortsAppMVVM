package com.example.shortsapp.data

import com.example.shortsapp.domain.MemeRepository
import javax.inject.Inject

class MemeRepositoryImpl @Inject constructor(private val api: MemeFetchApi):MemeRepository {


    override suspend fun fetchMemes(): ArrayList<Meme> {
        val response =  api.fetchMemes()
        return response.data.memes
    }


}