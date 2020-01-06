package com.example.architectureexample.model.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.architectureexample.model.room.Note;
import com.example.architectureexample.model.room.NoteDao;
import com.example.architectureexample.model.room.NoteDatabase;

import java.util.List;

import io.reactivex.schedulers.Schedulers;

public class NoteRepository {

    private NoteDao noteDao;
    private LiveData<List<Note>> allNote;

    public NoteRepository(Application application) {
        NoteDatabase database = NoteDatabase.getInstance(application);
        noteDao = database.noteDao();
        allNote = noteDao.getAllNote();
    }

    public void insert(Note note) {

        noteDao.insert(note).subscribeOn(Schedulers.io()).subscribe();
    }

    public void update(Note note) {
        noteDao.update(note).subscribeOn(Schedulers.io()).subscribe();
    }

    public void delete(Note note) {
        noteDao.delete(note).subscribeOn(Schedulers.io()).subscribe();
    }

    public void deleteAllNote() {
        noteDao.deleteAllNote().subscribeOn(Schedulers.io()).subscribe();
    }

    public LiveData<List<Note>> getAllNote() {
        return allNote;
    }


}
