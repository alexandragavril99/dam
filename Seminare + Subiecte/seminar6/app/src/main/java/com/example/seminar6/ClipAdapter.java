package com.example.seminar6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ClipAdapter extends BaseAdapter{
    private List<ClipVideo> clipuri;
    private Context context;

    public ClipAdapter(List<ClipVideo> lista, Context ctx) {
        this.clipuri = lista;
        this.context = ctx;
    }

    @Override
    public int getCount() {
        return this.clipuri.size();
    }

    @Override
    public Object getItem(int position) {
        if(position>=0 && position <this.getCount()) {
            return this.clipuri.get(position);
        } else {
            throw new IllegalArgumentException("Parametru incorect");
        }
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View generatedView = inflater.inflate(R.layout.item_layout, parent,false);

        ClipVideo clip = (ClipVideo)getItem(position);
        TextView tvDurata = generatedView.findViewById(R.id.tvDurata);
        TextView tvTitlu = generatedView.findViewById(R.id.tvTitlu);
        TextView tvSpatiu = generatedView.findViewById(R.id.tvSpatiu);
        TextView tvGen = generatedView.findViewById(R.id.tvGen);
        tvDurata.setText(String.valueOf(clip.getDurata()));
        tvTitlu.setText(clip.getTitlu());
        tvSpatiu.setText(""+ clip.getSpatiuOcupat());
        tvGen.setText(""+clip.getGen());

        return generatedView;
    }
}
