import java.util.ArrayList;
/**
 * Beschreiben Sie hier die Klasse Reihe.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Reihe
{
    private String name;
    private ArrayList<Platz> plaetze;
    /**
     * Konstruktor für Objekte der Klasse Reihe
     */
    public Reihe(String name)
    {
        this.name = name;
        plaetze = new ArrayList<Platz>();
    }

    public void platzHinzufuegen(Platz platz)
    {
        plaetze.add(platz);
    }    

    public String gibName()
    {
        return name;
    }    
    
    public Platz gibPlatz(int platznr)
    {
        Platz platz = plaetze.get(platznr);
        return platz;
    }    
}
