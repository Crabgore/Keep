package com.geekbrains.android_1.hw3_1.ui.splash

import com.geekbrains.android_1.hw3_1.data.NotesRepository
import com.geekbrains.android_1.hw3_1.data.errors.NoAuthException
import com.geekbrains.android_1.hw3_1.ui.base.BaseViewModel

class SplashViewModel : BaseViewModel<Boolean?, SplashViewState>() {
    fun requestUser(){
        NotesRepository.getCurrentUser().observeForever {
            viewStateLiveData.value = if(it != null){
                SplashViewState(authenticated = true)
            } else {
                SplashViewState(error = NoAuthException())
            }
        }
    }
}