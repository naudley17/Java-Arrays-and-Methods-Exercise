import java.util.*;

public class Utilities {
	public static void splitArray(int[] a) {
		Scanner sc = new Scanner(System.in);
		int[] ar = new int[5]; // Change n in int[n] to change array size, current size: 5
		
		// Finding the highest and second highest numbers, starting from index 0
		int highestInteger = ar[0];
		int secondhighestInteger = ar[0];
		
		// Storing the parts of the highest number when split
		int numberToGet = 0, numberPartOne = 0, numberPartTwo = 0;
		
		// User inputs n number of integers
		for(int i = 0; i < ar.length; i++) {
			System.out.println("Input an integer: ");
			ar[i] = sc.nextInt();
		}
		
		// Loop to find the highest integer
		for(int i = 0; i < ar.length; i++) {
			if(ar[i] > highestInteger) {
				highestInteger = ar[i];
				numberToGet = ar[i];
			}
		}
		
		// Loop to find the second highest integer
		for(int i = 0; i < ar.length; i++ ) {
			if(ar[i] > secondhighestInteger  && ar[i] < highestInteger) {
				secondhighestInteger = ar[i];
				numberPartOne = ar[i];
			}
		}
		
		// Subtract second highest integer from highest integer
		numberPartTwo = numberToGet - numberPartOne;
		
		// Print array
		// P.S.: I don't know how to remove element from array so I just print it all
		for(int i = 0; i < ar.length; i ++) {
			System.out.printf(ar[i] + " ");
		}
		System.out.printf(Integer.toString(numberPartOne));
		System.out.printf(" " + Integer.toString(numberPartTwo));
	}
	
    public static void rotateArray(int[] a, int rotateBy) {
        int[] ar = new int[a.length];
        
        // ROT can be changed in directly in the driver class
        int rotate = rotateBy % a.length;
        for(int i = 0; i < a.length; i++) {
            if(i < rotate) {
                ar[i] = a[a.length - 1 - (rotate - (i + 1))];
            }
            else {
                ar[i] = a[i - rotate];
            }
        }
        System.out.println(Arrays.toString(ar));
    }
    
    public static void symmetricalMatrix(int[][] a) {
        boolean Symmetrical = true;
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[i].length; j++) {
                if (a[j][i] != a[i][j]) { // Set boolean to false if not the same
                    Symmetrical = false;
                    break;
                }
            }
        }
        if(Symmetrical == true) {
        	System.out.println("Matrix is symmetrical.");
        }
        else {
        	System.out.println("Matrix is not symmetrical.");
        }
    }
    
 // Magic Square (Let row be i, and column be j)
 // Condition 1: Position of next number is i-1 and j+1 of the previous number's position
 // Condition 2: If is position is filled it the number is moved to i+1 and j-2 of the filled position
 // Condition 3: If the calculated position is (-1, n), that position is changed to (0, n-2)
    public static void magicSquare(int n) 
    { 
        int[][] magicSquare = new int[n][n]; 
          
        // Position of first number
        int i = n / 2; 
        int j = n - 1; 
   
        // Putting values into the magic square one by one.
        for (int value = 1; value <= n * n; ) { 
        	// Condition 3, see above
            if (i == -1 && j == n) { 
                j = n - 2; 
                i = 0; 
            } 
            else { 
                // Prevent the number from having an out of bounds j position.
                if (j == n) 
                    j = 0; 
                      
                // Prevent the number from having an out of bounds i position.
                if (i < 0) 
                    i= n - 1; 
            } 
              
            // Condition 2, see above
            if (magicSquare[i][j] != 0) { 
                j -= 2; 
                i++; 
                continue; 
            } 
            else {
                magicSquare[i][j] = value++;  
                  
            // Condition 1, see above
            j++;  i--;  
            }
        } 
   
        System.out.println("The Magic Square for size " + n + "x" + n + ": "); 
        for(i = 0; i < n; i++) { 
            for(j = 0; j < n; j++) 
                System.out.print(magicSquare[i][j]+" "); 
            System.out.println(); 
        }
        System.out.println("Sum of each row/column: " + (n * (n * n + 1) / 2)); 
    }  
}