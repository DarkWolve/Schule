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
    private ArrayList<Schiffe3> schiffe3e;
    private ArrayList<Schiffe4> schiffe4e;
    private int reiheno;
    private int plaetze;
    private JFrame spielframe;
    private JPanel spielfeld;
    private JPanel buttonleiste2;
    private JPanel seitenleiste;
    private JPanel buttonleiste1;
    private int schiffcounter4= 3;
    private int schiffcounter3= 4;
    private int placing3 =4;
    private Buchstabe k ;
    /**
     * Konstruktor für Objekte der Klasse Spielfeld
     */
    public Spielfeld(int reiheno, int plaetze)
    {
        reihen = new ArrayList<Reihe>();   
        alphabet = new ArrayList<Buchstabe>();
        buttons = new ArrayList<JButton>();
        zahlen = new ArrayList<Zahl>();
        schiffe3e = new ArrayList<Schiffe3>();
        schiffe4e = new ArrayList<Schiffe4>();
        this.reiheno = reiheno;
        this.plaetze = plaetze;
        alphabetMachen();
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
        buttonleiste2 = new JPanel();
        buttonleiste2.setLayout(new GridLayout(7, 1));
        buttonleiste2.add(new JLabel("4 Felder große Schiffe    "));
        buttonleiste1= new JPanel(new GridLayout(7,1));
        buttonleiste1.add(new JLabel("  3 Felder große Schiffe"));
        seitenleiste.add(buttonleiste1);
        JButton schiffe1 = new JButton("Schiff1");
        schiffe1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae)
                {
                    //placeship3(schiffe1);
                }});    
        buttonleiste1.add(schiffe1);
        
        JButton schiffe2 = new JButton("Schiff2");
        schiffe2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae)
                {
                    //placeship3(schiffe2);
                }});
        buttonleiste1.add(schiffe2);
        
        JButton schiffe3 = new JButton("Schiff3");
        schiffe3.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae)
                {
                    //placeship3(schiffe3);
                }});    
        buttonleiste1.add(schiffe3);
        
        JButton schiffe4 = new JButton("Schiff4");
        schiffe4.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae)
                {
                    //placeship3(schiffe4);
                }});
        buttonleiste1.add(schiffe4);
        
        JButton schiffe5 = new JButton("Schiff5");
        schiffe5.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae)
                {
                    //placeship4(schiffe5);
                }});    
        buttonleiste2.add(schiffe5);
        
        JButton schiffe6 = new JButton("Schiff6");
        schiffe6.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae)
                {
                    //placeship4(schiffe6);
                }});
        buttonleiste2.add(schiffe6);
        
        JButton schiffe7 = new JButton("Schiff7");
        schiffe7.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae)
                {
                    // placeship4(schiffe7);
                }});    
        buttonleiste2.add(schiffe7);
        
        seitenleiste.add(buttonleiste2);
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
                reihe.platzHinzufuegen(new Platz(p+1));
            }    
        }

        for(int i=0;i<reiheno;i++)
        {

            Reihe reihe = reihen.get(i);
            //feldleiste.add(new JLabel(" " + reihe.gibName() + " "));
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
                            //schiffeSetzen();

                        }});
                button.setEnabled(false);
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
    
    /*public void placeship3(JButton button)
    {
        Reihe reihei = new Reihe("");
        Object[] possibilities = alphabet.toArray();
        Object[] possibilities2 = k.zahlen.toArray();
        Object reihe1 = JOptionPane.showInputDialog(spielframe, "Wähle die Reihe","Wähle die Reihe", JOptionPane.PLAIN_MESSAGE,  null, possibilities, "");
        Buchstabe reihea = (Buchstabe) reihe1;
        Object platz1 = JOptionPane.showInputDialog(spielframe, "Wähle den Platz","Wähle den Platz", JOptionPane.PLAIN_MESSAGE,  null, possibilities2, "");
        Zahl platznr1 = (Zahl) platz1;
        alphabet.get(alphabet.indexOf(reihea)).zahlen.remove(platznr1);
        possibilities2 = alphabet.get(alphabet.indexOf(reihea)).zahlen.toArray();
        Object platz2 = JOptionPane.showInputDialog(spielframe, "Wähle den Platz","Wähle den Platz", JOptionPane.PLAIN_MESSAGE,  null, possibilities2, "");
        Zahl platznr2 = (Zahl) platz2;
        alphabet.get(alphabet.indexOf(reihea)).zahlen.remove(platznr2);
        possibilities2 = alphabet.get(alphabet.indexOf(reihea)).zahlen.toArray();
        Object platz3 = JOptionPane.showInputDialog(spielframe, "Wähle den Platz","Wähle den Platz", JOptionPane.PLAIN_MESSAGE,  null, possibilities2, "");
        Zahl platznr3 = (Zahl) platz3;
        alphabet.get(alphabet.indexOf(reihea)).zahlen.remove(platznr3);
        Platz platzx = new Platz(0);
        Platz platzy = new Platz(0);
        Platz platzz = new Platz(0);
        for(Reihe reihe : reihen)
        {
            if(reihe.gibName().equals(reihea.gibName()))
            {   
                platzx = reihe.gibPlatz(platznr1.gibNummer()-1);
            }
            if(reihe.gibName().equals(reihea.gibName()))
            {   
                platzy = reihe.gibPlatz(platznr2.gibNummer()-1);
            }
            if(reihe.gibName().equals(reihea.gibName()))
            {   
                platzz = reihe.gibPlatz(platznr3.gibNummer()-1);
            }
        }    
       schiffe3e.add(new Schiffe3(platzx, platzy, platzz)); 
       button.setEnabled(false);
    }
    
    public void placeship4(JButton button)
    {
        Reihe reihei = new Reihe("");
        Object[] possibilities = alphabet.toArray();
        Object[] possibilities2 = k.zahlen.toArray();
        Object reihe1 = JOptionPane.showInputDialog(spielframe, "Wähle die Reihe","Wähle die Reihe", JOptionPane.PLAIN_MESSAGE,  null, possibilities, "");
        Buchstabe reihea = (Buchstabe) reihe1;
        Object platz1 = JOptionPane.showInputDialog(spielframe, "Wähle den Platz","Wähle den Platz", JOptionPane.PLAIN_MESSAGE,  null, possibilities2, "");
        Zahl platznr1 = (Zahl) platz1;
        alphabet.get(alphabet.indexOf(reihea)).zahlen.remove(platznr1);
        possibilities = alphabet.toArray();
        possibilities2 = zahlen.toArray();
        Object reihe2 = JOptionPane.showInputDialog(spielframe, "Wähle die Reihe","Wähle die Reihe", JOptionPane.PLAIN_MESSAGE,  null, possibilities, "");
        Buchstabe reiheb = (Buchstabe) reihe2;
        Object platz2 = JOptionPane.showInputDialog(spielframe, "Wähle den Platz","Wähle den Platz", JOptionPane.PLAIN_MESSAGE,  null, possibilities2, "");
        Zahl platznr2 = (Zahl) platz2;
        alphabet.get(alphabet.indexOf(reiheb)).zahlen.remove(platznr2);
        possibilities = alphabet.toArray();
        possibilities2 = zahlen.toArray();
        Object reihe3 = JOptionPane.showInputDialog(spielframe, "Wähle die Reihe","Wähle die Reihe", JOptionPane.PLAIN_MESSAGE,  null, possibilities, "");
        Buchstabe reihec = (Buchstabe) reihe3;
        Object platz3 = JOptionPane.showInputDialog(spielframe, "Wähle den Platz","Wähle den Platz", JOptionPane.PLAIN_MESSAGE,  null, possibilities2, "");
        Zahl platznr3 = (Zahl) platz3;
        alphabet.get(alphabet.indexOf(reihec)).zahlen.remove(platznr3);
        possibilities = alphabet.toArray();
        possibilities2 = zahlen.toArray();
        Object reihe4 = JOptionPane.showInputDialog(spielframe, "Wähle die Reihe","Wähle die Reihe", JOptionPane.PLAIN_MESSAGE,  null, possibilities, "");
        Buchstabe reihed = (Buchstabe) reihe4;
        Object platz4 = JOptionPane.showInputDialog(spielframe, "Wähle den Platz","Wähle den Platz", JOptionPane.PLAIN_MESSAGE,  null, possibilities2, "");
        Zahl platznr4 = (Zahl) platz4;
        alphabet.get(alphabet.indexOf(reihed)).zahlen.remove(platznr4);
        Platz platzx = new Platz(0);
        Platz platzy = new Platz(0);
        Platz platzz = new Platz(0);
        Platz platzr = new Platz(0);
        for(Reihe reihe : reihen)
        {
            if(reihe.gibName().equals(reihea.gibName()))
            {   
                platzx = reihe.gibPlatz(platznr1.gibNummer()-1);
            }
            if(reihe.gibName().equals(reihea.gibName()))
            {   
                platzy = reihe.gibPlatz(platznr2.gibNummer()-1);
            }
            if(reihe.gibName().equals(reihea.gibName()))
            {   
                platzz = reihe.gibPlatz(platznr3.gibNummer()-1);
            }
            if(reihe.gibName().equals(reihea.gibName()))
            {   
                platzr = reihe.gibPlatz(platznr4.gibNummer()-1);
            }
        }    
       schiffe4e.add(new Schiffe4(platzx, platzy, platzz, platzr)); 
       button.setEnabled(false);
    }*/

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
        k = new Buchstabe("K", 11);
    }  


}
