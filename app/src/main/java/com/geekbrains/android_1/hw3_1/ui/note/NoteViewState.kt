package com.geekbrains.android_1.hw3_1.ui.note

import com.geekbrains.android_1.hw3_1.data.entity.Note
import com.geekbrains.android_1.hw3_1.ui.base.BaseViewState

class NoteViewState(data: Data = Data(), error: Throwable? = null) : BaseViewState<NoteViewState.Data>(data, error){
    data class Data(val isDeleted: Boolean = false, var note: Note? = null)
}