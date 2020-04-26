class InsertionSort
{
	public static int[] sort(int[] arr)
	{
		for (int i=1;i<arr.length;i++)
		{
			for(int j=0;j<i;j++)
			{	
				if(arr[i]<arr[j])
				{
					int temp=arr[j];
					arr[j]=arr[i];
					arr[i]=temp;
				}
			}
			
			
		}
		return arr;
	}

}