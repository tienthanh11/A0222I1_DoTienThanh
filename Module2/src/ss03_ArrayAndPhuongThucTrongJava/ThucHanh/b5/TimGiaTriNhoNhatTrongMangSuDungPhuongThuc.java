package ss03_ArrayAndPhuongThucTrongJava.ThucHanh.b5;

public class TimGiaTriNhoNhatTrongMangSuDungPhuongThuc {
    public static int minValue(int[] array) {
        int n = array[0];
        for(int i = 1; i < array.length; i++) {
            if(array[i] < n) {
                n = i;
            }
        }
        return n;
    }
    public static void main(String[] args) {
        int[] arr = {4, 12, 7, 8, 1, 6, 9};
        int index = minValue(arr);
        System.out.println("The smallest element in the array is: " + arr[index]);
    }
}
