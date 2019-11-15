package com.geekbrains.android_1.hw3_1.ui.note

import androidx.annotation.VisibleForTesting
import com.geekbrains.android_1.hw3_1.data.NotesRepository
import com.geekbrains.android_1.hw3_1.data.entity.Note
import com.geekbrains.android_1.hw3_1.data.model.NoteResult
import com.geekbrains.android_1.hw3_1.ui.base.BaseViewModel

class NoteViewModel(private val notesRepository: NotesRepository) : BaseViewModel<NoteViewState.Data, NoteViewState>() {

//    private var pendingNote: Note? = null
//
//    fun save(note: Note) {
//        pendingNote = note
//    }

    init {
        viewStateLiveData.value = NoteViewState(NoteViewState.Data())
    }

    private val pendingNote: Note?
        get() = viewStateLiveData.value?.data?.note

    fun save(note: Note) {
        viewStateLiveData.value?.data?.note = note
    }

    @VisibleForTesting
    public override fun onCleared() {
        pendingNote?.let {
            notesRepository.saveNote(it)
        }
    }

    fun loadNote(noteId: String) {
        notesRepository.getNoteById(noteId).observeForever {
            it ?: return@observeForever
            when (it) {
                is NoteResult.Success<*> -> viewStateLiveData.value = NoteViewState(NoteViewState.Data(note = it.data as? Note))
                is NoteResult.Error -> viewStateLiveData.value = NoteViewState(error = it.error)
            }
        }
    }

    fun deleteNote() {
        pendingNote?.let {
            notesRepository.deleteNote(it.id).observeForever { result ->
                result?.let { result ->
                    when (result) {
                        is NoteResult.Success<*> -> viewStateLiveData.value = NoteViewState(NoteViewState.Data(isDeleted = true))
                        is NoteResult.Error -> viewStateLiveData.value = NoteViewState(error = result.error)
                    }
                }
            }
        }
    }
}