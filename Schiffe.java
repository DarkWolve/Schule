import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
public class Schiffe 
{
    private ArrayList<JButton> schiffplaetze;
    private int anzahlPlaetze;

    /**
     * Konstruktor für Objekte der Klasse Schiff4er
     */
    public Schiffe(int anzahlPlaetze)
    {
        this.anzahlPlaetze= anzahlPlaetze;
        schiffplaetze = new ArrayList<JButton>();
    }
    
    public int gibanzahlPlaetze()
    {
        return anzahlPlaetze;
    }     
    
    public ArrayList<JButton> gibButtons()
    {
        return schiffplaetze;
    } 
    
    public void setzeButton(JButton button)
    {
        schiffplaetze.add(button);
    }    
}
