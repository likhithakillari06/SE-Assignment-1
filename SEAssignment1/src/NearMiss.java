/* Title: Fermat's Last Theorem - Near Miss
 * Java File name: NearMiss
 * 
 * Programmers' Names: 
 * 1. Likhitha Killari - LikhithaKillari@lewisu.edu
 * 2. Sai Ram Reddy Tippireddy - 
 * 
 * Course: SP26-CPSC-60500-001
 * 
 * Date: February 15, 2026
 * 
 * The program takes two inputs from the user: k and n.
 * 
 *     - k represents the range of values to test (where k ≥ 10)
 *     - n represents the power (where n ≥ 3)
 *
 * To find all possible combinations of x and y, the program uses nested for-loops.
 *
 * Inside the nested loop:
 *
 *     - It first computes the value:
 *       - xⁿ + yⁿ
 *     - Then it estimates z by taking the nth root of the value:
 *       - z = (xⁿ + yⁿ)^(1/n)
 *
 * After finding z, the program calculates the near miss by checking how close the value xⁿ + yⁿ is to:
 *      - zⁿ
 *      - and (z + 1)ⁿ
 *
 * The near miss is calculated using the formula:
 *      - (xⁿ + yⁿ − zⁿ) and ((z + 1)ⁿ − (xⁿ + yⁿ))
 *
 * Next, the program computes the relative miss, which helps measure the miss size compared to the value.
 *
 * Finally, using if-else conditions, the program compares all misses found and stores the smallest near miss as the final result.
 * 
 */
import java.util.Scanner;
import java.lang.Math;

public class NearMiss {
	
	//Main Function

	public static void main(String[] args) 
	{ 
		long x=0;
	    long y = 0;
	    long z = 0;
	    long x1 = 0;
	    long y1 = 0;
	    //k data member for taking range from user
	    int k = 0;
	    //k data member for taking power from user
	    int n = 0;
	    
	    //user input scanner object
	    Scanner userinput = new Scanner(System.in);
	    
	    
	    //do while loop to make sure user enters valid input
	    do {
	    	System.out.println("Enter n, n>2 and n<12 = ");
		    n = userinput.nextInt();
	    }while(n<3 || n>11);
	    
	  //do while loop to make sure user enters valid input
	    do {
	    	System.out.println("Enter K, K>=10 = ");
		    k = userinput.nextInt();
	    }while(k<10);
	    
	    
	    double smallestmiss = 999999999999.99; 
	    
	    
	    //for loop will execute all the possible combinations of x and y
	    for (x = 10; x<=k; x++) 
	    {
	    	for (y = 10; y<=k; y++)
	    	{
	        	
	    		//getting results for x^n + y^n
	    		long xpowernplusypowern = (long)((Math.pow (x, n))+(Math.pow (y, n)));
	    		
	        
	    		//nth root according to equation of fermat theorem
	    		z = (int) Math.pow (xpowernplusypowern, 1.0/n);
	    		
	        
	    		//For z, Getting near miss by subtracting z^n from x^n + y^n
	    		long nearmissz = (long)(xpowernplusypowern - Math.pow (z, n));
	    		
	    		//For z+1, Getting near miss by subtracting (z+1)^n from x^n + y^n
	    		long nearmisszplusone = (long)(Math.pow (z+1, n) - xpowernplusypowern);
	        
	    		
	        
	    		long nearmiss = 0;
	    		//near miss, it can be from z or z+1
	    		if(nearmissz<nearmisszplusone)
	    		{
	    			nearmiss = nearmissz;
	    		}
	    		else
	    		{
	    			nearmiss = nearmisszplusone;
	    		}
	        
	    		//Applying relative miss formula according to given instructions
	    		double relativemiss = 1. * nearmiss / xpowernplusypowern;
	    		
	        
	        
	    		//smallest possible miss
	    		if(relativemiss<smallestmiss)
	    		{
	    			x1=x;
	    			y1=y;
	    			smallestmiss=relativemiss;
	    		}
	           
	        }
	    }
	    System.out.printf("x = %s%ny = %s%nRelative Difference = %.7f%n", x1, y1, smallestmiss);

	}
}


