class SelectionSort
{
	public static int[] sort(int[] arr)
	{
		for (int i=0;i<arr.length;i++)
		{
			int min_index=i;
			for(int j=i;j<arr.length;j++)
			{	
				if(arr[j]<arr[min_index])
				{
					min_index=j;
				}
			}
			int temp=arr[min_index];
			arr[min_index]=arr[i];
			arr[i]=temp;
			
		}
		return arr;
	}

}