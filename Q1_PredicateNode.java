import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Q1_PredicateNode {

    public static void main(String args[]){
        File file=new File("src/test.txt");
        try {
            Scanner scanner=new Scanner(file);
            StringBuilder stringBuilder=new StringBuilder();
            while (scanner.hasNext())
                stringBuilder.append(scanner.next()+"\n");
            String text=stringBuilder.toString();
//            System.out.println(text);
            Pattern ifPattern = Pattern.compile("if(.*)", Pattern.CASE_INSENSITIVE);
            String regx = "else\\sif";
            Pattern else_ifPattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
            Pattern whilePattern = Pattern.compile("while(.*)", Pattern.CASE_INSENSITIVE);
            Pattern forPattern = Pattern.compile("for(.*)", Pattern.CASE_INSENSITIVE);

            Matcher ifMatcher=ifPattern.matcher(text);
            Matcher whileMatcher=whilePattern.matcher(text);
            Matcher forMatcher=forPattern.matcher(text);
            Matcher elseIfMatcher=else_ifPattern.matcher(text);

            int ifCount=0;
            int whileCount=0;
            int forCount=0;
            int elseIfCount=0;
            while(ifMatcher.find())
                ifCount++;
            while(whileMatcher.find())
                whileCount++;
            while(forMatcher.find())
                forCount++;
            while(elseIfMatcher.find())
                elseIfCount++;
            System.out.println("IF count "+ifCount);
            System.out.println("WHILE count "+whileCount);
            System.out.println("FOR count "+forCount);
            System.out.println("ELSE IF count "+elseIfCount);
            System.out.println("Cyclometric Complexity of code is "+(ifCount+whileCount+forCount+1-elseIfCount));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }
}
