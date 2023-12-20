package com.project.core.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.project.core.utils.MessageUtil

abstract class BaseActivity<T: ViewBinding>(): AppCompatActivity() {

    private lateinit var _binding: T

    val messageUtil: MessageUtil by lazy {
        MessageUtil(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = getBindingFactory()(layoutInflater)
        setContentView(_binding.root)

        _binding.onViewCreated(savedInstanceState)
    }

    abstract fun T.onViewCreated(savedInstanceState: Bundle?)

    abstract fun getBindingFactory(): (LayoutInflater) -> T

    fun getBinding(): T = _binding
}