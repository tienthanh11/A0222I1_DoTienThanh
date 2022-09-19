package repository.impl;

import models.MatBang;
import repository.IBaseRepository;
import utils.ConnectData;
import utils.CreateMatBang;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MatBangRepository implements IBaseRepository<MatBang> {
    public static final int LIMIT_DISPLAY = 5;
    String findAll = "select * from mat_bang order by area limit ? offset ?";
    String count_list = "select count(*) from mat_bang";
    String removeId = "delete from mat_bang where id = ?";
    String save = "INSERT INTO mat_bang VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String callSPSearch = "call searchAll(?,?,?,?)";

    @Override
    public List<MatBang> findAll(int limit, int offset) {
        List<MatBang> list = new ArrayList<>();
        try (Connection connection = ConnectData.getConnect(); PreparedStatement statement = connection.prepareStatement(findAll)) {
            statement.setInt(1, limit);
            statement.setInt(2, offset * limit);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(CreateMatBang.createMatBangByResult(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<MatBang> findBy(String name, String stage, String dateIn, String dateOut) {
        List<MatBang> list = new ArrayList<>();
        try (Connection connection = ConnectData.getConnect(); CallableStatement statement = connection.prepareCall(callSPSearch)) {
            statement.setString(1, name);
            statement.setInt(2, Integer.parseInt(stage));
            statement.setString(3, dateIn);
            statement.setString(4, dateOut);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(CreateMatBang.createMatBangByResult(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int count() {
        int count = 0;
        try (Connection connection = ConnectData.getConnect(); PreparedStatement statement = connection.prepareStatement(count_list)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt("count(*)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (int) Math.ceil((float) count / LIMIT_DISPLAY);
    }

    @Override
    public void save(MatBang matBang) {
        try (Connection connection = ConnectData.getConnect(); PreparedStatement statement = connection.prepareStatement(save)) {
            CreateMatBang.inputMatBangInQuery(statement, matBang);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void removeById(String id) {
        try (Connection connection = ConnectData.getConnect();
             PreparedStatement statement = connection.prepareStatement(removeId)) {
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
