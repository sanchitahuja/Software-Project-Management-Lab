import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Q3_GraphMethod {

    public static void main(String args[]){
        ArrayList<String> lines = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("src/test.txt");
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);
            String line;
            int i=0;
            while((line = bufferedReader.readLine()) != null) {
                lines.add(line);
//                System.out.println(i+":"+line);
                i++;
            }

            GraphMethod graphMethod= new GraphMethod(lines);
            graphMethod.buildGraph();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


    }
}
