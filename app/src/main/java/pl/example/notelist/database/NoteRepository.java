package pl.example.notelist.database;


import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import pl.example.notelist.data.Note;
import pl.example.notelist.data.api.NoteDAO;

public class NoteRepository {

    private NoteDAO noteDAO;
    private LiveData<List<Note>> allNotes;

    public NoteRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        noteDAO = db.noteDAO();
        allNotes = db.noteDAO().getAllNotes();
    }

    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }

    public void saveNote(Note note) {
        new saveAsyncTask(noteDAO).execute(note);
    }

    private static class saveAsyncTask extends AsyncTask<Note, Void, Void> {

        private NoteDAO asyncTaskDAO;

        saveAsyncTask(NoteDAO dao) {
            asyncTaskDAO = dao;
        }

        @Override
        protected Void doInBackground(final Note... params) {
            asyncTaskDAO.saveNote(params[0]);
            return null;
        }
    }
}
