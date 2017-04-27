import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * Beschreiben Sie hier die Klasse Spielfeld.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Spielfeld
{
    private ArrayList<Reihe> reihen;
    private ArrayList<Buchstabe> alphabet;
    private ArrayList<JButton> buttons;
    private ArrayList<Zahl> zahlen;
    private int reiheno;
    private int plaetze;
    private JFrame spielframe;
    private JPanel spielfeld;
    private JPanel feldleiste;
    private JPanel seitenleiste;

    /**
     * Konstruktor für Objekte der Klasse Spielfeld
     */
    public Spielfeld(int reiheno, int plaetze)
    {
        reihen = new ArrayList<Reihe>();   
        alphabet = new ArrayList<Buchstabe>();
        buttons = new ArrayList<JButton>();
        zahlen = new ArrayList<Zahl>();
        this.reiheno = reiheno;
        this.plaetze = plaetze;
        alphabetMachen();
        zahlenMachen();
        spielfeldmachen(reiheno, plaetze);
    }

    public void reiheHinzufuegen(Reihe reihe)
    {
        reihen.add(reihe);
    }

    private void spielfeldmachen(int reiheno, int plaetze)
    {   
        spielframe = new JFrame("Spielfläche");
        seitenleiste = new JPanel(new GridLayout(1,2));
        feldleiste = new JPanel();
        feldleiste.setLayout(new GridLayout(reiheno, 1));
        JButton schiffe4 = new JButton("4er Schiff setzen");
        schiffe4.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae)
                {
                    placeship4();
                }});    
        seitenleiste.add(schiffe4);
        JButton schiffe3 = new JButton("3er Schiff setzen");
        schiffe3.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae)
                {
                    placeship3();
                }});
        seitenleiste.add(schiffe3);
        seitenleiste.add(feldleiste);
        spielframe.add(seitenleiste, BorderLayout.WEST);
        spielfeld = new JPanel();
        spielfeld.setLayout(new GridLayout(reiheno,plaetze));

        spielframe.add(spielfeld, BorderLayout.CENTER);
        spielframe.setVisible(true);
        for(int i=0; i< reiheno; i++)
        {
            Reihe reihe = new Reihe(alphabet.get(i).gibName());
            reihen.add(reihe);
            for(int p=0; p< plaetze;p++)
            {
                reihe.platzHinzufuegen(new Platz(zahlen.get(p).gibNummer()));
            }    
        }

        for(int i=0;i<reiheno;i++)
        {

            Reihe reihe = reihen.get(i);
            feldleiste.add(new JLabel(" " + reihe.gibName() + " "));
            for(int p=0; p<plaetze;p++)
            {
                int s = i;
                int t = p;
                JButton button = new JButton(reihe.gibName() + " " + reihe.gibPlatz(p).gibNummer());
                button.setName(reihe.gibName() + " " + reihe.gibPlatz(p).gibNummer());
                button.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent ae)
                        {
                            //buttonschiff(s, t);
                            schiffeSetzen();

                        }});

                reihe.gibPlatz(p).setzButton(button);
                spielfeld.add(button);
                buttons.add(button);
            }

        }   
        spielframe.pack();
        //String name = JOptionPane.showInputDialog(null, "What's your name?");
        //System.out.println(name);
    }    

    public void gibButtonaus(int i, int p)
    {
        JButton button = reihen.get(i).gibPlatz(p).gibButton();
        System.out.println(button.getName());

    } 
    
    public void placeship3()
    {
        
    }
    
    public void placeship4()
    {
    }
    public void schiffeSetzen()
    {
        Reihe reihei = new Reihe("");
        Object[] possibilities = alphabet.toArray();
        Object[] possibilities2 = zahlen.toArray();
        Object reiheo = JOptionPane.showInputDialog(spielframe, "Wähle die Reihe","Wähle die Reihe", JOptionPane.PLAIN_MESSAGE,  null, possibilities, "A");
        Buchstabe reiheb = (Buchstabe) reiheo;
        Object platz = JOptionPane.showInputDialog(spielframe, "Wähle den Platz","Wähle den Platz", JOptionPane.PLAIN_MESSAGE,  null, possibilities2, "1");
        int platznr = (int) platz;
        for(Reihe reihe: reihen)
        {
            if(reihe.gibName() == reiheb.toString())
            {
                reihei = reihe;
            }
        }    
        // FEHLER DIE REIHEN UND PLÄTZE VONEINANDER ABZIEHEN!!!!

        for(JButton button : buttons)
        {
            if(button.equals(reiheb.toString() + " " + platz))
            {
                if((reihen.indexOf(reihei)-3) - (reihen.indexOf(reihei)) != 3 || reihen.get(reihen.indexOf(reihei)).gibPlatz(-3).gibNummer() - reihen.get(reihen.indexOf(reihei)).gibPlatz(platznr).gibNummer() != 3)
                {
                    break;
                } 
                else if((reihen.indexOf(reihei)-2) - (reihen.indexOf(reihei)) != 2 || reihen.get(reihen.indexOf(reihei)).gibPlatz(-2).gibNummer() - reihen.get(reihen.indexOf(reihei)).gibPlatz(platznr).gibNummer() != 2)
                {
                    break;
                }  
                else if((reihen.indexOf(reihei)-1) - (reihen.indexOf(reihei)) != 1 || reihen.get(reihen.indexOf(reihei)).gibPlatz(-1).gibNummer() - reihen.get(reihen.indexOf(reihei)).gibPlatz(platznr).gibNummer() != 1)
                {
                    break;
                }
                else if((reihen.indexOf(reihei)+1) - (reihen.indexOf(reihei)) != -1 || reihen.get(reihen.indexOf(reihei)).gibPlatz(+1).gibNummer() - reihen.get(reihen.indexOf(reihei)).gibPlatz(platznr).gibNummer() != -1)
                {
                    break;
                }
                else if((reihen.indexOf(reihei)+2) - (reihen.indexOf(reihei)) != -2 || reihen.get(reihen.indexOf(reihei)).gibPlatz(+2).gibNummer() - reihen.get(reihen.indexOf(reihei)).gibPlatz(platznr).gibNummer() != -2)
                {
                    break;
                }  
                else if((reihen.indexOf(reihei)+3) - (reihen.indexOf(reihei)) != -3 || reihen.get(reihen.indexOf(reihei)).gibPlatz(+3).gibNummer() - reihen.get(reihen.indexOf(reihei)).gibPlatz(platznr).gibNummer() != -3)
                {
                    break;
                }
                else
                {

                }
            }   
        }
    }

    private void buttonschiff(int s, int t)
    { 
        for(int i=0;i<reiheno;i++)
        {
            Reihe reihe = reihen.get(i);
            for(int p=0; p<plaetze;p++)
            {
                JButton button = reihe.gibPlatz(p).gibButton();
                button.setEnabled(false);
            }

        }   
        //JButton button = reihen.get(s).gibPlatz(t).gibButton();
        //button.setEnabled(true);
        JButton button1 = reihen.get(s).gibPlatz(t-2).gibButton();
        button1.setEnabled(true);
        JButton button2 = reihen.get(s).gibPlatz(t-1).gibButton();
        button2.setEnabled(true);
        JButton button3 = reihen.get(s).gibPlatz(t+1).gibButton();
        button3.setEnabled(true);
        JButton button4 = reihen.get(s).gibPlatz(t+2).gibButton();
        button4.setEnabled(true);
        JButton button5 = reihen.get(s-2).gibPlatz(t).gibButton();
        button5.setEnabled(true);
        JButton button6 = reihen.get(s-1).gibPlatz(t).gibButton();
        button6.setEnabled(true);
        JButton button7 = reihen.get(s+1).gibPlatz(t).gibButton();
        button7.setEnabled(true);
        JButton button8 = reihen.get(s+2).gibPlatz(t).gibButton();
        button8.setEnabled(true);
        spielframe.pack();
    }

    private void alphabetMachen()
    {
        alphabet.add(new Buchstabe("A", 1));
        alphabet.add(new Buchstabe("B", 2));
        alphabet.add(new Buchstabe("C", 3));
        alphabet.add(new Buchstabe("D", 4));
        alphabet.add(new Buchstabe("E", 5));
        alphabet.add(new Buchstabe("F", 6));
        alphabet.add(new Buchstabe("G", 7));
        alphabet.add(new Buchstabe("H", 8));
        alphabet.add(new Buchstabe("I", 9));
        alphabet.add(new Buchstabe("J", 10));
        alphabet.add(new Buchstabe("K", 11));
        alphabet.add(new Buchstabe("L", 12));
        alphabet.add(new Buchstabe("M", 13));
        alphabet.add(new Buchstabe("N", 14));
        alphabet.add(new Buchstabe("O", 15));
        alphabet.add(new Buchstabe("P", 16));
        alphabet.add(new Buchstabe("Q", 17));
        alphabet.add(new Buchstabe("R", 18));
        alphabet.add(new Buchstabe("S", 19));
        alphabet.add(new Buchstabe("T", 20));
        alphabet.add(new Buchstabe("U", 21));
        alphabet.add(new Buchstabe("V", 22));
        alphabet.add(new Buchstabe("W", 23));
        alphabet.add(new Buchstabe("X", 24));
        alphabet.add(new Buchstabe("Y", 25));
        alphabet.add(new Buchstabe("Z", 26));
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
        zahlen.add(new Zahl(11));
        zahlen.add(new Zahl(12));
        zahlen.add(new Zahl(13));
        zahlen.add(new Zahl(14));
        zahlen.add(new Zahl(15));
        zahlen.add(new Zahl(16));
        zahlen.add(new Zahl(17));
        zahlen.add(new Zahl(18));
        zahlen.add(new Zahl(19));
        zahlen.add(new Zahl(20));        
    }    
}
