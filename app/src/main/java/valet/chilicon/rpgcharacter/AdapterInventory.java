package valet.chilicon.rpgcharacter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterInventory extends RecyclerView.Adapter<AdapterInventory.InventoryViewHolder> {

public static class InventoryViewHolder extends RecyclerView.ViewHolder {

    TextView nbInvent, nomInvent;
    Button removeInvent, addInvent, deleteInvent;

    public InventoryViewHolder(@NonNull View itemView) {
        super(itemView);
        nbInvent  = itemView.findViewById(R.id.nombreInventory);
        nomInvent = itemView.findViewById(R.id.nomInventory);
        removeInvent = itemView.findViewById(R.id.btnmoinsInventory);
        addInvent = itemView.findViewById(R.id.btnplusInventory);
        deleteInvent = itemView.findViewById(R.id.inventoryDelete);
    }
}
    ArrayList<ClassInventory> inventoryList;
    public AdapterInventory(ArrayList<ClassInventory> inventoryList) {
        this.inventoryList = inventoryList;
    }

    @NonNull
    @Override
    public InventoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_inventory, viewGroup, false);
        InventoryViewHolder viewHolder = new InventoryViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final InventoryViewHolder viewHolder, int i) {
        final ClassInventory inventaire = inventoryList.get(i);

            viewHolder.nbInvent.setText(String.valueOf(inventaire.getQuantite()));

        viewHolder.nomInvent.setText(inventaire.getNom());

        viewHolder.addInvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inventaire.setQuantite(inventaire.getQuantite()+1);
                viewHolder.nbInvent.setText(String.valueOf(inventaire.getQuantite()));
                notifyDataSetChanged();
            }
        });
        viewHolder.removeInvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inventaire.getQuantite() == 0){
                    viewHolder.removeInvent.setClickable(false);
                }
                else {
                    inventaire.setQuantite(inventaire.getQuantite()-1);
                    viewHolder.nbInvent.setText(String.valueOf(inventaire.getQuantite()));
                    notifyDataSetChanged();
                }
            }
        });
        viewHolder.deleteInvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inventoryList.remove(inventaire);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return inventoryList.size();
    }
}
