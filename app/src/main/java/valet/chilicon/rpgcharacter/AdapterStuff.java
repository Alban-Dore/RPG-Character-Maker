package valet.chilicon.rpgcharacter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterStuff extends RecyclerView.Adapter<AdapterStuff.StuffViewHolder> {

public static class StuffViewHolder extends RecyclerView.ViewHolder {

    TextView nomStuff, descStuff;
    Button deleteStuff;

    public StuffViewHolder(@NonNull View itemView) {
        super(itemView);
        descStuff  = itemView.findViewById(R.id.descStuff);
        nomStuff = itemView.findViewById(R.id.nomStuff);
        deleteStuff = itemView.findViewById(R.id.deleteStuff);
    }
}
    ArrayList<ClassStuff> stuffList;
    public AdapterStuff(ArrayList<ClassStuff> stuffList) {
        this.stuffList = stuffList;
    }

    @NonNull
    @Override
    public StuffViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_stuff, viewGroup, false);
        StuffViewHolder viewHolder = new StuffViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final StuffViewHolder viewHolder, int i) {
        final ClassStuff stuff = stuffList.get(i);
        viewHolder.nomStuff.setText("- "+stuff.getNom());
        if (!stuff.getDescription().equals("")) {
            viewHolder.descStuff.setText(stuff.getDescription());
            viewHolder.descStuff.setVisibility(View.VISIBLE);
        }
        else {
            viewHolder.descStuff.setVisibility(View.GONE);
        }

        viewHolder.deleteStuff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stuffList.remove(stuff);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return stuffList.size();
    }
}
