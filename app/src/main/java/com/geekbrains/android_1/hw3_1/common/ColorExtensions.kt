package com.geekbrains.android_1.hw3_1.common

import android.content.Context
import androidx.core.content.ContextCompat
import com.geekbrains.android_1.hw3_1.R
import com.geekbrains.android_1.hw3_1.data.entity.Note

fun Note.Color.getColorInt(context: Context): Int = ContextCompat.getColor(
        context, when (this) {
    Note.Color.WHITE -> R.color.white
    Note.Color.YELLOW -> R.color.yellow
    Note.Color.GREEN -> R.color.green
    Note.Color.BLUE -> R.color.blue
    Note.Color.RED -> R.color.red
    Note.Color.VIOLET -> R.color.violet
}
)