package com.example.simpleboilerplate.ui.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.core.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val authRepository: AuthRepository
): ViewModel() {

    private val _resultLogout = MutableLiveData<Boolean>()
    val resultLogout: LiveData<Boolean> = _resultLogout

    fun logout(){
        CoroutineScope(Dispatchers.IO).launch {
            _resultLogout.postValue(authRepository.logout())
        }
    }
}