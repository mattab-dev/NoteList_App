package pl.example.notelist.data.viewModels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import pl.example.notelist.data.Note;
import pl.example.notelist.database.NoteRepository;

public class NoteViewModel extends AndroidViewModel {

    private NoteRepository repo;
    private LiveData<List<Note>> allNotes;

    public NoteViewModel (Application application) {
        super(application);
        repo = new NoteRepository(application);
        allNotes = repo.getAllNotes();
    }

    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }

    public void saveNote(Note note) {
        repo.saveNote(note);
    }

}
