package valet.chilicon.rpgcharacter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterSkills extends RecyclerView.Adapter<AdapterSkills.SkillsViewHolder> {

    public static class SkillsViewHolder extends RecyclerView.ViewHolder {
        TextView skill, valueskill;

        public SkillsViewHolder(@NonNull View itemView) {
            super(itemView);
            skill = itemView.findViewById(R.id.txtSkill);
            valueskill = itemView.findViewById(R.id.txtValueskill);
        }
    }
    ArrayList<ClassSkill> listSkill;
    public AdapterSkills(ArrayList<ClassSkill> listSkill) {
        this.listSkill = listSkill;
    }

    @NonNull
    @Override
    public SkillsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_skills, viewGroup, false);
        SkillsViewHolder viewHolder = new SkillsViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SkillsViewHolder viewHolder, int position) {
        final ClassSkill skills = listSkill.get(position);
        viewHolder.skill.setText("- " +skills.getNom());
        if (skills.getValue().equals("")){
            viewHolder.valueskill.setVisibility(View.GONE);
        }
        else {
            viewHolder.valueskill.setText(skills.getValue());
            viewHolder.valueskill.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return listSkill.size();
    }
}
