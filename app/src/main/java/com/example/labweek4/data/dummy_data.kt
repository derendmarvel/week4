package com.example.labweek4.data

import com.example.labweek4.R
import com.example.labweek4.model.categories
import com.example.labweek4.model.line_chat
import com.example.labweek4.model.products


class dummy_data {
    fun get_data_line(): List<line_chat> {
        return listOf(
            line_chat("Willas Tobing",  "Aku belum mandi bang", "Yesterday"),
            line_chat("Jason Miracle", "Puh, sepuh, ajarin dong puh, sepuh", "Yesterday"),
            line_chat("Cristiano Ronaldo", "I need money", "6/10/24"),
            line_chat("Lionel Messi",  "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "5/10/24"),
            line_chat("Justin Bieber", "Halo", "30/9/24"),
            line_chat("Ed Sheeran", "Tolong", "30/9/24"),
            line_chat("Rafi Abhista",  "Otw bang", "28/9/24"),
            line_chat("Ariana Grande",  "I'm excited about the upcoming game.", "25/9/24"),
            line_chat("Ultraman",  "I need new sneakers.", "21/9/24"),
            line_chat("Baby Shark", "Let's hit the gym early.", "18/9/24")
        )
    }
}