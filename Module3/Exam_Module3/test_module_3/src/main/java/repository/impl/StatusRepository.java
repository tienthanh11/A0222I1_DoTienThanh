package repository.impl;

import models.StatusStage;
import models.TypeStatus;
import repository.ITypeRepository;
import utils.ConnectData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusRepository implements ITypeRepository<StatusStage> {
    String findAll = "select * from status_stage";

    @Override
    public List<StatusStage> findAll() {
        List<StatusStage> list = new ArrayList<>();

        try (Connection connection = ConnectData.getConnect(); PreparedStatement statement = connection.prepareStatement(findAll)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                list.add(new StatusStage(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
