package com.geekbrains.android_1.hw3_1.data.provider

import androidx.lifecycle.LiveData
import com.geekbrains.android_1.hw3_1.data.entity.Note
import com.geekbrains.android_1.hw3_1.data.entity.User
import com.geekbrains.android_1.hw3_1.data.model.NoteResult

interface RemoteDataProvider {
    fun subscribeToAllNotes(): LiveData<NoteResult>
    fun getNoteById(id: String): LiveData<NoteResult>
    fun saveNote(note : Note): LiveData<NoteResult>
    fun deleteNote(note : Note)
    fun getCurrentUser() : LiveData<User?>
}