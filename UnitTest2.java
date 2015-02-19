
public class UnitTest2 {
public static void main(String[] args) {
		
		MatrixCalculator A = new MatrixCalculator();	//Object of MatrixCalculator class
		A.readfromfile();
		int index = A.addition(0,1);			//addition function saves the index value where my sum is stored
		A.addition(index,3);					//add previous sum with another matrix
		
		
		
	}
}
