package com.example.simpleboilerplate.ui.view.login

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.example.core.BaseActivity
import com.example.core.utils.ext.value
import com.example.simpleboilerplate.databinding.ActivityLoginBinding
import com.example.simpleboilerplate.ui.view.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    private val viewModel: LoginViewModel by viewModels()

    override fun onStart() {
        super.onStart()

        // execute check session on user
        viewModel.checkSession()
        viewModel.isSessionExist.observe(this@LoginActivity){ isExist ->
            if(isExist){
                MainActivity.showPage(this@LoginActivity, isClearAllPages = true)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.apply {
            isProgressLogin.observe(this@LoginActivity){
                messageUtil.show("Hello World: $it")
            }

            loginResult.observe(this@LoginActivity){ result ->
                if(result){
                    MainActivity.showPage(this@LoginActivity, isClearAllPages = true)
                }
            }

            message.observe(this@LoginActivity){
                messageUtil.show(it)
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