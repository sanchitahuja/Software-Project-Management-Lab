import java.util.Scanner;

public class Q5_Basic_COCOMO {

	
	
	static double COCOMO[][] = {
			{2.4, 1.05, 2.5, 0.38},
			{3.0, 1.12, 2.5, 0.35},   
			{      3.6, 1.20, 2.5, 0.32} };
	public static void main(String args[]) {
		double loc;
		int type=0;
		double E,D;
		System.out.println("Enter number of lines in 1000s");
		Scanner scanner=new Scanner(System.in);
		loc=scanner.nextDouble();
		if(loc>50)
			type=1;
		if(loc>300)
			type=2;

		//E=a(KLOC)**b
		//D=c(E)**d
		//SS =E/D
		//P=KLOC/E
		 E = COCOMO[type][0] * Math.pow(loc, COCOMO[type][1]);    
		 D = COCOMO[type][2] * Math.pow(E, COCOMO[type][3]); 
		switch(type) {
		case 0:
			System.out.println("Organic");
			break;
		case 1:
			System.out.println("Semi-detached");
			break;
		case 2:
			System.out.println("Embedded");
			break;
		}
			
		System.out.println("E= "+E);
		System.out.println("D= "+D);
	}
}
