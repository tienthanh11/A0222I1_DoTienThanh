package BaiTap.Bai1_PhoneManager.util;

import BaiTap.Bai1_PhoneManager.model.Phone;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {
    public List<String> read(String path) {
        List<String> result = new ArrayList<String>();

        try {
            File file = new File(path);
            if(!file.exists()) {
                file.createNewFile();
            }
            FileReader reader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                if (!line.isEmpty()) {
                    result.add(line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void write(String path, List<Phone> phones, boolean isAppend) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, isAppend))){
            for(Phone phone : phones) {
                writer.write(phone.toData());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
