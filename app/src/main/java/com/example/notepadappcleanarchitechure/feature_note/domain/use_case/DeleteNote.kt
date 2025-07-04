package com.example.notepadappcleanarchitechure.feature_note.domain.use_case

import com.example.notepadappcleanarchitechure.feature_note.domain.model.Note
import com.example.notepadappcleanarchitechure.feature_note.domain.repository.NoteRepository

class DeleteNote (
    private val repository: NoteRepository
) {
    suspend fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}