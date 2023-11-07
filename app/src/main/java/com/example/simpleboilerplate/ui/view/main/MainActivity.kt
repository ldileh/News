package com.example.simpleboilerplate.ui.view.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.example.core.BaseActivity
import com.example.simpleboilerplate.databinding.ActivityMainBinding
import com.example.simpleboilerplate.ui.view.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.apply {
            resultLogout.observe(this@MainActivity){ result ->
                if(result){
                    startActivity(Intent(this@MainActivity, LoginActivity::class.java))
                    finishAffinity()
                }
            }
        }
    }

    override fun ActivityMainBinding.onViewCreated(savedInstanceState: Bundle?) {
        btnLogout.setOnClickListener {
            viewModel.logout()
        }
    }

    override fun getBindingFactory(): (LayoutInflater) -> ActivityMainBinding =
        ActivityMainBinding::inflate

    companion object{

        fun showPage(page: Activity, isClearAllPages: Boolean = false){
            page.startActivity(Intent(page, MainActivity::class.java))
            if(isClearAllPages){
                page.finishAffinity()
            }
        }
    }
}