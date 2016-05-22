package cl.ceeinf.ligababy;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Edu on 19/05/2016.
 */
public class AdapterDatosPosiciones extends BaseAdapter {

    protected ArrayList<DatosPosiciones> items;
    protected Activity activity;

    public AdapterDatosPosiciones(Activity activity, ArrayList<DatosPosiciones> items) {
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
            v = inf.inflate(R.layout.item_tabla_posiciones_2, null);
        }

        DatosPosiciones datos =  items.get(position);
        DatosPosiciones dir = items.get(position);

        ImageView fotoequipo1 = (ImageView) v.findViewById(R.id.image_equipo1);
        fotoequipo1.setImageDrawable(datos.getFotoequipo1());

        TextView equipo1 = (TextView) v.findViewById(R.id.equipo1);
        equipo1.setText(datos.getEquipo1());

        TextView PJ = (TextView) v.findViewById(R.id.PJ);
        PJ.setText(datos.getPJ());

        TextView GF = (TextView) v.findViewById(R.id.GF);
        GF.setText(datos.getGF());

        TextView GC = (TextView) v.findViewById(R.id.GC);
        GC.setText(datos.getGC());

        TextView Pts = (TextView) v.findViewById(R.id.Pts);
        Pts.setText(datos.getPts());

        return v;
    }


}
