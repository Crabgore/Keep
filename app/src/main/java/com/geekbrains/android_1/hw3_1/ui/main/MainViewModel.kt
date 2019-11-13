package com.geekbrains.android_1.hw3_1.ui.main

import androidx.lifecycle.Observer
import com.geekbrains.android_1.hw3_1.data.NotesRepository
import com.geekbrains.android_1.hw3_1.data.entity.Note
import com.geekbrains.android_1.hw3_1.data.model.NoteResult
import com.geekbrains.android_1.hw3_1.ui.base.BaseViewModel

class MainViewModel(notesRepository: NotesRepository) : BaseViewModel<List<Note>?, MainViewState>() {

    private val noteObserver = Observer<NoteResult> {
        it ?: return@Observer

        when(it){
            is NoteResult.Success<*> -> {
                viewStateLiveData.value = MainViewState(notes = it.data as? List<Note>)
            }
            is NoteResult.Error -> {
                viewStateLiveData.value = MainViewState(error = it.error)
            }
        }
    }

    private val repositoryNotes = notesRepository.getNotes()

    init {
        viewStateLiveData.value = MainViewState()
        repositoryNotes.observeForever(noteObserver)
    }

    override fun onCleared() {
        repositoryNotes.removeObserver(noteObserver)
        super.onCleared()
    }
}