package com.example.notessqljava.adapter;

import android.content.Context;
import android.content.pm.LabeledIntent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notessqljava.R;
import com.example.notessqljava.model.Note;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<Note> items;

    NoteAdapter(Context context, ArrayList<Note> items){
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note_view, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Note item = items.get(position);

        if (holder instanceof NoteViewHolder){
            TextView tv_theme = ((NoteViewHolder) holder).tv_theme;
            TextView tv_note = ((NoteViewHolder) holder).tv_note;
            TextView tv_time = ((NoteViewHolder) holder).tv_time;

            tv_note.setText(item.getNote());
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private class NoteViewHolder extends RecyclerView.ViewHolder {
        private View view;
        private TextView tv_theme;
        private TextView tv_note;
        private TextView tv_time;

        public NoteViewHolder(View v) {
            super(v);
            view = v;
            tv_theme = view.findViewById(R.id.tv_theme);
            tv_note = view.findViewById(R.id.tv_note);
            tv_time = view.findViewById(R.id.tv_time);
        }
    }
}
