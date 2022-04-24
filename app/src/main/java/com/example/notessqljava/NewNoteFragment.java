package com.example.notessqljava;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class NewNoteFragment extends Fragment {
    View root;
    TextView tv_cancel;
    TextView tv_save;
    EditText et_theme;
    EditText et_note;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_new_note, container, false);

        initViews();

        return root;
    }

    private void initViews() {
        tv_cancel = root.findViewById(R.id.tv_cancel);
        tv_save = root.findViewById(R.id.tv_save);
        et_note = root.findViewById(R.id.et_note);
        et_theme = root.findViewById(R.id.et_theme);

    }
}