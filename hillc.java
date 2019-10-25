import java.io.*;
import java.util.*;

public class hillc
{
	state gstate, cstate;
	ArrayList<state> ngb =new ArrayList<state>();
	Scanner sc=new Scanner(System.in);
	
	hillc()
	{
		gstate=new state();
		cstate=new state();
	}
	
	public static void main(String args[])
	{
		hillc h=new hillc();
		h.input();
		h.hc();
	}
	
	void input()
	{
		System.out.println("enter curr state");
		for(int i=0;i<9;i++)
		{
			cstate.arr[i]=sc.nextInt();
		}
		
		System.out.println("enter goal state");
		for(int i=0;i<9;i++)
		{
			gstate.arr[i]=sc.nextInt();
		}
	}
	
	void display(state s) {
		int k = 0;
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 3; i++) {
				System.out.print(" " + s.arr[k]);
				k++;
			}
			System.out.println();
		}
		System.out.println();
	}
	
	int h(state s)
	{
		int hv=0;
		for(int i=0;i<9;i++)
		{
			if(s.arr[i]!=gstate.arr[i])
				hv++;
		}
		return hv;
	}
	
	int blpos(state s)
	{
		for(int i=0;i<9;i++)
		{
			if(s.arr[i]==0)
				return i;
		}
		return 0;
	}
	
	void move(state s)
	{
		int p=blpos(s);
		ngb.clear();
		
		if(p%3!=0)
		{
			state n1=new state(s);
			n1.arr[p]=n1.arr[p-1];
			n1.arr[p-1]=0;
			
			n1.h=h(n1);
			ngb.add(n1);
		}
		if( p>2 && p<9)
		{
			state n1=new state(s);
			n1.arr[p]=n1.arr[p-3];
			n1.arr[p-3]=0;
			
			n1.h=h(n1);
			ngb.add(n1);
		}
		if(p%3!=2)
		{
			state n1=new state(s);
			n1.arr[p]=n1.arr[p+1];
			n1.arr[p+1]=0;
			
			n1.h=h(n1);
			ngb.add(n1);
		}
		if(p<6)
		{
			state n1=new state(s);
			n1.arr[p]=n1.arr[p+3];
			n1.arr[p+3]=0;
			
			n1.h=h(n1);
			ngb.add(n1);
		}
		
	}
	
	int lowest()
	{
		int min=999,index=0;
		for(int i=0;i<ngb.size();i++)
		{
			if(ngb.get(i).h < min)
			{
				min=ngb.get(i).h;
				index=i;
			}
		}
		return index;
	}
	
	state hc()
	{
		cstate.h=h(cstate);
		cstate.parent=null;
		
		state n=cstate;
		move(n);
		int low=lowest();
		state nn=ngb.get(low);
		
		display(n);
		
		while(nn.h<n.h)
		{
			display(nn);
			nn.parent=n;
			n=nn;
			move(n);
			low=lowest();
			nn=ngb.get(low);
		}
			
		return nn;	
	}
		
}
