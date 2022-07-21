package BaiTap.Bai3_PersonManagement.service;

import BaiTap.Bai3_PersonManagement.model.Lecturers;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class LecturersService implements LecturersImpl {
    private static ArrayList<Lecturers> lecturersArrayList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    {
        reader();
    }

    public void write() {
        try {
            FileWriter fileWriter = new FileWriter("src\\BaiTap\\Bai3_PersonManagement\\data\\lecturers.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for(Lecturers lecturers: lecturersArrayList) {
                bufferedWriter.write(lecturers.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reader() {
        try {
            FileReader fileReader = new FileReader("src\\BaiTap\\Bai3_PersonManagement\\data\\lecturers.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String[] data;
            String line;
            Lecturers lecturers;
            while ((line = bufferedReader.readLine()) != null) {
                data = line.split(",");
                lecturers = new Lecturers(data[0],data[1],data[2],data[3],data[4]);
                lecturersArrayList.add(lecturers);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewLecturers() {
        System.out.println("Enter id lecturers: ");
        String id = scanner.nextLine();
        while (!(id.matches("[G][V][-][0-9]{4}"))){
            System.out.println("please re-enter: ");
            System.out.println("Enter id lecturers: ");
            id = scanner.nextLine();
        }

        System.out.println("Enter name lecturers: ");
        String name = scanner.nextLine();

        String birthday;
        do {
            System.out.println("Enter birthday: ");
            birthday = scanner.nextLine();
        }  while (!Pattern.matches("(((0[1-9]|[12][0-9]|30)[-\\/](0[13-9]|1[012])|31[-\\/](0[13578]|1[02])|(0[1-9]|1[0-9]|2[0-8])[-\\/]02)" +
                "[-\\/](19[0-9]{2}|200[012])|29[-\\/]02[-\\/]" +
                "([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048]|0[0-9]|1[0-6])00))$", birthday));

        System.out.println("*--- Gender ---*");
        System.out.println("* 1. Male.     *");
        System.out.println("* 2. Female.   *");
        System.out.println("* 3. Other.    *");
        System.out.println("*--------------*");
        String gender = " ";
        int choose = Integer.parseInt(scanner.nextLine());
        switch (choose) {
            case 1:
                gender = "Male";
                break;
            case 2:
                gender = "Female";
                break;
            case 3:
                gender = "Other";
                break;
        }

        System.out.println("Specialties of lecturers: ");
        String specialties = scanner.nextLine();

        Lecturers lecturers = new Lecturers(id, name, birthday, gender, specialties);
        lecturersArrayList.add(lecturers);
        write();
        //reader();
    }

    @Override
    public void deleteLecturers() {
        System.out.println("Enter id lecturers to delete: ");
        String id = scanner.nextLine();
        try {
            for(int i = 0; i < lecturersArrayList.size(); i++) {
                if(lecturersArrayList.get(i).getId().equals(id)) {
                    System.out.println("Do you want to delete?: ");
                    System.out.println("1.\tYes.");
                    System.out.println("2.\tNo.");
                    int choice = Integer.parseInt(scanner.nextLine());
                    if(choice == 1) {
                        lecturersArrayList.remove(i);
                        System.out.println("Delete successfully");
                        break;
                    } else {
                        break;
                    }
                } else {
                    System.out.println("No lecturers to delete");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + "return main menu");
            scanner.nextInt();
        }
    }

    @Override
    public void searchLecturers() {
        System.out.println("Enter name to search: ");
        String strLecturers = scanner.nextLine();

        ArrayList<Lecturers> arrayList = new ArrayList<>();
        for (Lecturers lecturers : lecturersArrayList) {
            if (lecturers.getName().toLowerCase().contains(strLecturers.toLowerCase())) {
                arrayList.add(lecturers);
            }
        }
        if(arrayList.size() == 0) {
            System.out.println("No name to delete");
        } else {
            for(Lecturers lecturers : arrayList) {
                System.out.println(lecturers);
            }
        }
    }

    @Override
    public void displayLecturers() {
        for(Lecturers lecturers: lecturersArrayList) {
            System.out.println(lecturers);
        }
    }
}
