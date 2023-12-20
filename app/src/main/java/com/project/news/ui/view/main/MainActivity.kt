package com.project.news.ui.view.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.viewModels
import com.project.core.base.BaseActivity
import com.project.core.utils.ext.PermissionResult
import com.project.core.utils.ext.registerPermission
import com.project.core.utils.ext.runPermissionNotification
import com.project.news.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(), PermissionResult {

    private val viewModel: MainViewModel by viewModels()

    private val requestPermissionNotification: ActivityResultLauncher<String> by lazy {
        registerPermission(this@MainActivity, this@MainActivity)
    }
    override fun ActivityMainBinding.onViewCreated(savedInstanceState: Bundle?) {
        requestPermissionNotification.runPermissionNotification()

        btnLogout.setOnClickListener {
        }
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