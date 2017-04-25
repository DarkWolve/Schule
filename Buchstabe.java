
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
    /**
     * Konstruktor für Objekte der Klasse Alphabet
     */
    public Buchstabe(String name, int nummer)
    {
        this.name= name;
        this.nummer = nummer;
    }

    public String gibName()
    {
        return name;
    }
    
    public String toString()
    {
        return name;
    }    
}    
