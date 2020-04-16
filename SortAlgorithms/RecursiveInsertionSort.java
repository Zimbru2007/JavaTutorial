class RecursiveInsertionSort
{
	public static int[] sort(int[] arr)
	{
		insertionSort(arr,arr.length);
		return arr;
	}
	static void insertionSort(int[] arr, int n)
	{
		if (n<=1)
		{
			return;
		}
		insertionSort(arr,n-1);
		int temp0=n-1;
		for (int i=n-2;i>=0;i--)
		{
			if(arr[temp0]<arr[i])
			{
				int temp=arr[temp0];
				arr[temp0]=arr[i];
				arr[i]=temp;
				temp0=i;
			}
		}
		
	}

}