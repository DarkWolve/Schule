import java.awt.*;
import javax.swing.*;
/**
 * Beschreiben Sie hier die Klasse Platz.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Platz
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private int nummer;
    private JButton button;
    /**
     * Konstruktor für Objekte der Klasse Platz
     */
    public Platz(int nummer)
    {
        this.nummer = nummer;
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public int gibNummer()
    {
        return nummer;
    }
    
    public void setzButton(JButton button)
    {
        this.button = button;
    }   
    
    public JButton gibButton()
    {
        return button;
    }    
}
