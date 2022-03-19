package com.example.roompractice.screens.addNote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roompractice.REPOSITORY
import com.example.roompractice.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNoteViewModel: ViewModel() {

    fun insert(noteModel: NoteModel, onSuccess:() -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.insertNote(noteModel) {
                onSuccess()
            }
        }
}