package cl.ceeinf.ligababy;

import android.graphics.drawable.Drawable;

/**
 * Created by Edu on 19/05/2016.
 */
public class DatosPosiciones {

    protected long id;
    protected String equipo1;
    protected String PJ;
    protected String GF;
    protected String GC;
    protected Drawable fotoequipo1;
    protected String Pts;

    public DatosPosiciones(Drawable fotoequipo1, String equipo1, String PJ,
                         String GF, String GC, String Pts){
        this.fotoequipo1 = fotoequipo1;
        this.equipo1 = equipo1;
        this.PJ = PJ;
        this.GF = GF;
        this.GC = GC;
        this.Pts = Pts;
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

    public String getEquipo1() {
        return equipo1;
    }

    public String getPJ() {
        return PJ;
    }

    public String getGF() {
        return GF;
    }

    public String getGC() {
        return GC;
    }

    public String getPts() {
        return Pts;
    }

    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }

    public void setGC(String GC) {
        this.GC = GC;
    }

    public void setPJ(String PJ) {
        this.PJ = PJ;
    }

    public void setGF(String GF) {
        this.GF = GF;
    }

    public void setFotoequipo1(Drawable fotoequipo1) {
        this.fotoequipo1 = fotoequipo1;
    }

    public void setPts(String Pts) {
        this.Pts = Pts;
    }


}
