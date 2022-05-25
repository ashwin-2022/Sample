package chat;
import java.io.*;
import java.net.*;
import java.util.*;

public class chatclient {

	public static void main(String args[])
	{
	 try
	 {
	  Socket s=new Socket("127.0.0.1",1229);
	  System.out.println("Enter the string");
	  
	  String msgin;
	  String msgout;
	  System.out.println("Enter the string at client");
	  //BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
	  ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
	  ObjectInputStream in = new ObjectInputStream(s.getInputStream());
	  
	  //msgout=inFromUser.readLine();
	  Scanner sc=new Scanner(System.in);
	  msgout=sc.nextLine();
	  
	  System.out.println("String sent to server");
	  
	  out.writeObject(msgout);  
	  System.out.println(msgout);
	  System.out.println("Received from server");
	  
	  msgin=(String)in.readObject();
	  System.out.println(msgin);
	  
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
