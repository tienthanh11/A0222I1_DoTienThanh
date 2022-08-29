package repository.impl;

import model.ClassCG;
import repository.BaseRepository;
import repository.IClassCGRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassCGRepository implements IClassCGRepository {

    private final String SELECT_ALL = "SELECT * FROM class;";

    @Override
    public List<ClassCG> findByAll() {
        // Kết nối db
        List<ClassCG> classCGList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                ClassCG classCG = new ClassCG(id, name);
                classCGList.add(classCG);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return classCGList;
    }
}
