package ss11_DSA_StackAndQueue.BaiTap.DemSoLuongTuCoTrongChuoi;

import java.util.*;

public class DemSoLuongTuCoTrongChuoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string: ");
        String str = sc.nextLine();
        str = str.toLowerCase();
        List<String> array = new ArrayList<>();
        for(int i = 0; i < str.length(); i++) {
            array.add(String.valueOf(str.charAt(i)));
        }
        String key;
        Integer value;
        Map<String, Integer> map = new TreeMap<>();
        for(int i = 0; i < str.length(); i++) {
            key = array.get(i);
            if(map.containsKey(key)) {
                value = map.get(key);
                map.put(key, value + 1);
            } else {
                map.put(key, 1);
            }
        }

        Set set = map.keySet();

        for (Object o : set) {
            key = (String) o;
            System.out.println("Từ '" + key + "' xuất hiện " + map.get(key) + " lần");
        }
    }
}
