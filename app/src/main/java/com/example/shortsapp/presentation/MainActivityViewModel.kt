package com.example.shortsapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shortsapp.common.Resource
import com.example.shortsapp.data.Meme
import com.example.shortsapp.domain.MemeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private  val repository: MemeRepository) :ViewModel(){

    private val _mutableLiveDataMemes:MutableLiveData<Resource<ArrayList<Meme>>>  = MutableLiveData()
    val liveDataMemes:LiveData<Resource<ArrayList<Meme>>> =_mutableLiveDataMemes

    init {
        fetchMemes()
    }

    private fun fetchMemes(){
        _mutableLiveDataMemes.value = Resource.Loading(true)
        viewModelScope.launch {
            try {
                val result = repository.fetchMemes()
                _mutableLiveDataMemes.value = Resource.Success(result)
                _mutableLiveDataMemes.value = Resource.Loading(false)
            }catch (e:Exception){
                e.printStackTrace()
                _mutableLiveDataMemes.value = Resource.Error(e.message)
                _mutableLiveDataMemes.value = Resource.Loading(false)
            }
        }
    }
}