class RecursiveBubbleSort
{
	public static int[] sort(int[] arr)
	{
		bubbleSort(arr,arr.length);
		return arr;
	}
	static void bubbleSort(int[] arr, int n)
	{
		if (n==1)
		{
			return;
		}
		for (int i=0;i<n-1;i++)
		{
			if(arr[i]>arr[i+1])
			{
				int temp=arr[i+1];
				arr[i+1]=arr[i];
				arr[i]=temp;
			}
		}
		bubbleSort(arr,n-1);
	}

}