package valet.chilicon.rpgcharacter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterChoosecharacter extends RecyclerView.Adapter<AdapterChoosecharacter.ChooseViewHolder> {

    public static class ChooseViewHolder extends RecyclerView.ViewHolder {

        TextView nom, lvl, race, classe;
        LinearLayout lin;
        Button delete;
        ImageView img;

        public ChooseViewHolder(@NonNull View itemView) {
            super(itemView);
            img  = itemView.findViewById(R.id.imgChoose);
            nom = itemView.findViewById(R.id.nameChoose);
            lvl = itemView.findViewById(R.id.levelChoose);
            race = itemView.findViewById(R.id.raceChoose);
            classe = itemView.findViewById(R.id.classChoose);
            delete = itemView.findViewById(R.id.deleteChoose);
            lin = itemView.findViewById(R.id.linearChoose);
        }
    }
    ArrayList<ClassCharacter> choosePerso;
    public AdapterChoosecharacter( ArrayList<ClassCharacter> choosePerso) {
        this.choosePerso = choosePerso;
    }

    @NonNull
    @Override
    public ChooseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_choose_charac, viewGroup, false);
        ChooseViewHolder viewHolder = new ChooseViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ChooseViewHolder viewHolder, final int i) {
        final ClassCharacter perso = choosePerso.get(i);

        viewHolder.nom.setText(perso.getName());
        viewHolder.lvl.setText(String.valueOf(perso.getLevel()));
        viewHolder.race.setText(perso.getRace());
        viewHolder.classe.setText(perso.getClasse());
        viewHolder.img.setBackground(perso.getImage().getDrawable());

        viewHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePerso.remove(perso);
                notifyDataSetChanged();
            }
        });
        viewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Test = new Intent(v.getContext(), PlayActivity.class);
                Test.putExtra("namePerso",choosePerso.get(i).getName());
                v.getContext().startActivity(Test);
            }
        });

        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return choosePerso.size();
    }

}
