
/**
 * Beschreiben Sie hier die Klasse Spieler.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Spieler
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private String name;
    /**
     * Konstruktor für Objekte der Klasse Spieler
     */
    public Spieler(String name)
    {
        this.name = name;
    }

    public String gibName()
    {
        return name;
    }    
    
    public void changeName(String newname)
    {
        name = newname;
    }    
}
