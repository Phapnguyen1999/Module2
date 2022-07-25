package bai1;

import java.io.*;
import java.util.Scanner;

public class ReadFile {
    public void readFileText(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader((file)));
            String line ="";
            int sum = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            br.close();
            System.out.println("Tổng = " + sum);
        } catch (Exception ex) {
            System.out.println("Lỗi file");
        }
    }

    public static void main(String[] args) {

        ReadFile readFile = new ReadFile();
        readFile.readFileText("src/bai1/text.txt");
    }
}
