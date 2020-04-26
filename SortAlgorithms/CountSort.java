public class CountSort
{
	public static int[] sort(int[] arr)
	{
		int min=arr[0];
		int max=arr[0];
		
		for (int i=0;i<arr.length;i++)
		{
			if(arr[i]<min)
			{
				min=arr[i];
			}
			else if (arr[i]>max)
			{
				max=arr[i];
			}
			
		}
		int range=max-min+1;
		
		int[] temparr=new int[range];
		
		for (int i=0;i<arr.length;i++)
		{
			temparr[arr[i]-min]++;
		}
		int k=0;
		for (int i=0;i<temparr.length;i++)
		{
			for(int j=0;j<temparr[i];j++)
			{
				arr[k]=i+min;
				k++;
			}
		}
		
		return arr;
	}
}