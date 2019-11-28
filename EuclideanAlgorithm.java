import java.math.BigInteger;

/**
 * 
 */

/**
 * @author Ananta Bhatt
 *
 */
public class EuclideanAlgorithm {
public static BigInteger p =new BigInteger("78511"); 
public static BigInteger q =new BigInteger("5657");
public static BigInteger a =new BigInteger("3449");
static BigInteger ONE=new BigInteger("1");
public static BigInteger n = p.multiply(q);
private static BigInteger ZERO = BigInteger.ZERO;
public static BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
public static BigInteger x =new BigInteger("54321");
	public static void main(String arg[])
	{
		//1. Calculate the ModInverse to get b value
		//System.out.println("phi: "+phi);
		BigInteger b=modInverse(a,phi);
		System.out.println("b value is: "+b);
		
		int intBvalue= b.intValue();
		//String temp = Integer.toString(intBvalue);
		//System.out.println(temp.charAt(1));
		
		//2.Convert to b in binary form
	    	String binaryvalue=bitsConversion(intBvalue);
	    	
	    	//System.out.println(binaryvalue);
	    	
	    	//3.Call suqare_multiply function
	    	BigInteger en=square_multiply(binaryvalue);
	    	System.out.println("Encryption of the Message: "+en);
	    	
	    	//4. For Decryption: convert a in binary form
	    	String binary_value=bitsConversion(a.intValue());
	    	
	    	//System.out.println(binary_value);
	    	
	    	//5. Call the decryption  function
	    	BigInteger decryption=decryption(binary_value,en);
	    	System.out.println("Decrytion Value: "+decryption);
	}
    //Converting decimal to binary
    public static String bitsConversion(int n)
    {
    	String x = ""; int a, count=0;
    	while(n > 0)
        {
            a = n % 2;
            if(a == 1)
            {
                count++;
            }
            x = x + "" + a;
            n = n / 2;
        }
    	return x;
    	     }
    	  
    //Implementing square and multiply methodology
	public static BigInteger square_multiply(String temp)
	{
		//Setting z=1
		BigInteger z=new BigInteger("1");
		//for i=l-1 to 0
		for(int i=temp.length()-1;i>=0;i--)
		{
			//Performing for each value: z=z*z mod n
			z=(z.multiply(z)).mod(n);
			//If the char is 1, z= z*x mod n
			if(temp.charAt(i)== '1')
			{
				z=(z.multiply(x)).mod(n);
			}
		}
		
		return z;
		
	}
	//Computing the decrypted value
public static BigInteger decryption(String dec, BigInteger y)
{
	//Setting z=1	
	BigInteger z=new BigInteger("1");
	//for i=l-1 to 0
	for(int i=dec.length()-1;i>=0;i--)
	{
		//Performing for each value: z=z*z mod n
		z=(z.multiply(z)).mod(n);
		//If the char is 1, z= z*x mod n
		if(dec.charAt(i)=='1')
		{
			z=(z.multiply(y)).mod(n);
		}
	}
	
	return z;

}
 //Calculating modInverse to find b 
	public static BigInteger modInverse(BigInteger a, BigInteger n){
		BigInteger n0 = n;
		BigInteger a0 = a;
		BigInteger t0 = ZERO;
		BigInteger t  = ONE;
		//Compute q=n0/a0
		BigInteger q  = n0.divide(a0);
		//Compute r=n0 - q *a0
		BigInteger r  = n0.subtract(q.multiply(a0));
		BigInteger temp;
		
		while (r.compareTo(ZERO) == 1) {   //r>0
			//Computer temp=t0- q * t mod n
			temp = (t0.subtract(q.multiply(t))).mod(n);
							
			t0 = t;
			t  = temp;
			n0 = a0;
			a0 = r;
			//Compute q=n0/a0
			q  = n0.divide(a0);
			//Compute r=n0-q*b0
			r  = n0.subtract(q.multiply(a0));
		}
		
		if (a0.compareTo(ONE) != 0)	throw new ArithmeticException();//for a0!=1
		return t.mod(n);
	}
	
	}


