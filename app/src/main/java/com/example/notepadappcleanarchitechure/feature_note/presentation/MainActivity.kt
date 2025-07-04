package com.example.notepadappcleanarchitechure.feature_note.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.notepadappcleanarchitechure.ui.theme.NotepadAppCleanArchitechureTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NotepadAppCleanArchitechureTheme {

            }
        }
    }
}