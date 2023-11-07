package com.example.simpleboilerplate.ui.view.login

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.example.core.BaseActivity
import com.example.core.utils.MessageUtil
import com.example.core.utils.ext.value
import com.example.simpleboilerplate.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    private val viewModel: LoginViewModel by viewModels()

    private val messageUtil: MessageUtil by lazy {
        MessageUtil(this@LoginActivity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.apply {
            isProgressLogin.observe(this@LoginActivity){
                messageUtil.show("Hello World: $it")
            }
        }
    }

    override fun getBindingFactory(): (LayoutInflater) -> ActivityLoginBinding {
        return ActivityLoginBinding::inflate
    }

    override fun ActivityLoginBinding.onViewCreated(savedInstanceState: Bundle?) {
        btnSubmit.setOnClickListener {
            val username = tieUsername.value()
            val password = tiePassword.value()

            viewModel.login(username, password)
        }
    }
}