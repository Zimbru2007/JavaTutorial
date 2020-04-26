import java.util.Arrays;

public class WorkArrays
{
	public static double roundDouble(double value, int digits)
	{
		return Math.round(value*Math.pow(10,digits))/Double.valueOf(Math.pow(10,digits));
	}
	public static void main (String[] args)
	{
		double[] work_array = {6.8,7.9,-1.8,5.7,4.0,6,80.06};
		double min=work_array[0];
		double max=work_array[0];
		double average=0;
		double sum=0;
		double temp;
		
		Arrays.sort(work_array); //sorting Arrays
		/*for (int i=0;i<work_array.length;i++)
		{
			for(int j=i+1;j<work_array.length;j++)
			{
				if(work_array[i]>work_array[j])
				{
					temp=work_array[i];
					work_array[i]=work_array[j];
					work_array[j]=temp;
				}
			}
		}*/
		
		for(double element:work_array)
		{
			System.out.println(element);
		}
		for(double element:work_array)
		{
			sum+=element;
			if (min > element) 
			{
				min=element;
			}
			if(max < element)
			{
				max=element;
			}
			
		}
		
		average=sum/work_array.length;
		int a=9/2;
			System.out.println("SUM="+sum+" AVG="+average+" "+roundDouble(-50.455564746,3)+" MAX="+max+" MIN=" +min+ " "+ a);
	}
}
