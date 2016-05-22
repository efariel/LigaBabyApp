package cl.ceeinf.ligababy;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

import cl.ceeinf.ligababy.Fotos;

/**
 * Created by Edu on 26-04-2016.
 */
public class AdapterFotos extends BaseAdapter {

    protected ArrayList<Fotos> items;
    protected Activity activity;

    public AdapterFotos(Activity activity, ArrayList<Fotos> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if(convertView == null){
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.item_fotos, null);
        }
        Fotos fotos =  items.get(position);
        Fotos dir = items.get(position);

        ImageView foto1 = (ImageView) v.findViewById(R.id.fotos);
        foto1.setImageDrawable(fotos.getFoto1());

        return v;
    }
}
