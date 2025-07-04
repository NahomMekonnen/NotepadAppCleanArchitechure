package com.example.notepadappcleanarchitechure.di

import android.app.Application
import androidx.room.Room
import com.example.notepadappcleanarchitechure.feature_note.data.data_source.NoteDatabase
import com.example.notepadappcleanarchitechure.feature_note.data.repository.NoteRepositoryImpl
import com.example.notepadappcleanarchitechure.feature_note.domain.repository.NoteRepository
import com.example.notepadappcleanarchitechure.feature_note.domain.use_case.DeleteNote
import com.example.notepadappcleanarchitechure.feature_note.domain.use_case.GetNotes
import com.example.notepadappcleanarchitechure.feature_note.domain.use_case.NotesUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application) : NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()

    }

    @Provides
    @Singleton
    fun provideNodeRepository (db: NoteDatabase) : NoteRepository{
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNodeUseCases(repository: NoteRepository) : NotesUseCases {
        return NotesUseCases (
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository)
        )
    }
}