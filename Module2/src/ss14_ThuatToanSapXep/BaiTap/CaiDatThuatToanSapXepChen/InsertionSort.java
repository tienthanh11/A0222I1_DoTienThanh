package ss14_ThuatToanSapXep.BaiTap.CaiDatThuatToanSapXepChen;

public class InsertionSort {
    static int[] list = {3, 9, -4, 4, 1, 6, 14, 10, 25, 8};

    public static void insertionSort(int[] list) {
        for(int i = 0; i < list.length; i++) {
            int x = list[i];
            int pos = i;
            while (pos > 0 && x < list[pos - 1]) {
                list[pos] = list[pos - 1];
                pos--;
            }
            list[pos] = x;
        }
    }

    public static void main(String[] args) {
        insertionSort(list);
        for(int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
    }
}
