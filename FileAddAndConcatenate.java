import java.io.*;
public class FileAddAndConcatenate
{
	public static void main (String[] args) throws FileNotFoundException, IOException
	{
		String string_concat="";
		int cifre_adunate=0;
		if (args.length==0) //Verificam daca nu sunt parametri de intrare
		{
			System.out.println("Please run the program with filename parameter!");
			System.exit(1); //Exit program
		}
		else
		{
			File file = new File(args[0]); 
			if(file.exists()) //Check if file exists
			{
				BufferedReader br = new BufferedReader(new FileReader(file)); 
				String st; 
				
				while ((st = br.readLine()) != null) //read line by line of the file
				{		
					char[] a=st.toCharArray(); //Convert string to array of chars
					for(char c:a){
						/*if (Character.isLetter(c))
						{
							string_concat=string_concat.concat(Character.valueOf(c).toString());
						}
						else*/ if (Character.isDigit(c))
						{
							cifre_adunate+=Integer.parseInt(Character.valueOf(c).toString());
						}
						else 
						{
							string_concat=string_concat.concat(Character.valueOf(c).toString());
						}
					}			
					//System.out.println(st); 
				} 
				System.out.println("Textul fara cifre este : "+string_concat);
				System.out.println("Suma cifrelor este : "+cifre_adunate);
			}
			else
			{
				System.out.println("File doesn't exist!");
				System.exit(1); //Exit program
			}
		}
	}
}