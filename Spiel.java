import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
/**
 * Beschreiben Sie hier die Klasse Spiel.
 * 
 * @author (Ir Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Spiel
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private JFrame hauptfenster;
    private int reihen;
    private int plaetze;
    private JMenuBar menubar;
    private JMenu spielbar;
    private JMenuItem startgame;
    private JMenuItem reihenchange;
    private JMenuItem plaetzechange;
    private JLabel info;
    private JPanel leisterechts;
    private Spieler spieler1;
    private Spieler spieler2;
    /**
     * Konstruktor für Objekte der Klasse Spiel
     */
    public Spiel()
    {
        fensterErzeugen();
        toDoList();
    }

    private void fensterErzeugen()
    {
        final int SHORTCUT_MASK =
            Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();

        hauptfenster = new JFrame("Schiffe Versenken");
        hauptfenster.setSize(800,500);
        
        String reiheninput= JOptionPane.showInputDialog(hauptfenster, "Geben Sie die Reihenanzahl an");
        while(reiheninput.length()<1)
        {   
            reiheninput = JOptionPane.showInputDialog(hauptfenster, "Geben Sie die Reihenanzahl an");
        }    
        reihen = Integer.parseInt(reiheninput);
        while(reihen<5)
        {   
            reiheninput = JOptionPane.showInputDialog(hauptfenster, "Geben Sie die Reihenanzahl an");
            reihen = Integer.parseInt(reiheninput);
        } 
       
        //System.out.println(reihen);
        String plaetzeinput= JOptionPane.showInputDialog(hauptfenster, "Geben Sie die Plätze pro Reihe an");
        while(plaetzeinput.length()<1)
        {   
            plaetzeinput = JOptionPane.showInputDialog(hauptfenster, "Geben Sie die Plätze pro Reihe an");
        }    
        plaetze = Integer.parseInt(plaetzeinput);
        while(plaetze<5)
        {   
            plaetzeinput = JOptionPane.showInputDialog(hauptfenster, "Geben Sie die Plätze pro Reihe an");
            plaetze = Integer.parseInt(plaetzeinput);
        }
        //System.out.println(plaetze);
        
        String spieler1name = JOptionPane.showInputDialog(hauptfenster, "Spieler 1, nennen Sie ihren Namen: ");    
        String spieler2name = JOptionPane.showInputDialog(hauptfenster, "Spieler 2, nennen Sie ihren Namen: ");
        while(spieler1name.length() < 1 || spieler2name.length() < 1)
        {    
            spieler1name = JOptionPane.showInputDialog(hauptfenster, "Spieler 1, nennen Sie jetzt ihren Namen!!!! ");    
            spieler2name = JOptionPane.showInputDialog(hauptfenster, "Spieler 2, nennen Sie jetzt ihren Namen!!!! ");
        }    
        spieler1 = new Spieler(spieler1name);
        spieler2 = new Spieler(spieler2name);
        
        info = new JLabel("Schiffeversenken Version 1.0 von Tobias M., Albert B. und Sebastian S.");
        hauptfenster.add(info, BorderLayout.SOUTH);
        
        leisterechts = new JPanel();
        leisterechts.setLayout(new GridLayout(4,1));
        hauptfenster.add(leisterechts, BorderLayout.WEST);
        
        //JLabel reihenlabel = new JLabel("Anzahl der Reihen: " + int2string(reihen));
        //JLabel plaetzelabel = new JLabel("Anzahl der Plätze pro Reihe: " + int2string(plaetze));
        
        //leisterechts.add(reihenlabel);
        //leisterechts.add(plaetzelabel);
        
        JButton reihenbutton = new JButton("Anzahl der Reihen: " + int2string(reihen));
        reihenbutton.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent a)
                        {
                            changereihe(reihenbutton);
                        }
                    });
        JButton plaetzebutton = new JButton("Anzahl der Plätze pro Reihe: " + int2string(plaetze));
        plaetzebutton.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent a)
                        {
                            changeplaetze(plaetzebutton);
                        }
                    });
                    
        JButton spieler1button = new JButton(spieler1name);
        spieler1button.setForeground(Color.BLUE);
        spieler1button.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent a)
                        {
                            spielernamechange(spieler1, spieler1button);
                        }
                    }); 
                    
        JButton spieler2button = new JButton(spieler2name);
        spieler2button.setForeground(Color.RED);
        spieler2button.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent a)
                        {
                            spielernamechange(spieler2, spieler2button);
                        }
                    });            
       
                    
                    
        leisterechts.add(reihenbutton);
        leisterechts.add(plaetzebutton);
        leisterechts.add(spieler1button);
        leisterechts.add(spieler2button);
        
        menubar = new JMenuBar();
        hauptfenster.setJMenuBar(menubar);

        spielbar = new JMenu("Spiel");
        menubar.add(spielbar);

        startgame = new JMenuItem("Starte Spiel");
        startgame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, SHORTCUT_MASK));
        startgame.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent ae)
                {
                    spielstarten();
                }
            });
        spielbar.add(startgame);

        
        reihenchange = new JMenuItem("Reihenanzahl ändern");
        reihenchange.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent ae)
                {
                    changereihe(reihenbutton);
                }
            });
        spielbar.add(reihenchange);
        
        
        plaetzechange = new JMenuItem("Plätze pro Reihe ändern");
        plaetzechange.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent ae)
                {
                    changeplaetze(plaetzebutton);
                }
            });
        spielbar.add(plaetzechange);
        JButton startg = new JButton("Spiel Starten");
        startg.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                spielstarten();
            }});    
        hauptfenster.add(startg, BorderLayout.CENTER);
      
        
        
        
        hauptfenster.setVisible(true);
        hauptfenster.pack();
        hauptfenster.setSize(800,500);
    }

    public void spielstarten()
    {
        Spielfeld feldspieler = new Spielfeld(reihen, plaetze);
        hauptfenster.setVisible(false);
        //Spielfeld feldspieler1 = new Spielfeld(reihen, plaetze);
    }
    
    public void changereihe(JButton button)
    {
        int reiheninput = Integer.parseInt(JOptionPane.showInputDialog(hauptfenster, "Geben Sie die neue Reihenanzahl an"));
        reihen = reiheninput;
        button.setText("Anzahl der Reihen: " + int2string(reihen));
        hauptfenster.validate();
        //System.out.println(reihen);
    }
    
    public void changeplaetze(JButton button)
    {
        int plaetzeinput = Integer.parseInt(JOptionPane.showInputDialog(hauptfenster, "Geben Sie die neuen Plätze pro Reihe an"));
        plaetze= plaetzeinput;
        button.setText("Anzahl der Plätze pro Reihe: " + int2string(plaetze));
        hauptfenster.validate();
        //System.out.println(plaetze);
    }
    
    private String int2string(int i)
    {
        String string = "" + i;
        return string;
    } 
    
    private void spielernamechange(Spieler spieler, JButton button)
    {
        String neuname = JOptionPane.showInputDialog(hauptfenster, "Spieler, nennen Sie ihren neuen Namen: ");
        spieler.changeName(neuname);
        button.setText(neuname);
        hauptfenster.validate();
    }  
    
    private void toDoList()
    {
        System.out.println("ToDo-List");
        //System.out.println("Name change ändert noch nicht den Namen im Button");
        //System.out.println("Reihen ändern gib null pointer exception");
    }    
}
