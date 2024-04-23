package Project2Part1Java.CSVDataSmoother;

import java.io.*;
import java.util.ArrayList;

public class Smoother {
    public void smooth(String filename, int leftBound, int rightBound) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        ArrayList<Integer> saltedData = new ArrayList<>();
        FileWriter fileWriter = new FileWriter("SmoothedPolynomialResults.csv");
        BufferedWriter writer = new BufferedWriter(fileWriter);
        String currentLine = "";
        String[] values;
        try {
            while ((currentLine = reader.readLine()) != null) {
                values = currentLine.split(",");
                int value = Integer.parseInt(values[0]);
                saltedData.add(value);
            }

            //0, 1, 2, 3, 4, 5, 6, 7, 8, 9,  10, 11
            //1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12
            double sum = 0;
            int count = 0;
            for (int i = 0; i < saltedData.size(); i++) {
                if (i >= leftBound || i <= rightBound) {
                    sum = sum + saltedData.get(i);
                    count++;
                }
//            else if(i > (saltedData.size() - bound)) {
//
//            }
            }
            double average = sum / count;
            String smoothedValue = String.valueOf(average);
            writer.write(smoothedValue);
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
		finally
        {
            try
            {
                if (reader != null) {
                    reader.close();
                    writer.close();
                }
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }
}
