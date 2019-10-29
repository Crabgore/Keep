package com.geekbrains.android_1.hw3_1.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geekbrains.android_1.hw3_1.data.NotesRepository

class MainViewModel : ViewModel() {

    private val viewStateLiveData: MutableLiveData<MainViewState> = MutableLiveData()

    init {
        NotesRepository.getNotes().observeForever { notes ->
            notes?.let { viewStateLiveData.value = viewStateLiveData.value?.copy(notes = it)
                    ?: MainViewState(it) }
        }
    }

    fun viewState(): LiveData<MainViewState> = viewStateLiveData
}