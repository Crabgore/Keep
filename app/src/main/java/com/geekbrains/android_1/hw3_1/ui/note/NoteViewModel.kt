package com.geekbrains.android_1.hw3_1.ui.note

import androidx.lifecycle.ViewModel
import com.geekbrains.android_1.hw3_1.data.NotesRepository
import com.geekbrains.android_1.hw3_1.data.entity.Note

class NoteViewModel: ViewModel() {
    private var pendingNote: Note? = null

    fun save(note: Note) {
        pendingNote = note
    }

    override fun onCleared() {
        pendingNote?.let {
            NotesRepository.saveNote(it)
        }
    }
}