package com.geekbrains.android_1.hw3_1.common

import java.text.SimpleDateFormat
import java.util.*

fun Date.format(format: String): String = SimpleDateFormat(format, Locale.getDefault()).format(this)