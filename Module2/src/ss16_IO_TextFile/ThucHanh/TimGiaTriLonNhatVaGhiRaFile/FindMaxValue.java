package ss16_IO_TextFile.ThucHanh.TimGiaTriLonNhatVaGhiRaFile;

import java.util.List;

public class FindMaxValue {
    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for(int i = 0; i < numbers.size(); i++) {
            if(max < numbers.get(i)) {
                max = numbers.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("E:\\A0222I1_DoTienThanh\\Module2\\src\\ss16_IO_TextFile\\ThucHanh\\TimGiaTriLonNhatVaGhiRaFile\\numbers.txt");
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("E:\\A0222I1_DoTienThanh\\Module2\\src\\ss16_IO_TextFile\\ThucHanh\\TimGiaTriLonNhatVaGhiRaFile\\result.txt", maxValue);
    }
}
