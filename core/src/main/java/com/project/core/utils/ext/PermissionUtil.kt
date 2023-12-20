package com.project.core.utils.ext

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity


fun registerRequestResult(
    page: AppCompatActivity,
    listener: RequestResult
): ActivityResultLauncher<Intent> {
    return page.registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result -> listener.onRequestResult(result) }
}

fun registerPermission(
    page: AppCompatActivity,
    listener: PermissionResult
): ActivityResultLauncher<String> {
    return page.registerForActivityResult(ActivityResultContracts.RequestPermission()) { result ->
        listener.onFinishRequestPermission(result)
    }
}

fun registerPermissions(
    page: AppCompatActivity,
    listener: PermissionsResult
): ActivityResultLauncher<Array<String>> {
    return page.registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { result: Map<String, Boolean> ->
        listener.onFinishRequestPermissions(
            result,
            !result.containsValue(false)
        )
    }
}


fun openSettingApp(activity: AppCompatActivity, picker: ActivityResultLauncher<Intent?>) {
    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
        data = Uri.fromParts("package", activity.packageName, null)
    }
    picker.launch(intent)
}

fun ActivityResultLauncher<String>.runPermissionNotification() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        launch(Manifest.permission.POST_NOTIFICATIONS)
    }
}

interface RequestResult {
    fun onRequestResult(result: ActivityResult)
}

interface PermissionResult {
    fun onFinishRequestPermission(isGranted: Boolean)
}

interface PermissionsResult {
    fun onFinishRequestPermissions(permissions: Map<String, Boolean>, isAllGranted: Boolean)
}