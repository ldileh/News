package com.example.core

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<T: ViewBinding>(): AppCompatActivity() {

    private lateinit var _binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = getBindingFactory()(layoutInflater)
        setContentView(_binding.root)

        _binding.onViewCreated(savedInstanceState)
    }

    abstract fun T.onViewCreated(savedInstanceState: Bundle?)

    abstract fun getBindingFactory(): (LayoutInflater) -> T
}