package com.example.dam_bilet4_sesizare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SesizareAdapter extends BaseAdapter {
    private Context context;
    private List<Sesizare> list = new ArrayList<>();
    DateConverter dateConverter = new DateConverter();

    public SesizareAdapter(Context context, List<Sesizare> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        if(position>=0 && position<this.list.size()) {
            return list.get(position);
        }
        else return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View generatedView = inflater.inflate(R.layout.item_lv_layout,parent,false);

        Sesizare sesizare = (Sesizare)getItem(position);

        TextView tvTitlu = generatedView.findViewById(R.id.tvTitlu);
        TextView tvDesc = generatedView.findViewById(R.id.tvDescriere);
        TextView tvData = generatedView.findViewById(R.id.tvData);
        TextView tvTip = generatedView.findViewById(R.id.tvTip);

        tvTitlu.setText(sesizare.getTitlu());
        tvDesc.setText(sesizare.getDescriere());
        tvData.setText(sesizare.getDataInregistrarii().toString());

        tvTip.setText(sesizare.getTip().toString());

        return generatedView;
    }
}
