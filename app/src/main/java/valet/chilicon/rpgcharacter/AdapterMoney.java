package valet.chilicon.rpgcharacter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import static valet.chilicon.rpgcharacter.PlayActivity.pa;
import static valet.chilicon.rpgcharacter.PlayActivity.pc;
import static valet.chilicon.rpgcharacter.PlayActivity.po;

public class AdapterMoney extends RecyclerView.Adapter<AdapterMoney.MoneyViewHolder> {

    public static class MoneyViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout linplus1, linplus5, linmoins1, linmoins5;
        ImageView imagePiece;
        public MoneyViewHolder(@NonNull View itemView) {
            super(itemView);
            linplus1 = itemView.findViewById(R.id.linPlus1);
            linplus5 = itemView.findViewById(R.id.linPlus5);
            linmoins1 = itemView.findViewById(R.id.linMoins1);
            linmoins5 = itemView.findViewById(R.id.linMoins5);
            imagePiece = itemView.findViewById(R.id.imgPiece);
        }
    }
    ArrayList<ClassPiece> list = new ArrayList<>();
    public AdapterMoney(ArrayList<ClassPiece> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MoneyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_money, viewGroup, false);
        MoneyViewHolder viewHolder = new MoneyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MoneyViewHolder moneyViewHolder, final int i) {
        final ClassPiece piece = list.get(i);
        switch (i) {
            case 0:
                moneyViewHolder.imagePiece.setImageResource(R.drawable.gold);
                break;
            case 1:
                moneyViewHolder.imagePiece.setImageResource(R.drawable.silver);
                break;
            case 2:
                moneyViewHolder.imagePiece.setImageResource(R.drawable.bronze);
                break;
        }
        moneyViewHolder.linmoins1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (piece.getQuantité() <= 0){
                    piece.setQuantité(0);
                    moneyViewHolder.linmoins1.setClickable(false);
                }
                else {
                    piece.setQuantité(piece.getQuantité() - 1);
                    moneyViewHolder.linmoins1.setClickable(true);
                }
                modifyPiece();
            }
        });
        moneyViewHolder.linmoins5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (piece.getQuantité() <= 0){
                    piece.setQuantité(0);
                    moneyViewHolder.linmoins5.setClickable(false);
                }
                else {
                    piece.setQuantité(piece.getQuantité() - 5);
                    moneyViewHolder.linmoins5.setClickable(true);
                }
                modifyPiece();
            }
        });
        moneyViewHolder.linplus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (piece.getQuantité() <= 0){
                    piece.setQuantité(0);
                    moneyViewHolder.linplus1.setClickable(false);
                }
                else {
                    piece.setQuantité(piece.getQuantité() + 1);
                    moneyViewHolder.linplus1.setClickable(true);
                }
                modifyPiece();
            }
        });
        moneyViewHolder.linplus5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (piece.getQuantité() <= 0){
                    piece.setQuantité(0);
                    moneyViewHolder.linplus5.setClickable(false);
                }
                else {
                    piece.setQuantité(piece.getQuantité() + 5);
                    moneyViewHolder.linplus5.setClickable(true);
                }
                modifyPiece();
            }
        });
        }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private void modifyPiece(){
        notifyDataSetChanged();
        if (list.get(1).getQuantité() >= 100){
            list.get(1).setQuantité(list.get(1).getQuantité()-100);
            list.get(0).setQuantité(list.get(0).getQuantité()+1);
        }
        if (list.get(2).getQuantité() >= 100){
            list.get(2).setQuantité(list.get(2).getQuantité()-100);
            list.get(1).setQuantité(list.get(1).getQuantité()+1);
        }
        po.setText(String.valueOf(list.get(0).getQuantité()));
        pa.setText(String.valueOf(list.get(1).getQuantité()));
        pc.setText(String.valueOf(list.get(2).getQuantité()));
        notifyDataSetChanged();
    }




}