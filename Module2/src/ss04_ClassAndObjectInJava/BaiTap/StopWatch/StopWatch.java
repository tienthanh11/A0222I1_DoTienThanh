package ss04_ClassAndObjectInJava.BaiTap.StopWatch;

import java.util.Date;
import java.util.Arrays;

public class StopWatch {
    private Date startTime;
    private Date endTime;

    public void start() {
        startTime = new Date();
    }
    public void stop() {
        endTime = new Date();
    }
    public long getElapsedTime() {
        return endTime.getTime() - startTime.getTime();
    }

    void selectionSort(double[] array) {
        for(int i = 0; i < array.length - 1; i++) {
            int min_index = i;
            for(int j = i + 1; j < array.length; j++) {
                if(array[j] < array[min_index]) {
                    min_index = j;
                }
            }
            if(min_index != i) {
                double temp = array[min_index];
                array[min_index] = array[i];
                array[i] = temp;
            }
        }
    }
    public static void main(String[] args) {
        StopWatch sw = new StopWatch();
        double[] array = new double[100000];
        for(int i = 0; i < array.length; i++) {
            array[i] = Math.floor(Math.random() * 100) + 1;
        }
        System.out.println("Array before sort");
        System.out.println(Arrays.toString(array));
        sw.start();
        sw.selectionSort(array);
        sw.stop();
        System.out.println("Array after sort");
        System.out.println(Arrays.toString(array));
        System.out.print("Elapsed Time: " + sw.getElapsedTime() + " ms.");
    }
}
