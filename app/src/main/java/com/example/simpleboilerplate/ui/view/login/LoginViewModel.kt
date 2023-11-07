package com.example.simpleboilerplate.ui.view.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.core.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository
): ViewModel() {

    private val _isProgressLogin = MutableLiveData<Boolean>()
    val isProgressLogin: LiveData<Boolean> = _isProgressLogin

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> = _message

    private val _loginResult = MutableLiveData<Boolean>()
    val loginResult: LiveData<Boolean> = _loginResult

    private val _isSessionExist = MutableLiveData<Boolean>()
    val isSessionExist: LiveData<Boolean> = _isSessionExist

    fun login(username: String, password: String) {
        CoroutineScope(Dispatchers.IO).launch {

            _isProgressLogin.postValue(true)

            // add some dummy progress
            delay(2000)
            _isProgressLogin.postValue(false)

            val loginResult = authRepository.login(username, password)
            _loginResult.postValue(loginResult)
            if(!loginResult){
                _message.postValue("Failed login")
            }
        }
    }

    fun checkSession(){
        _isSessionExist.value = authRepository.isLoggedIn()
    }
}