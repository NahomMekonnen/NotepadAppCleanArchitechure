package com.example.notepadappcleanarchitechure.feature_note.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import androidx.navigation.navArgument
import com.example.notepadappcleanarchitechure.feature_note.presentation.add_edit_note.components.AddEditNoteScreen
import com.example.notepadappcleanarchitechure.feature_note.presentation.notes.NotesScreen
import com.example.notepadappcleanarchitechure.feature_note.presentation.util.Screen
import com.example.notepadappcleanarchitechure.ui.theme.NotepadAppCleanArchitechureTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NotepadAppCleanArchitechureTheme {
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier =  Modifier.statusBarsPadding()
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.NotesScreen.route
                    ) {
                        composable(route= Screen.NotesScreen.route) {
                            NotesScreen(navController = navController)
                        }
                        composable (
                            route = Screen.AddEditNoteScreen.route + "?noteId={noteId}&noteColor={noteColor}",
                            arguments = listOf(
                                navArgument(
                                    name = "noteId"
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                },
                                navArgument(
                                    name = "noteColor"
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                }
                            )
                        ){
                            val color = it.arguments?.getInt("noteColor") ?: -1
                            AddEditNoteScreen(
                                navController=navController,
                                noteColor = color
                            )
                        }
                    }
                }
            }
        }
    }
}