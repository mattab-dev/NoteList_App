package pl.example.notelist.data.api;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import pl.example.notelist.data.Note;

@Dao
public interface NoteDAO {

    @Query("select * from note order by priority desc, createDate desc")
    LiveData<List<Note>> getAllNotes();

    @Insert
    void saveNote(Note note);
}
