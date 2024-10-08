package com.example.labweek4.model

import android.R.attr.name
import android.content.Context
import android.graphics.drawable.Drawable
import androidx.compose.ui.platform.LocalContext
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date


data class Feed(
    val username: String,
    val profilePicture: String,
    val content: String,
    val liked: Boolean,
    val saved: Boolean,
    val likes: Int,
    val caption: String,
    val date: String
){
    fun getPicture(picture: String, context: Context): Int {
        return context.resources.getIdentifier(picture, "drawable", context.packageName)
    }

    fun convertDate(dateText: String): String? {
        val dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        return try {
            val date = LocalDate.parse(dateText, dateFormat)
            if (date.year == 2023) {
                date.format(DateTimeFormatter.ofPattern("MMMM d"))
            } else {
                date.format(DateTimeFormatter.ofPattern("MMMM d, yyyy"))
            }
        } catch (e: Exception) {
            null
        }
    }

}
