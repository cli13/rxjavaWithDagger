package com.example.apidemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.apidemo.DI.ApiComponent
import com.example.apidemo.DI.DaggerApiComponent
import com.example.apidemo.databinding.ActivityMainBinding
import com.example.apidemo.network.MainRepo
import com.example.apidemo.DI.MyApiClient
import com.example.apidemo.MyApp
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        (application as MyApp).appComponent.injectMainFactory(this)
        var vm = ViewModelProvider(this, factory).get(MainViewModel::class.java)
        vm.getData()
        vm.data.observe(this) { postResponse ->
            var str = ""
            Log.d("Debugg", "onCreate: $postResponse")
            postResponse?.forEach { item ->
                str += "${item.id}: ${item.title}\n"
            }
            binding.tvData.text = str
        }
    }
}