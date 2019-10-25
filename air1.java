import java.util.*;
import java.io.*;

public class air1
{
	int bx=0,by=0;
	int g=0,h=0;
	String tar[][]=new String[3][3];
	String goal[][]=new String[3][3];
	String dum[][]=new String[3][3];
	
	HashMap<String, String> hmx=new HashMap<String, String>();
	HashMap<String, String> hmy=new HashMap<String, String>();
	HashMap<String, String> hf=new HashMap<String, String>();
	
	public static void main(String args[])
	{
		air1 a=new air1();
		a.exec();	
	}
	
	void exec()
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter input");
		
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				tar[i][j]=sc.next();
				if(tar[i][j]=="_")
				{
					bx=i;
					by=j;
				}
			}
		}
		
		System.out.println("enter goal");
		
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				goal[i][j]=sc.next();
				hmx.put(goal[i][j],String.valueOf(i));
				hmy.put(goal[i][j],String.valueOf(j));
			}
		}
		
		while(check()!=1)
		{
			hf();
			g++;
		}
	}
	
	int check()
	{
		int f=1;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(!tar[i][j].equals(goal[i][j]))
				{
					f=0;
					break;
				}
			}
		}
		return f;
	}
	
	void hf()
	{
		int f1=0,f2=0,f3=0,f4=0;
		int f=1000;
		int minx=0,miny=0;
		
		String gg;
		if(bx+1<=2)
		{
			copy(bx+1,by);
			gg=getHash();
			
			if(!hf.containsKey(gg))
			{
				f1=gethf();
				if(f1<f)
					f=f1;
			}
		}
		if(bx-1>=0)
		{
			copy(bx-1,by);
			gg=getHash();
			
			if(!hf.containsKey(gg))
			{
				f2=gethf();
				if(f2<f)
					f=f2;
			}
		}
		if(by-1>=0)
		{
			copy(bx,by-1);
			gg=getHash();
			
			if(!hf.containsKey(gg))
			{
				f3=gethf();
				if(f3<f)
					f=f3;
			}
		}
		if(by+1<=2)
		{
			copy(bx,by+1);
			gg=getHash();
			
			if(!hf.containsKey(gg))
			{
				f4=gethf();
				if(f4<f)
					f=f4;
			}
		}
		
		if(bx+1<=2 && f==f1)
		{
			copy(bx+1,by);
			minx=bx+1;
			miny=by;
			gg = getHash();
			hf.put(gg,"0");
		}
		else if(bx-1>=2 && f==f2)
		{
			copy(bx-1,by);
			minx=bx-1;
			miny=by;
			gg = getHash();
			hf.put(gg,"0");
		}
		else if(by-1>=0 && f==f3)
		{
			copy(bx,by-1);
			minx=bx;
			miny=by-1;
			gg = getHash();
			hf.put(gg,"0");
		}
		else if(by+1<=2 && f==f4)
		{
			copy(bx,by+1);
			minx=bx;
			miny=by+1;
			gg = getHash();
			hf.put(gg,"0");
		}
		
		tar[bx][by]=tar[minx][miny];
		tar[minx][miny]="_";
		bx=minx;
		by=miny;
		
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.print(tar[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	void copy(int dx,int dy)
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				dum[i][j]=tar[i][j];
			}
		}
		dum[bx][by]=tar[dx][dy];
		dum[dx][dy]=tar[bx][by];
	}
	
	String getHash()
	{
		String h="";
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				h+=dum[i][j];
			}
		}
		return h;
	}
	
	int gethf()
	{
		int hh=0;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(!goal[i][j].equals(dum[i][j]))
					hh++;
			}
		}
		return hh+g;
	}
}
