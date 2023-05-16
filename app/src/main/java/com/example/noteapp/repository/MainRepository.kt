package com.example.noteapp.repository

import androidx.lifecycle.LiveData
import com.example.noteapp.data.NoteDao
import com.example.noteapp.model.NoteModel

class MainRepository (val noteDao: NoteDao){
    fun getAllNotes(): LiveData<List<NoteModel>> = noteDao.getNotes()

    fun getLowNotes(): LiveData<List<NoteModel>> = noteDao.getLowNotes()

    fun getHighNotes(): LiveData<List<NoteModel>> = noteDao.getHighNotes()

    fun getMediumNotes(): LiveData<List<NoteModel>> = noteDao.getMediumNotes()

    fun getCriticalNotes(): LiveData<List<NoteModel>> = noteDao.getCriticalNotes()

    fun getRoutineNotes(): LiveData<List<NoteModel>> = noteDao.getRoutineNotes()


    fun insertNotes(notes: NoteModel) {
        noteDao.insertNotes(notes)
    }

    fun deleteNotes(id: Int) {
        noteDao.deleteNotes(id)
    }

    fun updateNotes(notes: NoteModel) {
        noteDao.updateNotes(notes)
    }
}