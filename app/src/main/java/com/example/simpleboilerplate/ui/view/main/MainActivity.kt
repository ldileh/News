package com.example.simpleboilerplate.ui.view.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.viewModels
import com.example.core.BaseActivity
import com.example.core.utils.ext.PermissionResult
import com.example.core.utils.ext.registerPermission
import com.example.core.utils.ext.runPermissionNotification
import com.example.simpleboilerplate.databinding.ActivityMainBinding
import com.example.simpleboilerplate.ui.view.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(), PermissionResult {

    private val viewModel: MainViewModel by viewModels()

    private val requestPermissionNotification: ActivityResultLauncher<String> by lazy {
        registerPermission(this@MainActivity, this@MainActivity)
    }

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
        requestPermissionNotification.runPermissionNotification()

        btnLogout.setOnClickListener {
            viewModel.logout()
        }

        viewModel.getUsers(1)
    }

    override fun getBindingFactory(): (LayoutInflater) -> ActivityMainBinding =
        ActivityMainBinding::inflate

    override fun onFinishRequestPermission(isGranted: Boolean) {
    }

    companion object{

        fun showPage(page: Activity, isClearAllPages: Boolean = false){
            page.startActivity(Intent(page, MainActivity::class.java))
            if(isClearAllPages){
                page.finishAffinity()
            }
        }
    }
}