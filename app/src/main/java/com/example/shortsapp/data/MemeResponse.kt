package com.example.shortsapp.data

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class MemeResponse(@SerializedName("data") val data:Data){

    data class Data(val memes:ArrayList<Meme>)
}