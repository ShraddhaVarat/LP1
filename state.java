class state
{
	int arr[];
	state parent;
	int h=0;
	
	state(state s)
	{
		this.arr=new int[9];
		for(int i=0;i<9;i++)
			this.arr[i]=s.arr[i];
	}

	state()
	{
		this.arr=new int[9];
	}
}
