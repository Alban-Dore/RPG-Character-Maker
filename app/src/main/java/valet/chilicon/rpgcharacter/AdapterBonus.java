package valet.chilicon.rpgcharacter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterBonus extends RecyclerView.Adapter<AdapterBonus.BonusViewHolder> {

    public static class BonusViewHolder extends RecyclerView.ViewHolder {
        TextView bonus, valuesBonus;

        public BonusViewHolder(@NonNull View itemView) {
            super(itemView);
            bonus = itemView.findViewById(R.id.txtBonus);
            valuesBonus = itemView.findViewById(R.id.txtValuesBonus);
        }
    }
    ArrayList<ClassBonus> listBonus;

    public AdapterBonus(ArrayList<ClassBonus> listBonus) {
        this.listBonus = listBonus;
    }

    @NonNull
    @Override
    public BonusViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_bonus, viewGroup, false);
        BonusViewHolder viewHolder = new BonusViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BonusViewHolder viewHolder, int position) {
        final ClassBonus bonus = listBonus.get(position);

        viewHolder.bonus.setText("- "+bonus.getNom());
        viewHolder.valuesBonus.setText(bonus.getValue()+"%");
    }

    @Override
    public int getItemCount() {
        return listBonus.size();
    }
}
