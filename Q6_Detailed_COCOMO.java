import java.util.Scanner;

public class Q6_Detailed_COCOMO {

    public static void main(String args[]){
        double table[][]={{3.2,1.05,2.5,0.38},{3.0,1.12,2.5,0.35},{2.8,1.20,2.5,0.32}};
        int i,j,size,model,rating,S = 0;
        String mode[]={"Organic","Semi-Detached","Embedded"};
        String driver[]={"RELY","DATA","CPLX","TIME","STOR","VIRT","TURN","ACAP","AEXP","PCAP",
            "VEXP","LEXP","MODP","TOOL","SCED"};
        double effort,EAF,a,time,staff,productivity;
        double costdrivers[][]={
        {0.75,0.88,1,1.15,1.40,-1},
        {-1,0.94,1,1.08,1.16,-1},
        {0.70,0.85,1,1.15,1.30,1.65},

        {-1,-1,1,1.11,1.30,1.66},
        {-1,-1,1,1.06,1.21,1.56},
        {-1,0.87,1,1.15,1.30,-1},
        {-1,0.87,1,1.07,1.15,-1},

        {1.46,1.19,1,0.86,0.71,-1},
        {1.29,1.13,1.00,0.91,0.82,-1},
        {1.42,1.17,1,0.86,0.70,-1},
        {1.21,1.10,1,0.90,-1,-1},
        {1.14,1.07,1,0.95,-1,-1},

        {1.24,1.10,1.00,0.91,0.82,-1},
        {1.24,1.10,1,0.91,0.83,-1},
        {1.23,1.08,1,1.04,1.10,-1}
    };

        double mp[][]={
        {0.06,0.16,0.26,0.42,0.16},
        {0.06,0.16,0.24,0.38,0.22},
        {0.07,0.17,0.25,0.33,0.25},
        {0.07,0.17,0.24,0.31,0.28},
        {0.08,0.18,0.25,0.26,0.31},
        {0.08,0.18,0.24,0.24,0.34}
    };
        double tp[][]={
        {0.10,0.19,0.24,0.39,0.18},
        {0.12,0.19,0.21,0.34,0.26},
        {0.20,0.26,0.21,0.27,0.26},
        {0.22,0.27,0.19,0.25,0.29},
        {0.36,0.36,0.18,0.18,0.28},
        {0.40,0.38,0.16,0.16,0.30}
    };

        String phases[]={"Planning and Requirements","System Design","Detail Design","Module Code and Test","Integration and Test"};
        Scanner scanner=new Scanner(System.in);
        System.out.printf("\nEnter the size of project : ");
        size=scanner.nextInt();
        model=0;
        if(size>=2 && size<=50)
            model=0;
        else if(size>50 && size<=300)
            model=1;
        else if(size>300)
            model=2;
        System.out.printf("\nMode = %s",mode[model]);
        EAF=1;
        for(i=0;i<15;i++)
        {
            do
            {
                System.out.printf("\nRate cost driver %s on scale of 0-5 : ",driver[i]);
                System.out.printf("\n0-Very Low\t1-Low\t2-Nominal\t3-High\t4-Very High\t5-Extra High\n");
                rating=scanner.nextInt();
                a=costdrivers[i][rating];
                if(a==-1)
                {
                    System.out.printf("\nNo value exist for this rating..Enter another rating...\n");
                }
            }while(a==-1);
            EAF=EAF*a;
        }
        System.out.printf("\nEAF = %f",EAF);

        effort=(table[model][0]*Math.pow(size,table[model][1])) * EAF;
        time=table[model][2]*Math.pow(effort,table[model][3]);
        staff=effort/time;
        productivity=size/effort;

        System.out.printf("\n\nEffort = %f Person-Month",effort);
        System.out.printf("\nDevelopment Time = %f Months",time);
        System.out.printf("\nAverage Staff Required = %f Persons",staff);
        System.out.printf("\nProductivity = %f KLOC/Person-Month",productivity);
        System.out.printf("\n\n");

        if(model==0)
        {
            System.out.printf("\nEnter Organic - Small(0) or Medium(1) : ");
            S=scanner.nextInt();
        }
        else if(model==1)
        {
            System.out.printf("\nEnter Semi-Detached - Medium(2) or Large(3) : ");
            S=scanner.nextInt();
        }
        else if(model==2)
        {
            System.out.printf("\nEnter Embedded - Large(4) or Extra Large(5) : ");
            S=scanner.nextInt();
        }
        System.out.printf("\n\nPhase-wise Distribution of Effort is :\n\n");
        for(i=0;i<5;i++)
        {
            System.out.printf("\n%s Phase  =  ",phases[i]);
            System.out.printf("%f",effort*mp[S][i]);
        }
        System.out.printf("\n\nPhase-wise Distribution of Development Time is :\n\n");
        for(i=0;i<5;i++)
        {
            System.out.printf("\n%s Phase  =  ",phases[i]);
            System.out.printf("%f",time*tp[S][i]);
        }

    }


}
