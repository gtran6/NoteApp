package com.example.noteapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.noteapp.data.NoteDatabase
import com.example.noteapp.model.NoteModel
import com.example.noteapp.repository.MainRepository

class MainViewModel(application: Application): AndroidViewModel(application) {
    val repository: MainRepository

    init {
        val dao = NoteDatabase.getDatabaseInstance(application).noteDao()
        repository = MainRepository(dao)
    }

    fun addNotes(notes: NoteModel) {
        repository.insertNotes(notes)
    }

    fun getNotes(): LiveData<List<NoteModel>> = repository.getAllNotes()

    fun getLowNotes(): LiveData<List<NoteModel>> = repository.getLowNotes()

    fun getHighNotes(): LiveData<List<NoteModel>> = repository.getHighNotes()

    fun getMediumNotes(): LiveData<List<NoteModel>> = repository.getMediumNotes()

    fun getCriticalNotes(): LiveData<List<NoteModel>> = repository.getCriticalNotes()

    fun getRoutineNotes(): LiveData<List<NoteModel>> = repository.getRoutineNotes()

    fun deleteNotes(id: Int) {
        repository.deleteNotes(id)
    }

    fun updateNotes(notes: NoteModel) {
        repository.updateNotes(notes)
    }
}