// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		for (int i = 0; i < x2; i++) {
			x1++;
		}	
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		for (int i = 0; i < x2; i++) {
			x1--;
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int product = 0;
		if (x2 == 0 || x1 == 0) {
			return product;
		} else {
			for (int i = 0; i < x2; i++) {
				product = plus(product, x1);
			}
		}
		return product;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		// pow is messed up
		int result = 1;
		if (n == 0) {
			return result;
		} else {
			for (int i = 1; i <= n; i++) {
				result = times(result, x);
			}
		}
		return result;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int count = 0; 
		if (x2 > x1) {
			return 0;
		} 
		int current = x1;
		while (current >= x2) {
			count++;
			current = minus(current, x2);
		}
		return count;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int floor = div(x1, x2);
		int exactDivisionFrom = times(floor, x2);
		return (minus(x1, exactDivisionFrom));
	}	
	
	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		// see 3-1 4th slide;
		// go brute force, no need for algorithm; assume that 
		// the int fits to a sqrt.
		// no need, can just go one by one, and then whenever i reach result,
		// i can just choose the lower option.

		// or go bisect
		// sqrt is messed up it thinks it's always 1
		// now its stuck - just copy the idea either of raphson newton,
		// or just a long brute force option that just remembers the 
		// two last values, and if last value is wrong - take one afterwards.
		// there is no prohibition from using casting, so i'm okay with using casting
		// to make it more similar to the sqrt they have in the slide. 
		// but then i will have problems with using the int ---
		
		
		// might need to go for some half measure
		// <<..go brute, and if == then good;
		// <<..if not ==, then go result-- and return;
		int g = 1;
		boolean controlWhile = true;
		while (g <= x && controlWhile) {
			g = plus(g, 1);
			if (times(g, g) > x) {
				break;
			}
		}
		if (g > x) {
			System.out.println("Decrease increment");
		}
		if (times(g, g) > x) {
			g = minus(g, 1);
			//System.out.println("returned inside if statement");
			return g;
		}
		//System.out.println("printed outside if statement");
		return g;
	}	  	  
}