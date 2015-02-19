
public class UnitTest3 {

public static void main(String[] args) {
		
		MatrixCalculator A = new MatrixCalculator();	//Object of MatrixCalculator class
		A.readfromfile();
			
		int index1 = A.multiplication(1, 2);	//multiplication function saves the index value where answer is stored
		A.addition(index1,0);			//Add matrix placed in index1 with another matrix	
		
	}
}
