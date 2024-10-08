package com.example.labweek4.model

import android.content.Context

data class Explore(
    val content: String
){
    fun getPicture(content: String, context: Context): Int {
        return context.resources.getIdentifier(content, "drawable", context.packageName)
    }
}
