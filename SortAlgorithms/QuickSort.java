class QuickSort
{
	public static int[] sort(int[] arr)
	{
		quickSort(arr,0,arr.length-1);
		return arr;
	}
	static void quickSort(int[] arr, int l, int r)
	{
		if (l>=r)
		{
			return;
		}
		
		int p=findPivot(arr,l,r);
		quickSort(arr,l,p-1);
		quickSort(arr,p+1,r);
		
	}
	static int findPivot(int[] arr, int l, int r)
	{
		int p=arr[r];
		int j = l-1;
		for(int i=l;i<r;i++)
		{
			if(arr[i]<p)
			{
				j++;
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		int temp=arr[j+1];
		arr[j+1]=arr[r];
		arr[r]=temp;
		return j+1;
	}

}