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
        
        buttonleiste1= new JPanel(new GridLayout(0,1));
        buttonleiste1.add(new JLabel("Schiffe :  POSITIONEN "));
        seitenleiste.add(buttonleiste1);
        /*JButton schiffe1 = new JButton("Schiff1");
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
        buttonleiste2.add(schiffe7);*/
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
            for(int p=0; p<plaetze;p++)
            {
                int s = i;
                int t = p;
                JButton button = new JButton(reihe.gibName() + " " + reihe.gibPlatz(p).gibNummer());
                button.setName(reihe.gibName() + " " + reihe.gibPlatz(p).gibNummer());
                button.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent ae)
                        {
                            schiffeSetzen(button);

                        }});

                reihe.gibPlatz(p).setzButton(button);
                spielfeld.add(button);
                buttons.add(button);
            }

        }   
        spielframe.pack();
    }    

    public void gibButtonaus(int i, int p)
    {
        JButton button = reihen.get(i).gibPlatz(p).gibButton();
        System.out.println(button.getName());

    } 

    public void schiffeSetzen(JButton button)
    {
        Object[] options = {"4 Felder Schiff",
                "3 Felder Schiff"};
        int schiffbig = JOptionPane.showOptionDialog(null,
                "Wähle die Größe des Schiffes ",
                "Schiff setzen",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                0);   

        Object[] options2 = {"Waagerecht",
                "Senkrecht"};
        int schiffpos = JOptionPane.showOptionDialog(null,
                "Wähle wie das Schiff gesetzt werden soll",
                "Schiff setzen",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options2,
                0); 
         
        if(schiffbig == 0)
        {
           if(schiffpos == 0 && schiffcounter4 > 0)
           {
               Platz platz = null;
               Reihe reihe = null;
               for(Reihe reihee : reihen)
               {
                   for(Platz platze : reihee.gibPlaetze())
                   {
                       if(platze.gibButton().equals(button))
                       {
                           platz = platze;
                           reihe = reihee;
                       }
                    }    
                }  
               schiffe4e.add(new Schiffe4(platz ,reihe.gibPlatz(platz.gibNummer()), reihe.gibPlatz(platz.gibNummer()+1), reihe.gibPlatz(platz.gibNummer()+2)));
               platz.gibButton().setEnabled(false);
               reihe.gibPlatz(platz.gibNummer()).gibButton().setEnabled(false);
               reihe.gibPlatz(platz.gibNummer()+1).gibButton().setEnabled(false);
               reihe.gibPlatz(platz.gibNummer()+2).gibButton().setEnabled(false);
               buttonleiste1.add(new JLabel("Schiff: " + reihe.gibName() + platz.gibNummer() + " " + reihe.gibName() + reihe.gibPlatz(platz.gibNummer()).gibNummer() + " " + reihe.gibName() +  reihe.gibPlatz(platz.gibNummer()+1).gibNummer() + " " + reihe.gibName() + reihe.gibPlatz(platz.gibNummer()+2).gibNummer()));
               schiffcounter4--;
            }
           else if(schiffpos == 1 && schiffcounter4 > 0)
           {
               Platz platz = null;
               Reihe reihe = null;
               for(Reihe reihee : reihen)
               {
                   for(Platz platze : reihee.gibPlaetze())
                   {
                       if(platze.gibButton().equals(button))
                       {
                           platz = platze;
                           reihe = reihee;
                       }
                    }    
                }  
               schiffe4e.add(new Schiffe4(platz ,reihen.get(reihen.indexOf(reihe)).gibPlatz(platz.gibNummer()-1), reihen.get(reihen.indexOf(reihe)+1).gibPlatz(platz.gibNummer()-1), reihen.get(reihen.indexOf(reihe)+2).gibPlatz(platz.gibNummer()-1)));
               platz.gibButton().setEnabled(false);
               reihen.get(reihen.indexOf(reihe)+1).gibPlatz(platz.gibNummer()-1).gibButton().setEnabled(false);
               reihen.get(reihen.indexOf(reihe)+2).gibPlatz(platz.gibNummer()-1).gibButton().setEnabled(false);
               reihen.get(reihen.indexOf(reihe)+3).gibPlatz(platz.gibNummer()-1).gibButton().setEnabled(false);
               buttonleiste1.add(new JLabel("Schiff: " + reihe.gibName() + platz.gibNummer() + " " + reihen.get(reihen.indexOf(reihe)+1).gibName() + platz.gibNummer() + " " + reihen.get(reihen.indexOf(reihe)+2).gibName() + platz.gibNummer() + " " + reihen.get(reihen.indexOf(reihe)+3).gibName() + platz.gibNummer()));
               schiffcounter4--;
           }
        }
        else if(schiffbig == 1 && schiffcounter3 > 0)
        {
           if(schiffpos == 0)
           {
               Platz platz = null;
               Reihe reihe = null;
               for(Reihe reihee : reihen)
               {
                   for(Platz platze : reihee.gibPlaetze())
                   {
                       if(platze.gibButton().equals(button))
                       {
                           platz = platze;
                           reihe = reihee;
                       }
                    }    
                }  
               schiffe3e.add(new Schiffe3(platz ,reihe.gibPlatz(platz.gibNummer()), reihe.gibPlatz(platz.gibNummer()+1)));
               platz.gibButton().setEnabled(false);
               reihe.gibPlatz(platz.gibNummer()).gibButton().setEnabled(false);
               reihe.gibPlatz(platz.gibNummer()+1).gibButton().setEnabled(false);
               buttonleiste1.add(new JLabel("Schiff: " + reihe.gibName() + platz.gibNummer() + " " + reihe.gibName() + reihe.gibPlatz(platz.gibNummer()).gibNummer() + " " + reihe.gibName() +  reihe.gibPlatz(platz.gibNummer()+1).gibNummer()));
               schiffcounter3--;
            }
           else if(schiffpos == 1 && schiffcounter4 > 0)
           {
               Platz platz = null;
               Reihe reihe = null;
               for(Reihe reihee : reihen)
               {
                   for(Platz platze : reihee.gibPlaetze())
                   {
                       if(platze.gibButton().equals(button))
                       {
                           platz = platze;
                           reihe = reihee;
                       }
                    }    
                }  
               schiffe3e.add(new Schiffe3(platz ,reihen.get(reihen.indexOf(reihe)).gibPlatz(platz.gibNummer()-1), reihen.get(reihen.indexOf(reihe)+1).gibPlatz(platz.gibNummer()-1)));
               platz.gibButton().setEnabled(false);
               reihen.get(reihen.indexOf(reihe)+1).gibPlatz(platz.gibNummer()-1).gibButton().setEnabled(false);
               reihen.get(reihen.indexOf(reihe)+2).gibPlatz(platz.gibNummer()-1).gibButton().setEnabled(false);
               buttonleiste1.add(new JLabel("Schiff: " + reihe.gibName() + platz.gibNummer() + " " + reihen.get(reihen.indexOf(reihe)+1).gibName() + platz.gibNummer() + " " + reihen.get(reihen.indexOf(reihe)+2).gibName() + platz.gibNummer()));
               schiffcounter3--;
           }
        }   
        spielframe.validate();
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
    }  

}
