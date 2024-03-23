public class ThreadGestioneServizioChat implements Runnable 
{
    private int nrMaxConnessioni;
    private List lista;
    private ThreadChatConnessioni[] listaConnessioni;
    Thread me;
    private ServerSocket serverChat;

    public ThreadGestioneServizioChat(int numeroMaxConnessioni, List lista)
    {
        this.nrMaxConnessioni = nrMaxConnessioni-1;
        this.lista = lista;
        this.listaConnessioni = new ThreadChatConnessioni[this.nrMaxConnessioni];
        me = new Thread(this);
        me.start();
    }
    public void run()
    {
        boolean continua = true;

        try{
            serverChat = new ServerSocket(6789);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"impossibile instanziare server");
            continua = false;
        }
            if(continua){
                try{
                    for(int xx=0;xx<nrMaxConnessioni;xx++){
                        Socket tempo=null;
                        tempo = serverChat.accept();
                        listaConnessioni[xx] = ThreadChatConnessioni(this,tempo);
                    }
                    serverChat.close();
                }catch(Exception e){
                    JOptionPane.shoeMessageDialog(null,"impossibile instanziare chat");
                }
            }
    }
    
    public void spedisciMessaggio(String mex)
    {
        lista.add(mex);
        lista.select(lista.getItemCount()-1);

        for(int xx=0; xx<this.nrMaxConnessioni;xx++){
            if(listaConnessioni[xx] !=null )
            {
                listaConnessioni[xx].spedisciMessaggioChat(mex);
            }
        }
    }

}