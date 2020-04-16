class MergeSort
{
	public static int[] sort(int[] arr)
	{
		mergeSort(arr,0,arr.length-1);
		return arr;
	}
	static void mergeSort(int[] arr, int l, int r)
	{
		int m=(r+l)/2; //caluclate the middle index of curent array
		if (r<=l) // exit condition from iteration
		{
			return;
		}
		
		mergeSort(arr,l,m); //call recursively the method for the first part of array
		mergeSort(arr,m+1,r);//call recursively the method for the second part of array
		
		
		int n1=m-l+1, n2=r-m;
		
		int[] leftarr=new int[n1];
		int[] rightarr=new int[n2];
		
		for(int i=0;i<n1;i++)
		{
			leftarr[i]=arr[l+i];
		}
		for (int i=0;i<n2;i++)
		{
			rightarr[i]=arr[m+1+i];
		}
		int i=0,j=0;
		int k=l;
		while (i<n1 && j<n2)  //merge back sorted values
		{
			if(leftarr[i]<rightarr[j])
			{
				arr[k]=leftarr[i];
				i++;
			}
			else 
			{
				arr[k]=rightarr[j];
				j++;
			}
			k++;
		}
		while (i<n1) //leftovers are inserted
		{
			arr[k]=leftarr[i];
			i++;
			k++;
		}
		while (j<n2)
		{
			arr[k]=rightarr[j];
			j++;
			k++;
		}
	}

}