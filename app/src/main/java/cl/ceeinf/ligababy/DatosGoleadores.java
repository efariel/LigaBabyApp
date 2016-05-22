package cl.ceeinf.ligababy;

import android.graphics.drawable.Drawable;

/**
 * Created by Edu on 24-04-2016.
 */
public class DatosGoleadores {
    protected long id;
    protected String jugador;
    protected Drawable image_equipo1;

    public DatosGoleadores(Drawable image_equipo1, String jugador){
        this.image_equipo1 = image_equipo1;
        this.jugador = jugador;
        //  this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Drawable getFotoequipo1() {
        return image_equipo1;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador1) {
        this.jugador = jugador1;
    }

    public void setFotoequipo1(Drawable fotoequipo1) {
        this.image_equipo1 = fotoequipo1;
    }
}