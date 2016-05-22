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

import cl.ceeinf.ligababy.DatosPartidos;
import cl.ceeinf.ligababy.fragments.tabla_posiciones_1;

/**
 * Created by Edu on 23-04-2016.
 */
public class AdapterDatosPartido extends BaseAdapter {

    protected ArrayList<DatosPartidos> items;
    protected Activity activity;

    public AdapterDatosPartido(Activity activity, ArrayList<DatosPartidos> items) {
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
            v = inf.inflate(R.layout.item_lista, null);
        }
        DatosPartidos datos =  items.get(position);
        DatosPartidos dir = items.get(position);

        ImageView fotoequipo1 = (ImageView) v.findViewById(R.id.image_equipo1);
        fotoequipo1.setImageDrawable(datos.getFotoequipo1());

        ImageView fotoequipo2 = (ImageView) v.findViewById(R.id.image_equipo2);
        fotoequipo2.setImageDrawable(datos.getFotoequipo2());

        TextView equipo1 = (TextView) v.findViewById(R.id.equipo1);
        equipo1.setText(datos.getEquipo1());

        TextView equipo2 = (TextView) v.findViewById(R.id.equipo2);
        equipo2.setText(datos.getEquipo2());

        TextView fecha = (TextView) v.findViewById(R.id.fecha);
        fecha.setText(datos.getFecha());

        TextView hora = (TextView) v.findViewById(R.id.hora);
        hora.setText(datos.getHora());

        return v;
    }


}
