package utils;

import models.MatBang;
import service.IBaseService;
import service.impl.MatBangService;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidData {
    public static Map<String, String> checkValid(MatBang matBang) {
        IBaseService<MatBang> service = new MatBangService();
        List<MatBang> list = service.findAll(Integer.MAX_VALUE,0);
        Map<String, String> map = new HashMap<>();

        if (matBang.getPrice() < 1000000) {
            map.put("price", "price > 1000000");
        }

        if (matBang.getArea() < 20) {
            map.put("area", "area > 20");
        }

        if (!matBang.getId().matches("^[A-Z][A-Z]\\d{3}$")) {
            map.put("id", "ID should be MB000");
        }

        if (list.stream().filter(x -> x.getId().equalsIgnoreCase(matBang.getId())).findFirst().orElse(null) != null) {
            map.put("id", "ID duplicate");
        }

        if (ChronoUnit.MONTHS.between(
                YearMonth.from(LocalDate.parse(matBang.getDateIn().toString())),
                YearMonth.from(LocalDate.parse(matBang.getDateOut().toString()))) < 6) {
            map.put("dateOut", "dateOut must after day in little 6 month");
        }

        return map;
    }
}
