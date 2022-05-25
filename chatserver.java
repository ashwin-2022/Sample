package chat;
import java.io.*;
import java.net.*;
import java.util.*;

public class chatserver {
	public static void main(String[] args){
        System.out.println("Server");
        System.out.println("");
        try{
            ServerSocket ss = new ServerSocket(1229);
            
            Socket s = ss.accept();
            System.out.println("Connected with client IP " + s.getInetAddress().getHostAddress());
            System.out.println("");

            String msgin;
            String msgout;
            //BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            
            msgin=(String)in.readObject();
            System.out.println("Client: " + msgin);

            //msgout=inFromUser.readLine();
            System.out.print("Enter text to reply: ");
            Scanner sc=new Scanner(System.in);
            msgout=sc.nextLine();

            System.out.println("String sent to client");

            out.writeObject(msgout);  
            System.out.println("Server: " + msgout);

            s.close();
            in.close();
            out.close();
        }
        catch(Exception e)
        {
          System.out.println(e);
        }
    }
}

