package deportista;

import java.io.*;

public class Pruebas {

    public static void main(String[] args) throws IOException{


        FileReader fileReader;
        BufferedReader bufferedReader;

        try {

            File dataFile = new File("data.txt");
            fileReader = new FileReader(dataFile);
            bufferedReader = new BufferedReader(fileReader);
            String currentLine = bufferedReader.readLine();
            while(currentLine != null){
                String dataLine = currentLine.replace('-', ' ');
                String[] DataArray = dataLine.split(" ");

                deportista dep_1 = new deportista(DataArray);
                
                currentLine = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();
            
        } catch (IOException e) {
            System.out.println(e);
        }


        
    }
    
}
