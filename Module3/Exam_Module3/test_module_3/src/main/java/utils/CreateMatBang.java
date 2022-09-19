package utils;

import models.MatBang;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateMatBang {
    public static MatBang createMatBangByResult(ResultSet resultSet) throws SQLException {
        String id = resultSet.getString("id");
        int area = resultSet.getInt("area");
        int status = resultSet.getInt("status_id");
        int stage = resultSet.getInt("stage");
        int typeStage = resultSet.getInt("type_stage_id");
        String textStage = resultSet.getString("text_stage");
        int price = resultSet.getInt("price");
        Date dateIn = resultSet.getDate("date_in");
        Date dateOut = resultSet.getDate("date_out");
        return new MatBang(id, area, status, stage, typeStage, textStage, price, dateIn, dateOut);
    }
    public static MatBang createMatBangByRequest(HttpServletRequest  request) throws SQLException {
        String id = request.getParameter("id");
        int area = Integer.parseInt(request.getParameter("area"));
        int status = Integer.parseInt(request.getParameter("status"));
        int stage = Integer.parseInt(request.getParameter("stage"));
        int typeStage = Integer.parseInt(request.getParameter("typeStage"));
        String textStage = request.getParameter("textStage");
        int price = Integer.parseInt(request.getParameter("price"));
        Date dateIn = Date.valueOf(request.getParameter("dateIn"));
        Date dateOut = Date.valueOf(request.getParameter("dateOut"));
        return new MatBang(id, area, status, stage, typeStage, textStage, price, dateIn, dateOut);
    }
    public static void inputMatBangInQuery(PreparedStatement statement,MatBang matBang) throws SQLException {
        statement.setString(1, matBang.getId());
        statement.setInt(2, matBang.getArea());
        statement.setInt(3, matBang.getStatus());
        statement.setInt(4, matBang.getStage());
        statement.setInt(5, matBang.getTypeStage());
        statement.setString(6, matBang.getTextStage());
        statement.setInt(7, matBang.getPrice());
        statement.setDate(8, matBang.getDateIn());
        statement.setDate(9, matBang.getDateOut());
    }
}
