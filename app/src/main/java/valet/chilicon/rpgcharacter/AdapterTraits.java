package valet.chilicon.rpgcharacter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterTraits extends RecyclerView.Adapter<AdapterTraits.TraitsViewHolder> {

    public static class TraitsViewHolder extends RecyclerView.ViewHolder {
        TextView txtTraits;
        public TraitsViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTraits = itemView.findViewById(R.id.txtRecyclerTraits);
        }
    }
    ArrayList<String> listTraits = new ArrayList<>();
    public AdapterTraits(ArrayList<String> listTraits) {
        this.listTraits = listTraits;
    }

    @NonNull
    @Override
    public TraitsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_traits, viewGroup, false);
        TraitsViewHolder viewHolder = new TraitsViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TraitsViewHolder viewHolder, int position) {
        final String traits = listTraits.get(position);
                viewHolder.txtTraits.setText("- "+ traits);
    }

    @Override
    public int getItemCount() {
        return listTraits.size();
    }

}
