package cl.ceeinf.ligababy;

import android.graphics.drawable.Drawable;

/**
 * Created by Edu on 26-04-2016.
 */
public class Fotos {
    protected long id;
    protected Drawable foto_equipo1;

    public Fotos(Drawable foto_equipo1){
        this.foto_equipo1 = foto_equipo1;
        //  this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Drawable getFoto1() {
        return foto_equipo1;
    }

    public void setFoto1(Drawable foto1) {
        this.foto_equipo1 = foto1;
    }
}
