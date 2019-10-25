import java.util.*;

public class bb
{
	public static void main(String args[])
	{
		bb q=new bb();
		q.solve();
	}
	
	void solve()
	{
		int board[][]=new int[4][4];
		int slashCode[][]=new int[4][4];
		int backslashCode[][]=new int[4][4];
		
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				board[i][j]=0;
				slashCode[i][j]=i+j;
				backslashCode[i][j]=i-j+3;
			}
		}
		
		boolean sc[]=new boolean[2*4-1];
		boolean bsc[]=new boolean[2*4-1];
		boolean r[]=new boolean[4];
		
		if(solveUtil(board,0,slashCode,backslashCode,sc,bsc,r) == false)
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
	
	boolean solveUtil(int board[][],int col,int slashCode[][],int backslashCode[][],boolean sc[],boolean bsc[],boolean r[])
	{
		if(col>=4)
			return true;
			
		for(int row=0;row<4;row++)
		{
			if(isSafe(board,row,col,slashCode,backslashCode,sc,bsc,r))
			{
				board[row][col]=1;
				r[row]=true;
				sc[slashCode[row][col]]=true;
				bsc[backslashCode[row][col]]=true;
				if(solveUtil(board,col+1,slashCode,backslashCode,sc,bsc,r)==true)
					return true;
				board[row][col]=0;
				r[row]=false;
				sc[slashCode[row][col]]=false;
				bsc[backslashCode[row][col]]=false;
			}		
		}
		return false; //no place in col
	}
	
	boolean isSafe(int board[][],int row,int col,int slashCode[][],int backslashCode[][],boolean sc[],boolean bsc[],boolean r[])
	{
		if(r[row]==true || sc[slashCode[row][col]]==true || bsc[backslashCode[row][col]]==true)
			return false;
		return true;
	}
}
