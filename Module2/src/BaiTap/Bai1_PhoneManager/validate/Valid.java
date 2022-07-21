package BaiTap.Bai1_PhoneManager.validate;

public class Valid {
    public static boolean isNumber(String val){
        try{
            Double.parseDouble(val);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }


    public static boolean checkName(String name){
        boolean a = name.matches("([a-zA-Z]\\s*)*");
        return a;
    }
}
