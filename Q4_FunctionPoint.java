import java.util.Scanner;

public class Q4_FunctionPoint {

   static double FP[][] = {
            {3,  4,  6},
            {4,  5,  7},
                    {   3,  4,  6},
                            {7, 10, 15},
                                    {5,  7, 10}
    };

   public static void main(String[] args) {
        double inp[]=new double[5];
        int complex = 0;
        float ufp = 0, caf = 0;
        double[] influence=new double[14];
        System.out.println("Enter inputs, outputs, enquiries, files, and external interfaces:\n");
       System.out.println(""+inp[0]+" "+ inp[1] +" " +inp[2] +" " + inp[3] +" " + inp[4]);

       System.out.println("Enter Complexity [0-low] [1-average] [2-high]:\n");
       Scanner scanner=new Scanner(System.in);
        complex=scanner.nextInt();

       System.out.println("Answer following questions 0-5:\n");
        String questions[] = {
                "Number of communication facilities to aid transfer or exchange of information with the application or system?",
                "How are distributed data and processing functions handled?",
                "Was response time or throughput required by the user?",
                "How heavily used is the current hardware platform where the application will be executed?",
                "How frequently are transactions executed daily, weekly, monthly, etc.?",
                "What percentage of the information is entered On-Line?",
                "Was the application designed for end-user efficiency?",
                "How many ILF's are updated by On-Line transaction?",
                "Does the application have extensive logical or mathematical processing?",
                "Was the application developed to meet one or many user's needs?",
                "How difficult is conversion and installation?",
                "How effective and/or automated are start-up, back-up, and recovery procedures?",
                "Was the application specifically designed, developed, and supported to be installed at multiple sites for multiple organizations?",
                "Was the application specifically designed, developed, and supported to facilitate change?"
        };
        for (int i = 0; i<14; i++) {
            System.out.println(questions[i] + " ");
            influence[i]=scanner.nextDouble();
        }


        for (int i = 0; i<5; i++) {
            ufp += FP[i][complex] * inp[i];
        }

        for (int i = 0; i<14; i++) {
            caf += influence[i];
        }
        caf *= 0.01;
        caf += 0.65;
       System.out.println("\nUFP = " + ufp + "\nCAF = " + caf + "\nFP = " + ufp*caf);


    }
}
