package com.example.noteapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.noteapp.model.NoteModel
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("SELECT * FROM note_table")
    fun getNotes() : LiveData<List<NoteModel>>

    @Query("SELECT * FROM note_table WHERE priority=5")
    fun getCriticalNotes(): LiveData<List<NoteModel>>

    @Query("SELECT * FROM note_table WHERE priority=4")
    fun getHighNotes(): LiveData<List<NoteModel>>

    @Query("SELECT * FROM note_table WHERE priority=3")
    fun getMediumNotes(): LiveData<List<NoteModel>>

    @Query("SELECT * FROM note_table WHERE priority=2")
    fun getLowNotes(): LiveData<List<NoteModel>>

    @Query("SELECT * FROM note_table WHERE priority=1")
    fun getRoutineNotes(): LiveData<List<NoteModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNotes(notes: NoteModel)

    @Query("DELETE FROM note_table WHERE id=:id")
    fun deleteNotes(id: Int)

    @Update
    fun updateNotes(notes: NoteModel)
}