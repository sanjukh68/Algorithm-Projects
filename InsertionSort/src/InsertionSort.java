import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * InsertionSort Program reads the input data, preferably any number(integer,float,double etc..) from file through command line argument.
 * Sorts the data and stores the result into answer.txt.
 * Delimiter should be ";"
 * 
 * @author Sanju Kurubara Budi Hall Hiriyanna Gowda
 * @since 08-27-2016
 */
public class InsertionSort {

	public InsertionSort() {
	}

	public static void main(String[] args) 
	{
		if(args.length == 0)
		{
			System.out.println("Please enter InputFile name");
			System.out.println("Usage: java (FileName) (Input File)");
			return;
		}
		else if(args.length > 1)
		{
			System.out.println("Please enter only 1 argument");
			return;
		}
		else
		{
			ArrayList<String> list = null;
			BufferedReader reader = null;

			try {
				//reading contents from input.txt and storing it in ArrayList
				String text = null;
				String inputFile = args[0];
				reader = new BufferedReader(new FileReader(inputFile));
				list = new ArrayList<String>();
				
				while ((text = reader.readLine()) != null) 
				{
					String[] resultingTokens = text.split(";");
					for (int i = 0; i < resultingTokens.length; i++)
					{
						list.add(resultingTokens[i].trim());
					}
				}

				//Insertion Sort
				for (int i=1; i< list.size(); i++)
				{
					String key = list.get(i);
					int j;
					//Using ParseDouble to make sure all the numbers are sorted
					for (j = i - 1; j >= 0 && (Double.parseDouble(list.get(j)) >  Double.parseDouble(key)) ; j--)
					{
						list.set(j+1, list.get(j));
					}
					list.set(j+1, key);
				}

				//Print sorted data into answer.txt file
				PrintWriter writer = new PrintWriter("answer.txt", "UTF-8");
				for (int i=0; i< list.size(); i++)
				{
					writer.print(list.get(i));
					if(i != list.size() - 1)
					{
						writer.print("; ");
					}		    	
				}
				writer.close();
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			} 
			finally 
			{
				try 
				{
					if (reader != null) 
					{
						reader.close();
					}
				} 
				catch (IOException e) 
				{
				}
			}
		}
	}

}
