package com.example.booksapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.booksapp.common.viewBinding
import com.example.booksapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityMainBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        MainApplication.provideRetrofit(this)


    }
}
