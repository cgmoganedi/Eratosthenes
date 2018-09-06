import java.util.ArrayList;

public class ListOfPrimes {

	private ArrayList<Boolean> primality; // used to indicate whether a number was considered prime or not
	private long X; // the upper bound of the primes
	
	ListOfPrimes(long X)
	{
		this.X = X;
		this.primality = new ArrayList<Boolean>();
		SieveOfEratosthenes();
	}
	
	private void SieveOfEratosthenes() 
	{
		for(long k = 0; k <= X; ++k)
		{
			primality.add(true);
		}
		primality.set(0, false);
		primality.set(1, false);
		
		for(int i = 2; i <= Math.sqrt(X); ++i)
		{
			if(primality.get(i))
			{
				for(int j = 2; i*j <= X ; ++j)
				{
					primality.set(i*j, false);
				}
			}
		}
	}
	
	public ArrayList<Long> fetchPrimes()
	{
		ArrayList<Long> primes = new ArrayList<Long>();;
		for(long k = 0; k < X; ++k)
		{
			if(primality.get((int)k))
				primes.add(k);
		}
		return primes;
	}

}
