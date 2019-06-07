package pl.example.notelist.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import pl.example.notelist.R;
import pl.example.notelist.data.IconPack;
import pl.example.notelist.data.Note;

public class NoteListAdapter extends RecyclerView.Adapter<NoteListAdapter.NoteViewHolder> {
    private List<Note> noteList;
    private final LayoutInflater inflater;

    public NoteListAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = inflater.inflate(R.layout.custom_list_item, viewGroup, false);
        NoteViewHolder holder = new NoteViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {
        if (noteList != null) {
            Note current = noteList.get(position);
            holder.noteTitle.setText(current.getTitle());
            holder.noteShort.setText(current.getContent());

            String url = IconPack.iconList[current.getCategory().getCategory()];

            Picasso.with(holder.itemView.getContext())
                    .load(url)
                    .into(holder.noteImg);
        }

    }

    public void setNotes(List<Note> notes) {
        noteList = notes;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (noteList != null)
            return noteList.size();
        else
            return 0;

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    public class NoteViewHolder extends RecyclerView.ViewHolder {
        public TextView noteTitle;
        public TextView noteShort;
        public ImageView noteImg;

        public NoteViewHolder(View itemView) {
            super(itemView);
            noteTitle = itemView.findViewById(R.id.noteTitle);
            noteShort = itemView.findViewById(R.id.noteShort);
            noteImg = itemView.findViewById(R.id.noteImg);
        }
    }
}

