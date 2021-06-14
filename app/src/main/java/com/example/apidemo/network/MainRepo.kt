package com.example.apidemo.network

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.apidemo.model.PostResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainRepo @Inject constructor(private val api: MyApiServices) {
    fun getPost(): MutableLiveData<PostResponse> {
        var response = MutableLiveData<PostResponse>()

        api.getPosts().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<PostResponse>() {
                override fun onSuccess(t: PostResponse) {
                    response.value = t
                }

                override fun onError(e: Throwable) {
                    //do something
                }
            })

        return response
    }
}