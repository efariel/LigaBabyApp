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

import cl.ceeinf.ligababy.DatosGoles;

/**
 * Created by Edu on 24-04-2016.
 */
public class AdapterDatosGoles extends BaseAdapter {


    protected ArrayList<DatosGoles> items;
    protected Activity activity;

    public AdapterDatosGoles(Activity activity, ArrayList<DatosGoles> items) {
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
            v = inf.inflate(R.layout.item_goles, null);
        }
        DatosGoles datos =  items.get(position);
        DatosGoles dir = items.get(position);

        ImageView fotoequipo1 = (ImageView) v.findViewById(R.id.image_equipo1);
        fotoequipo1.setImageDrawable(datos.getFotoequipo1());


        TextView jugador = (TextView) v.findViewById(R.id.jugador);
        jugador.setText(datos.getJugador());

        return v;
    }


}
