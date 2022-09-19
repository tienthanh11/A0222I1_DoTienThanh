package repository.impl;

import models.TypeStatus;
import repository.ITypeRepository;
import utils.ConnectData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TypeRepository implements ITypeRepository<TypeStatus> {
    String findAll = "select * from type_stage";
    @Override
    public List<TypeStatus> findAll() {
        List<TypeStatus> list = new ArrayList<>();
        try (Connection connection = ConnectData.getConnect(); PreparedStatement statement = connection.prepareStatement(findAll)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                list.add(new TypeStatus(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
