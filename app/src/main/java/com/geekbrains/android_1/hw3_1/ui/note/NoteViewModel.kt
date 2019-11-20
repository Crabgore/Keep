package com.geekbrains.android_1.hw3_1.ui.note

import androidx.annotation.VisibleForTesting
import com.geekbrains.android_1.hw3_1.data.NotesRepository
import com.geekbrains.android_1.hw3_1.data.entity.Note
import com.geekbrains.android_1.hw3_1.ui.base.BaseViewModel
import kotlinx.coroutines.launch
import timber.log.Timber

class NoteViewModel(private val notesRepository: NotesRepository) : BaseViewModel<NoteData>() {
    private val currentNote: Note?
        get() = getViewState().poll()?.note

    fun save(note: Note) {
        setData(NoteData(note = note))
    }

    @VisibleForTesting
    public override fun onCleared() {
        launch {
            currentNote?.let { notesRepository.saveNote(it) }
            super.onCleared()
        }
    }

    fun loadNote(noteId: String) {
        Timber.d("Before launch")
        launch {
            try {
                Timber.d("Before getNoteById")
                notesRepository.getNoteById(noteId).let {
                    setData(NoteData(note = it))
                }
                Timber.d("After getNoteById")
            } catch (e: Throwable) {
                setError(e)
            }
        }

        Timber.d("After launch")
    }

    fun deleteNote() {
        launch {
            try {
                currentNote?.let { notesRepository.deleteNote(it.id) }
                setData(NoteData(isDeleted = true))
            } catch (e: Throwable) {
                setError(e)
            }
        }
    }
}