package com.example.apidemo.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apidemo.network.MainRepo
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(val repo: MainRepo) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repo) as T
    }
}