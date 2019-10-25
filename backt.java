import java.util.*;

public class backt
{
	public static void main(String args[])
	{
		backt q=new backt();
		q.solve();
	}
	
	void solve()
	{
		int board[][]=new int[4][4];
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				board[i][j]=0;
			}
		}
		
		if(solveUtil(board,0) == false)
			System.out.println("no sol");
		else
			printb(board);	
		
	}
	
	void printb(int board[][])
	{
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	boolean solveUtil(int board[][],int col)
	{
		if(col>=4)
			return true;
			
		for(int row=0;row<4;row++)
		{
			if(isSafe(board,row,col))
			{
				board[row][col]=1;
				if(solveUtil(board,col+1)==true)
					return true;
				board[row][col]=0;
			}		
		}
		return false; //no place in col
	}
	
	boolean isSafe(int board[][],int row,int col)
	{
		for(int i=0;i<col;i++) //left 
		{
			if(board[row][i]==1)
				return false;
		}
		
		for(int i=row,j=col;i>=0 && j>=0;i--,j--) //upper left
		{
			if(board[i][j]==1)
				return false;
		}
		
		for(int i=row,j=col;i<=3 && j>=0;i++,j--) //upper left
		{
			if(board[i][j]==1)
				return false;
		}
		return true;
	}
}
