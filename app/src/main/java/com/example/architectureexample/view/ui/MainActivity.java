package com.example.architectureexample.view.ui;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.architectureexample.R;
import com.example.architectureexample.viewModel.NoteViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NoteViewModel noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
        noteViewModel.getAllNote().observe(this, notes -> Toast.makeText(this, "" + notes.size(), Toast.LENGTH_SHORT).show());
//        noteViewModel.insert();
//        noteViewModel.update();
//        noteViewModel.delete();
//        noteViewModel.deleteAllNote();

    }
}
