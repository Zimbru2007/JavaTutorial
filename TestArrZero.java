import java.util.Random; 

public class TestArrZero{
  
  private int [] arr;
   
   public TestArrZero(int nrElements){
	    Random rand  = new Random(); //create object of Random class to generate random numbers
	    int randNum =0; // random number 
        int randSign=0; // random sign 1, negative 0, positive
		arr = new int [nrElements] ; //create array with nr elements = nrElements
		for(int i=0; i<this.arr.length;i++){ // for loop to fill array with elements
			randSign= rand.nextInt(2);
			while(true){ // if nextInt return 0, repeat the assignment
			   randNum = rand.nextInt(20);  // get random int between 0 and 19
			   if(randNum != 0){
				   break;
			   }
			}
			
			if(randSign == 1){ // if randSign==1 set the number to a negative value
				randNum *= -1; // randNum = randNum*-1
			}
			this.arr[i] = randNum;
		}  
   }
    
   public void printElements(){
	    System.out.print("[");
		for(int element:this.arr){
			System.out.print(element+" ");
		}
		 System.out.print("]\n");
	}
	
	public void printCloseZero(){
		 
		 int afish = 0;
		 int numAbs = 0;
		 
		if(arr != null && this.arr.length>0)
		{
		   afish =arr[0];
		   numAbs=Math.abs(arr[0]);
		}
		 
		for(int element:this.arr){
			if (Math.abs(element)<numAbs){
				numAbs = Math.abs(element);
				afish  = element;
			}
			else if(Math.abs(element) == numAbs){
				 if (afish < element){
					 afish = element;
				 }
			}
		}
		System.out.println("Closest to zero is "+afish);
	}
	
	public static void main(String [] args){
		TestArrZero myTz = new TestArrZero(Integer.valueOf(args[0])); // Create object of TestArrZero
		myTz.printElements();
		myTz.printCloseZero();
	}
}