package com.example.architectureexample.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.architectureexample.model.repository.NoteRepository;
import com.example.architectureexample.model.room.Note;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {
    private NoteRepository repository;
    private LiveData<List<Note>> allNote;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        repository = new NoteRepository(application);
        allNote = repository.getAllNote();
    }

    public void insert(Note note) {
     repository.insert(note);
    }

    public void update(Note note) {
        repository.update(note);
    }

    public void delete(Note note) {
        repository.delete(note);
    }

    public void deleteAllNote() {
        repository.deleteAllNote();
    }

    public LiveData<List<Note>> getAllNote() {
        return repository.getAllNote();
    }
}
