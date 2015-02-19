import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;


public class MatrixCalculator {
	static int numberofrows=0;											//This variable is used to save a number of rows of a matrix
	static int numberofcols=0;											//This variable is used to save a number of columns of a matrix
	static ArrayList<int[][]> listmatrix = new ArrayList<int[][]>();	//2D ArrayList to store matrices. One 2D array on one index of ArrayList
	static ArrayList rows = new ArrayList();							//ArrayList to store number of rows of a matrix. 
	static ArrayList cols = new ArrayList();							//ArrayList to store number of columns of a matrix. 
	//Matrix placed in index 0 of 'listmatrix' list has its rows and columns placed in index 0 of 'rows' list and index 0 of 'cols' list respectively
	
	
	public static void readfromfile() {									//This function reads matrices from file and tokenize them
	
		BufferedReader reader = null;
		try {
			  
			String line;												//This variable will help in reading lines one by one
			reader = new BufferedReader(new FileReader("D:\\SampleFile.txt"));		//Path of my file
				 	
			System.out.println("Matrix Calculator: \n");
			while ((line = reader.readLine()) != null) {
				int array[][] = new int[50][50];						//2D array saves the matrices placed in our file one by one						
				StringTokenizer st = new StringTokenizer(line, "\n");	//Separating matrices on the bases of a new line
				numberofrows=0;	
				System.out.println("Reading from a file");
				while (st.hasMoreElements()) {	 //This loop prints lines one by one and finishes when there is no more elements present
					System.out.println("Matrix: " + st.nextElement());
					System.out.println();
				}
				
				String[] row = line.split(";");							//Separating rows of a matrix on the basis of ";"
				int length = row.length;								//Taking length of each row
				for (int j=0; j < length; j++) {						//This loop runs until elements of each row are separated
					   numberofcols=0;
					   String[] sep = row[j].split(" ");				//Separates the row elements on the bases of " " (space)
			    	   int length1 = sep.length;						//Taking length of each element one by one
			    	   for (int i=0; i < length1; i++) {				
			    	  		array[numberofrows][i]=Integer.parseInt(sep[i]); 
			    	  		//Converts string element to integer element and store in 2D array
			    	  		numberofcols++;
			    	     	  
			   	    	}			    	  	
			    	  	numberofrows++;	
			    }			
			 			  
			  listmatrix.add(array);			//Adding 2D array to a ArrayList one by one
			  rows.add(numberofrows);			//Adding number of rows of a matrix in rows list
			  cols.add(numberofcols);			//Adding number of rows of a matrix in rows list
			}
					
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public static int addition(int index1, int index2) {
		
		 int arr[][] = listmatrix.get(index1);				//Getting matrix placed in index1 of arrayList
		 int numofRows = (int) rows.get(index1);			//Getting number of rows of above matrix
		 int numofCols = (int) cols.get(index1);			//Getting number of columns of above matrix
		 int orderMat1 = numofRows * numofCols;				//Calculating order for checking condition of adding two matrices
		 System.out.println();
		 System.out.println("Matrix : " + index1);
		 for (int i = 0 ; i <numofRows ; i++) {				//Display matrix
		         for (int j = 0 ; j < numofCols ; j++) {
		        	 System.out.print(arr[i][j]);
		  				System.out.print("\t");
		  				
		         }
		         	System.out.println();
		}
		
		  int arr1[][] = listmatrix.get(index2);			//Getting matrix placed in index2 of arrayList
		  int numofRows1 = (int) rows.get(index2);			//Getting number of rows of above matrix
		  int numofCols1 = (int) cols.get(index2);			//Getting number of columns of above matrix
		  int orderMat2 = numofRows1 * numofCols1;			//Calculating order for checking condition of adding two matrices
		  System.out.println();
		  System.out.println("Matrix : " + index2);
		  for (int i = 0 ; i <numofRows1 ; i++) {			//Display matrix
			       for (int j = 0 ; j < numofCols1 ; j++) {	
			        	 System.	out.print(arr1[i][j]);
			  				System.out.print("\t");
			  				
			         }
			         	System.out.println();
			}
		
		
			 
		    System.out.println();
			if(orderMat1 == orderMat2) {			//Add two matrices if their order is same
				int sum[][] = new int[numofRows][numofCols];		//2D sum array to store sum of matrices
				
				for (int a = 0 ; a < numofRows ; a++ )
			         for (int b = 0 ; b < numofCols ; b++ )
			             sum[a][b] = arr[a][b] + arr1[a][b];  		//Addition of two matrices
					
				 int myindex = 4;
				 rows.add(myindex,numofRows);
				 cols.add(myindex,numofCols);
				 listmatrix.add(myindex, sum);						//Adding sum to Arraylist for unit test to add 3 matrices
				 						
			      System.out.println("Sum of entered matrices:-");
			 
			      for (int i = 0 ; i < numofRows ; i++ ) {
			         for (int j = 0 ; j < numofCols ; j++ )
			            System.out.print(sum[i][j]+"\t");
			 
			         System.out.println();
			        
			      }
			      System.out.println();
			     return myindex;
			   //return myindex value to use it for performing any function on a matrix placed in this index and any other
			    
			}
			else			//No addition if order is not same
				System.out.println("Order of matrices is not same. No addition allowed!!");
			
				return index1;
					 
			
			
		
	}
	
	
	public static void subtraction(int index1, int index2) {
		
		
		 int arr[][] = listmatrix.get(index1);			//Getting matrix placed in index1 of arrayList
		 int numofRows = (int) rows.get(index1);		//Getting number of rows of above matrix
		 int numofCols = (int) cols.get(index1);		//Getting number of columns of above matrix
		 int orderMat1 = numofRows * numofCols;			//Calculating order for checking condition of adding two matrices
		 System.out.println();
		 System.out.println("Matrix : " + index1);
		  for (int i = 0 ; i <numofRows ; i++) {
		         for (int j = 0 ; j < numofCols ; j++) {
		        	 System.out.print(arr[i][j]);
		  				System.out.print("\t");
		  				
		         }
		         	System.out.println();
		}
		
		     int arr1[][] = listmatrix.get(index2);		//Getting matrix placed in index2 of arrayList
			 int numofRows1 = (int) rows.get(index2);	//Getting number of rows of above matrix
			 int numofCols1 = (int) cols.get(index2);	//Getting number of columns of above matrix
			 int orderMat2 = numofRows1 * numofCols1;	//Calculating order for checking condition of adding two matrices
			 System.out.println();
			 System.out.println("Matrix : " + index2);
			  for (int i = 0 ; i <numofRows1 ; i++) {
			         for (int j = 0 ; j < numofCols1 ; j++) {
			        	 System.out.print(arr1[i][j]);
			  				System.out.print("\t");
			  				
			         }
			         	System.out.println();
			}
		
			  
			if(orderMat1 == orderMat2) {		//Subtract two matrices if their order is same
				int sub[][] = new int[numofRows][numofCols];
				int c,d;
				for ( c = 0 ; c < numofRows ; c++ )
			         for ( d = 0 ; d < numofCols ; d++ )
			             sub[c][d] = arr[c][d] - arr1[c][d];  
			 
			      System.out.println("Subtractions of entered matrices:-");
			 
			      for (int i = 0 ; i < numofRows ; i++ ) {
			         for ( int j = 0 ; j < numofCols ; j++ )
			            System.out.print(sub[i][j]+"\t");
			 
			         System.out.println();
			      }
				
			      System.out.println();
			}
			else
				System.out.println("Order of matrices is not same. No addition allowed!!");
		
	}

	public static int multiplication(int index1, int index2) {
		
		
		 int arr[][] = listmatrix.get(index1);
		 int numofRows = (int) rows.get(index1);
		 int numofCols = (int) cols.get(index1);
		 System.out.println();
		  System.out.println("Matrix : " + index1);
		  for (int i = 0 ; i <numofRows ; i++) {
		         for (int j = 0 ; j < numofCols ; j++) {
		        	 System.out.print(arr[i][j]);
		  				System.out.print("\t");
		  				
		         }
		         	System.out.println();
		}
		
		     int arr1[][] = listmatrix.get(index2);
			 int numofRows1 = (int) rows.get(index2);
			 int numofCols1 = (int) cols.get(index2);
			 System.out.println();
			 System.out.println("Matrix : " + index2);
			  for (int i = 0 ; i <numofRows1 ; i++) {
			         for (int j = 0 ; j < numofCols1 ; j++) {
			        	 System.out.print(arr1[i][j]);
			  				System.out.print("\t");
			  				
			         }
			         	System.out.println();
			}
		
		
			 
			  
			if(numofCols1 == numofRows) {		//Multiply matrices if number of columns of matrix 1 are equal to number of rows of matrix 2
				int sum=0;
				int multiply[][] = new int[numofRows][numofCols1];	
				int c,d,k;
				 for (c = 0 ; c < numofRows ; c++){
		            for (d = 0 ; d < numofCols1; d++){   
		               for (k = 0 ; k < numofRows1 ; k++){
		                  sum = sum + arr[c][k]*arr1[k][d];
		               }
		 
		               multiply[c][d] = sum;
		               sum = 0;
		            }
		         }
				 
				 int myindex = 4;
				 rows.add(myindex,numofRows);
				 cols.add(myindex,numofCols);
				 listmatrix.add(myindex,multiply);				//Adding multiply result in listmatrix for unit test
			     System.out.println(); 
				 System.out.println("Product of entered matrices:-");
			 
			      for (c = 0 ; c < numofRows ; c++) {
			            for (d = 0 ; d < numofCols1 ; d++)
			               System.out.print(multiply[c][d]+"\t");
			 
			            System.out.print("\n");
			         }
			      System.out.println();
				return myindex;	
				//return myindex value to use it for performing any function on a matrix placed in this index and any other
			}
			else
				System.out.println("Columns of matrix 1 are not equal to rows of matrix 2. No multiplication allowed!!");
		return index1;
	}
	

}
