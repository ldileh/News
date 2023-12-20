package com.project.core.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.project.core.utils.MessageUtil
import com.skydoves.whatif.whatIfNotNull

abstract class BaseActivity<T: ViewBinding>(): AppCompatActivity() {

    private lateinit var _binding: T

    val messageUtil: MessageUtil by lazy {
        MessageUtil(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = getBindingFactory()(layoutInflater)
        setContentView(_binding.root)

        toolbarId().whatIfNotNull {
            setSupportActionBar(findViewById(it))
            supportActionBar?.setDisplayHomeAsUpEnabled(isShowDisplayHome())
        }


        _binding.onViewCreated(savedInstanceState)
    }

    abstract fun T.onViewCreated(savedInstanceState: Bundle?)

    abstract fun getBindingFactory(): (LayoutInflater) -> T

    abstract fun toolbarId(): Int?

    abstract fun isShowDisplayHome(): Boolean

    fun getBinding(): T = _binding
}