package com.example.notepadappcleanarchitechure.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.notepadappcleanarchitechure.ui.theme.BabyBlue
import com.example.notepadappcleanarchitechure.ui.theme.LightGreen
import com.example.notepadappcleanarchitechure.ui.theme.RedOrange
import com.example.notepadappcleanarchitechure.ui.theme.RedPink
import com.example.notepadappcleanarchitechure.ui.theme.Violet

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color : Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val nodeColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}
