
public class UnitTest {

	public static void main(String[] args) {
		
		MatrixCalculator A = new MatrixCalculator();	//Object of MatrixCalculator class
		A.readfromfile();
		A.multiplication(0, 1);					//Multiply two matrices (Unit test: 1)
		
		int index = A.addition(0,1);			//addition function saves the index value where my sum is stored
		A.addition(index,3);					//add previous sum with another matrix
		
		
		int index1 = A.multiplication(1, 2);	//multiplication function saves the index value where answer is stored
		A.addition(index1,0);			//Add matrix placed in index1 with another matrix	
		
	}

}
