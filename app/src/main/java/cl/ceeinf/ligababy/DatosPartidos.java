package cl.ceeinf.ligababy;

import android.graphics.drawable.Drawable;

/**
 * Created by Edu on 23-04-2016.
 */
public class DatosPartidos {

    protected long id;
    protected String equipo1;
    protected String equipo2;
    protected String hora;
    protected String fecha;
    protected Drawable fotoequipo1;
    protected Drawable fotoequipo2;

    public DatosPartidos(Drawable fotoequipo1, Drawable fotoequipo2, String equipo1, String equipo2,
    String fecha, String hora){
        this.fotoequipo1 = fotoequipo1;
        this.fotoequipo2 = fotoequipo2;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.fecha = fecha;
        this.hora = hora;
      //  this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Drawable getFotoequipo1() {
        return fotoequipo1;
    }

    public Drawable getFotoequipo2() {
        return fotoequipo2;
    }

    public String getEquipo1() {
        return equipo1;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }

    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setFotoequipo1(Drawable fotoequipo1) {
        this.fotoequipo1 = fotoequipo1;
    }

    public void setFotoequipo2(Drawable fotoequipo2) {
        this.fotoequipo2 = fotoequipo2;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
