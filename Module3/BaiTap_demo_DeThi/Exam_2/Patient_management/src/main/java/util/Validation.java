package util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.regex.Pattern;

public class Validation {
    public static boolean checkEmail(String email) {
        String regEmail = "^[a-z]\\w+@gmail+\\.[a-z]+$";
        return email.matches(regEmail);
    }

    public static boolean checkPhoneNumber(String phone) {
        String regPhone = "^090(\\d{7})|091(\\d{7})|\\(84\\)\\+90(\\d{7})|\\(84\\)\\+91(\\d{7})$";
        return phone.matches(regPhone);
    }


    public static boolean checkNumberInt(Integer number) {
        return number > 0;
    }

    public static boolean checkNumberDouble(Double number) {
        return number > 0;
    }

    public static boolean checkIdGround(String idGround) {
        String regIdGround = "^[A-Z]{3}-[A-Z]{2}-[A-Z]{2}$";
        return idGround.matches(regIdGround);
    }

    public static boolean checkArea(Double areaGround) {
        return areaGround > 20;
    }

    public static boolean checkPrice(Double price) {
        return price > 1000000;
    }

//    public static boolean checkDate(String date) {
//        String redDate = "^(?:(?:31(/)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(/)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(/)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(/)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
//        return date.matches(redDate);
//    }

    public static String formatDate(String date) {
        DateTimeFormatter formatterStart = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatterEnd = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date, formatterStart).format(formatterEnd);
    }

    public static String formatDateContract(String date) {
        DateTimeFormatter formatterStart = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatterEnd = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return LocalDateTime.parse(date, formatterStart).format(formatterEnd);
    }

//     chuyển dd/mm/yyyy thành yyyy/mm/dd để chuyển qua cho mySQL

    public static String dateSql(String dateOfSql) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        return LocalDate.parse(dateOfSql, formatter).format(formatter2);
    }


    public static final String REGDATE = "^(?:(?:31(/)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(/)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(/)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(/)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

    // 6 thang
    public static boolean checkDate(String startDate, String endDate) {
        if (Pattern.matches(REGDATE, startDate) && Pattern.matches(REGDATE, endDate)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate ngayVao = LocalDate.parse(startDate, formatter);
            LocalDate ngayRa = LocalDate.parse(endDate, formatter);
//            int current = Period.between(ngayVao, ngayRa).getDays();
//            long current = ChronoUnit.DAYS.between(ngayVao, ngayRa);
//            if (current > 180) {
//                return true;
//            }
        }
        return false;
    }

//    public static boolean checkIdExists(String id) {
//        IGroundRepository groundRepository = new GroundRepositoryImpl();
//        List<Ground> groundList = new ArrayList<>();
//        groundList = groundRepository.findAll();
//        for (int i = 0; i < groundList.size(); i++) {
//            if (id.equals(groundList.get(i).getId())) {
//                return false;
//            }
//        }
//        return true;
//    }
}