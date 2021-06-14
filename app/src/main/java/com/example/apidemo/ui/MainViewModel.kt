package com.example.apidemo.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apidemo.network.MainRepo
import com.example.apidemo.model.PostResponse

class MainViewModel(val repo: MainRepo) : ViewModel() {

    var data = MutableLiveData<PostResponse>()

    fun getData()  {
        data = repo.getPost()
    }

}