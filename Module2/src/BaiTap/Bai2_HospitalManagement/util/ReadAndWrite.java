package BaiTap.Bai2_HospitalManagement.util;

import BaiTap.Bai2_HospitalManagement.model.BenhAnThuong;
import BaiTap.Bai2_HospitalManagement.model.BenhAnVip;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    final static String BenhAn = "src\\BaiTap\\Bai2_HospitalManagement\\data\\medical_record.csv";

    private static void writeListToCSV(List<String> list, String path, boolean append) {
        File file = new File(path);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (String string : list) {
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
        }
    }

    private static List<String> readList(String path) {
        List<String> list = new ArrayList<>();
        File file = new File(path);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("Lỗi đọc file");
        }
        return list;
    }

    public static void writeBenhAn(List<BenhAnThuong> benhAnList, boolean append){
        List<String> strings = new ArrayList<>();
        for (BenhAnThuong benhAn : benhAnList) {
            strings.add(benhAn.getInfoBenhAn());
        }
        writeListToCSV(strings,BenhAn, append);
    }

    public static List<BenhAnThuong> readBenhAn(){
        List<String> list = readList(BenhAn);
        List<BenhAnThuong> benhAnList = new ArrayList<>();
        String[] array = null;
        for (int i = 0; i < list.size(); i++) {
            array = list.get(i).split(",");
            BenhAnThuong benhAn = new BenhAnThuong(array[0], array[1],array[2],array[3],array[4],array[5],array[6]);
            benhAnList.add(benhAn);
        }
        return benhAnList;
    }


    public static void writeBenhAnVIP(List<BenhAnVip> benhAnList, boolean append){
        List<String> strings = new ArrayList<>();
        for (BenhAnVip benhAn : benhAnList) {
            strings.add(benhAn.getInfoBenhAn());
        }
        writeListToCSV(strings,BenhAn, append);
    }

    public static List<BenhAnVip> readBenhAnVIP(){
        List<String> list = readList(BenhAn);
        List<BenhAnVip> benhAnList = new ArrayList<>();
        String[] array = null;
        for (int i = 0; i < list.size(); i++) {
            array = list.get(i).split(",");
            BenhAnVip benhAn = new BenhAnVip(array[0],array[1],array[2],array[3],array[4],array[5],array[6],array[7]);
            benhAnList.add(benhAn);
        }
        return benhAnList;
    }
}
