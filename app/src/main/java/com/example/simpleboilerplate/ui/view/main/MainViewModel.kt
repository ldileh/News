package com.example.simpleboilerplate.ui.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.core.domain.repository.AuthRepository
import com.example.simpleboilerplate.domain.repository.GithubRepository
import com.skydoves.sandwich.message
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val githubRepository: GithubRepository
): ViewModel() {

    private val _resultLogout = MutableLiveData<Boolean>()
    val resultLogout: LiveData<Boolean> = _resultLogout

    fun logout(){
        CoroutineScope(Dispatchers.IO).launch {
            _resultLogout.postValue(authRepository.logout())
        }
    }

    fun getUsers(page: Int = 1){
        CoroutineScope(Dispatchers.IO).launch {
            githubRepository
                .getUsers("mojombo", page)
                .onSuccess {
                    Timber.d("number result: %d", this.data.size)
                }
                .onError {
                    Timber.e(this.message())
                }
        }
    }
}