package javatcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    private ServerSocket serversocket;
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    
    //Constructor
    public Server(){
        try {
            serversocket = new ServerSocket(8080);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
            //Metodo para aceptar clientes
        public void accept(){
        try {
            socket = serversocket.accept();
            startStream();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        private void startStream(){
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        public void  readData(){
        try {
            String info = in.readUTF();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
}
