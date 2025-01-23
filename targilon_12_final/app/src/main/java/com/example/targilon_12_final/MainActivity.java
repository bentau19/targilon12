package com.example.targilon_12_final;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private com.example.targilon12.SampleViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(com.example.targilon12.SampleViewModel.class);

        viewModel.getFoo().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String foo) {
                getSupportActionBar().setTitle(foo);
            }
        });

        FloatingActionButton btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(view -> {
            String currentDateTime = DateFormat.getDateTimeInstance().format(new Date());
            viewModel.getFoo().setValue(currentDateTime);
        });
    }
}