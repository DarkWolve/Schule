import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
public class Schiffe 
{
    private ArrayList<Platz> plaetze;
    private int anzahlPlaetze;

    /**
     * Konstruktor für Objekte der Klasse Schiff4er
     */
    public Schiffe(int anzahlPlaetze)
    {
        this.anzahlPlaetze= anzahlPlaetze;
        plaetze = new ArrayList<Platz>();
    }
    
    public int gibanzahlPlaetze()
    {
        return anzahlPlaetze;
    }     
    
    public ArrayList<Platz> gibPlatz()
    {
        return plaetze;
    } 
    
    public void setzePlatz(Platz platz)
    {
        plaetze.add(platz);
    }    
}
