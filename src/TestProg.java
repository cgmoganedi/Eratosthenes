import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TestProg {
	
	static ListOfPrimes N;
	
	static Scanner in;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException
	{
		// first check to see if the program was run with the command line argument
	    if(args.length < 1) {
	        System.out.println("Error, usage: java ClassName inputfile");
			System.exit(1);
	    }
	    
	    long X = 0; // input parameter whose primes are required
	    ArrayList<Long> primes = new ArrayList<Long>();
	   
		in = new Scanner(new FileInputStream(args[0]));

		while(in.hasNextLong())
		{
			X = in.nextLong();
			N = new ListOfPrimes(X); // N is an output object that holds all primes less than or equal to X
		
			primes = N.fetchPrimes();
			outputWriter(primes, "C:/Users/716705/Documents/GitHub/Eratosthenes/src/outputs/" + X);
		}
		

	}
	
	public static void outputWriter(ArrayList<Long> primes, String path)
	{
		try
		{
			out = new PrintWriter(new FileWriter(path));
			for(long a:primes)
				out.println(a);
			out.close();
			System.out.println("Successfully done!");
		}
		
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
