class BubbleSort
{
	public static int[] sort(int[] arr)
	{
		for (int i=0;i<arr.length;i++)
		{
			for(int j=i;j<arr.length;j++)
			{	
				if(arr[i]>arr[j])
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