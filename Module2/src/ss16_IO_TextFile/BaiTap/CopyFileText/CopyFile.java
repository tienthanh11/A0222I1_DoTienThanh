package ss16_IO_TextFile.BaiTap.CopyFileText;

import java.io.*;

public class CopyFile {
    public static final String PATH_SOURCE_FILE = "src\\ss16_IO_TextFile\\BaiTap\\CopyFileText\\sourceFile.txt";
    public static final String PATH_TARGET_FILE = "src\\ss16_IO_TextFile\\BaiTap\\CopyFileText\\targetFile.txt";
    public static String readFile(File file) throws IOException {
        FileReader fr = new FileReader(file);
        String result = " ";
        int i;
        while ((i = fr.read()) != -1) {
            result += (char) i;
        }
        fr.close();
        return result;
    }

    public static void writeFile(File file, String content){
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(content);
            fw.close();
            System.out.println("Write success !");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            String result = readFile(new File(PATH_SOURCE_FILE));
            System.out.println(result);
            writeFile(new File(PATH_TARGET_FILE), result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
