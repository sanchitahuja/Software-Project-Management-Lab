import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Q2_ConceptOfRegion {



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
                System.out.println(i+":"+line);
                i++;
            }

            bufferedReader.close();
            Graph graph = new Graph(lines);
            int graphMatrix[][]=graph.buildGraph();
            int edges=0;
            for (int j = 0; j <graphMatrix.length ; j++) {
                for (int k = 0; k < graphMatrix[0].length; k++) {
                    if(graphMatrix[j][k]==1)
                        edges++;
                }
            }
            // V-E+F=2
            System.out.println();
            int numberOfregions=edges-graphMatrix.length+2;
            System.out.println("Number of regions "+numberOfregions);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
