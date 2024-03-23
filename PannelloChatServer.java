
public PannelloChatServer()
{
super() ;
this.setBackground (new Color (50, 100, 255));

// pannello superiore: lista nessaggi
JPanel panLista = new JPanel (new Borderlayout (20,5) );
pantista. setBackground (new Color (50, 100, 255));
lista = new List();
lista. setBackground (Color. lightGray) ;
lista. setSize (100,50) ;
lista. setVisible(true) ;

//scritte laterali
JLabel chat1 = new JLabel(" Chat ",JLabel. CENTER) ;
chat1. setForeground (new Color (200,100, 100)) ;
JLabel chat2 = new JLabel(" Chat ",JLabel. CENTER) ;
chat2. setForeground (new Color (200,100,100) ) ;

// aggiungiamo gli oggetti sul parnello
pantista. add (chat1, BorderLayout, EST) ;
pantista. add (Lista, BorderLayout. CENTER) ;
panLista. add (chat2,BorderLayout. EAST) ;

//pannello inserimento nuovo messaggio
JPanel nuovolex = new JPanel (new BorderLayout (20,5) ) ;
nuovolex. setBackground (new Color (50, 100, 255));
JLabel Labluovo = new JLabel ("Nuovo Messaggio →> ",JLabel. CENTER) ;
labNuovo. setForeground (new Color (255,255,0));
textWuovo = new JTextField("");
JButton buttonInvia = new JButton ("Invia") ;
buttonInvia. addActionListener (this);

// aggiungiamo gli oggetti sul pannello
nuovoMex. add (labNuovo ,BorderLayout. WEST) ;
nuovoMex. add (textNuovo ,BorderLayout. CENTER) ; 
nuovoMex. add (buttonInvia,BorderLayout. BAST) ;
this. setLayout (new BorderLayout (0,5));
add (panLista, BorderLayout. CENTER) ;
add (nuovoMex, BorderLayout. SOUTH) ;
connetti ();

}//fine costruttore classe PannelloChat

public void connetti()
{
    //istanzio il Thread per le connessioni : numero massimo giocatori = 10
    gestioneServizio = new ThreadGestioneServizioChat(10,lista);

}

public void acrionPerformed(actionEvent e)
{
    String bottone = e.getActionCommand();
    if(bottone.equals("Invia"))
    {
        gestioneServizio.spedisciMessaggio(textNuovo.getText());
        textNuovo.setText("");
    }
}

public void run()
{
    while(true){
        try{
            String mex=null;
            while((mex = input.readLine()==null))
            {}
            lista.add(mex);
                lista.select(lista.getItemCount()-1);
        }catch(Exception e){

        }
    }
}

public void spedisciMessaggioChat(String messaggio){
    try{
        otup.printl(messaggio);
    }catch (Exception e){

    }
}
