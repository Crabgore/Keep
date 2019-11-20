package com.geekbrains.android_1.hw3_1.ui.splash

import com.geekbrains.android_1.hw3_1.data.NotesRepository
import com.geekbrains.android_1.hw3_1.data.errors.NoAuthException
import com.geekbrains.android_1.hw3_1.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class SplashViewModel(private val notesRepository: NotesRepository) : BaseViewModel<Boolean?>() {
    fun requestUser() {
        launch {
            notesRepository.getCurrentUser()?.let {
                setData(true)
            } ?: setError(NoAuthException())
        }
    }
}