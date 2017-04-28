import java.util.ArrayList;
/**
 * Beschreiben Sie hier die Klasse Alphabet.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Buchstabe
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private String name;
    private int nummer;
    protected ArrayList<Zahl> zahlen;
    /**
     * Konstruktor für Objekte der Klasse Alphabet
     */
    public Buchstabe(String name, int nummer)
    {
        this.name= name;
        this.nummer = nummer;
        zahlen = new ArrayList<Zahl>();
        zahlenMachen();
    }

    public String gibName()
    {
        return name;
    }
    
    public String toString()
    {
        return name;
    }
    
        private void zahlenMachen()
    {
        zahlen.add(new Zahl(1));
        zahlen.add(new Zahl(2));
        zahlen.add(new Zahl(3));
        zahlen.add(new Zahl(4));
        zahlen.add(new Zahl(5));
        zahlen.add(new Zahl(6));
        zahlen.add(new Zahl(7));
        zahlen.add(new Zahl(8));
        zahlen.add(new Zahl(9));
        zahlen.add(new Zahl(10));     
    }  
    public ArrayList<Zahl> gibZahlen()
    {
        return zahlen;
    }    
}    
