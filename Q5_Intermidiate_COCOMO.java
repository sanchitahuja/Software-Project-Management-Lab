import java.util.Scanner;

public class Q5_Intermidiate_COCOMO {
	
	static double COCOMO[][] = {
			{3.2, 1.05, 2.5, 0.38},
			{3.0, 1.12, 2.5, 0.35},   
			{2.8, 1.20, 2.5, 0.32} };
	public static double getE(double loc){

		int type=0;
		if(loc>50)
			type=1;
		if(loc>300)
			type=2;
		double E = COCOMO[type][0] * Math.pow(loc, COCOMO[type][1]);
		return E;
	}
	public static double getD(double loc){

		int type=0;
		if(loc>50)
			type=1;
		if(loc>300)
			type=2;
		double E = COCOMO[type][0] * Math.pow(loc, COCOMO[type][1]);

		double D = COCOMO[type][2] * Math.pow(E, COCOMO[type][3]);
		return D;
	}
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
