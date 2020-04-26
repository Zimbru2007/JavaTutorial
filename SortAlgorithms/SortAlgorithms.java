import java.util.Random; 
public class SortAlgorithms{
	 public static int[] newRandomArray(int nrElements){
	    Random rand  = new Random(); //create object of Random class to generate random numbers
	    int randNum =0; // random number 
        int randSign=0; // random sign 1, negative 0, positive
		int[] arr = new int [nrElements] ; //create array with nr elements = nrElements
		for(int i=0; i<arr.length;i++){ // for loop to fill array with elements
			randSign= rand.nextInt(2);
			randNum = rand.nextInt(20);  // get random int between 0 and 19 
			
			
			if(randSign == 1){ // if randSign==1 set the number to a negative value
				randNum *= -1; // randNum = randNum*-1
			}
			arr[i] = randNum;
		}
		return arr;		
   }
	public static void print(int[] arr, String message)
	{
		System.out.println("\n"+message+" \n");
		System.out.print("[");
		for(int elem:arr)
		{
			System.out.print(elem+" ");
		}
		System.out.print("]\n");
	}
	public static void main (String[] args)
	{
		int[] sampleArray;
		
		sampleArray = newRandomArray(15);
		print(sampleArray,"Initial Array:");
		print(SelectionSort.sort(sampleArray),"Selection Sort:");
		System.out.println("----------------------------------------------------");
		
		sampleArray = newRandomArray(15);
		print(sampleArray,"Initial Array:");
		print(BubbleSort.sort(sampleArray),"Bubble Sort:");
		System.out.println("----------------------------------------------------");
		
		sampleArray = newRandomArray(15);
		print(sampleArray,"Initial Array:");
		print(RecursiveBubbleSort.sort(sampleArray),"Recursive Bubble Sort:");
		System.out.println("----------------------------------------------------");
		
		sampleArray = newRandomArray(15);
		print(sampleArray,"Initial Array:");
		print(InsertionSort.sort(sampleArray),"Insertion Sort:");
		System.out.println("----------------------------------------------------");
		
		sampleArray = newRandomArray(15);
		print(sampleArray,"Initial Array:");
		print(RecursiveInsertionSort.sort(sampleArray),"Recursive Insertion Sort:");
		System.out.println("----------------------------------------------------");
		
		sampleArray = newRandomArray(15);
		print(sampleArray,"Initial Array:");
		print(MergeSort.sort(sampleArray),"Merge Sort:");
		System.out.println("----------------------------------------------------");
	}
}