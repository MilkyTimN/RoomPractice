package com.example.roompractice.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.roompractice.REPOSITORY
import com.example.roompractice.db.NoteDatabase
import com.example.roompractice.db.repository.NoteRepositoryImplementation
import com.example.roompractice.model.NoteModel

class StartViewModel(application: Application): AndroidViewModel(application) {

    val context = application

    fun initDatabase() {
        val daoNote = NoteDatabase.getInstance(context).getNoteDao()
        REPOSITORY = NoteRepositoryImplementation(daoNote)
    }

    fun getALlNotes(): LiveData<List<NoteModel>>{
        return REPOSITORY.allNotes
    }
}