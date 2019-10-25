import java.util.*;
import java.io.*;

public class chatbot
{

	HashMap<String,String> welcome=new HashMap<String,String>();
	HashMap<String,String> bye=new HashMap<String,String>();
	HashMap<String,String> msg=new HashMap<String,String>();
	
	chatbot()
	{
		welcome.put("hii","hii,how can i help u");
		welcome.put("hey","hey,hello");
		
		bye.put("bye","have a gud day");
		
		msg.put("money","where do u want to invest");
		msg.put("stock","are u interested in stock market");
		msg.put("invest","there are many investiong options");
		msg.put("bank","which bank would you choose");
		
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		
		chatbot c=new chatbot();
		
		while(true)
		{
			String s1=sc.nextLine();
			String op=c.find(s1);
			
			System.out.println(op);
		}
		
	}
	
	String find(String ip)
	{
		String tokens[]=ip.split("\\s");
		for(int i=0;i<tokens.length;i++)
		{
			String s1=tokens[i].trim().toLowerCase();
			
			if(welcome.containsKey(s1))
				return welcome.get(s1);
			if(msg.containsKey(s1))
				return msg.get(s1);
			if(bye.containsKey(s1))
				return bye.get(s1);
		}
		return "sorry i could not get the msg";
	}

}
