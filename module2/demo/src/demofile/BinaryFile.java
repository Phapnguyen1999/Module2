package demofile;

import java.io.*;

public class BinaryFile {
    public static void main(String[] args) throws IOException {
        int arr[]={67,111,100,101,103,121,109};
        FileOutputStream fout=new FileOutputStream("test.txt");
        BufferedOutputStream dout = new BufferedOutputStream(fout);
        for (int i=0;i< arr.length;i++)
            dout.write(arr[i]);
        dout.close();
//        FileInputStream fin = new FileInputStream("test.txt");
//        BufferedInputStream din = new BufferedInputStream(fin);
//        int leng=din.available();
//        for (int i=0;i<leng;i++){
//            System.out.print((char)din.read());
//        }
//        din.close();
//        File file = new File("text.txt");
//        FileOutputStream fos=new FileOutputStream(file);
//        fos.write(258);
//        fos.close();
//        System.out.println(file.length());
    }
}
