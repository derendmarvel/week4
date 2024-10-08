package com.example.labweek4.model

import android.content.Context

data class Story(
    val username: String,
    val profilePicture: String,
    val shared: Boolean,
    val liked: Boolean,
){
    fun getProfilePicture(profilePicture: String, context: Context): Int {
        return context.resources.getIdentifier(profilePicture, "drawable", context.packageName)
    }
}
