package com.geekbrains.android_1.hw3_1.data

import com.geekbrains.android_1.hw3_1.data.entity.Note
import com.geekbrains.android_1.hw3_1.data.provider.RemoteDataProvider

class NotesRepository(private val remoteProvider: RemoteDataProvider) {

    fun getNotes() = remoteProvider.subscribeToAllNotes()
    fun saveNote(note: Note) = remoteProvider.saveNote(note)
    fun getNoteById(id: String) = remoteProvider.getNoteById(id)
    fun getCurrentUser() = remoteProvider.getCurrentUser()
    fun deleteNote(noteId: String) = remoteProvider.deleteNote(noteId)
}