package com.example.adaptorpersonalizatbilet;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class EchipamentAdapter extends BaseAdapter {
    ArrayList<EchipamentSportiv> echipamentSportivArrayList;
    private Context context;

    public EchipamentAdapter(ArrayList<EchipamentSportiv> echipamentSportivArrayList, Context context) {
        this.echipamentSportivArrayList = echipamentSportivArrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.echipamentSportivArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        if(position>=0 && position<this.echipamentSportivArrayList.size()) {
            return this.echipamentSportivArrayList.get(position);
        } else return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View generatedView = inflater.inflate(R.layout.item_layout_lv, parent,false);

        EchipamentSportiv echipamentSportiv = (EchipamentSportiv) getItem(position);

        TextView tvDenumire = generatedView.findViewById(R.id.tvDenumire);
        TextView tvNrPiese = generatedView.findViewById(R.id.tvNrPiese);
        TextView tvGen = generatedView.findViewById(R.id.tvGen);

        tvDenumire.setText(echipamentSportiv.getDenumire().toString());
        tvNrPiese.setText(String.valueOf(echipamentSportiv.getNumparPiese()));
        tvGen.setText(echipamentSportiv.getGen().toString());

        Button btnClasificare = generatedView.findViewById(R.id.clasificare);
        btnClasificare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(echipamentSportiv.getNumparPiese() <25) {
                    generatedView.setBackgroundColor(Color.RED);
                } else if(echipamentSportiv.getNumparPiese() > 25) {
                    generatedView.setBackgroundColor(Color.GREEN);
                } else generatedView.setBackgroundColor(Color.BLUE);
            }
        });
        Button btnEditare = generatedView.findViewById(R.id.editare);
        btnEditare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return generatedView;
    }
}
