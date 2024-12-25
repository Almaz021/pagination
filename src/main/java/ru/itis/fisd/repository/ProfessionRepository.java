package ru.itis.fisd.repository;

import ru.itis.fisd.model.Profession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessionRepository {
    private final DbWork db = DbWork.getInstance();

    /* language=sql */
    private static final String SQL_COUNT_BY_NAME = """
            SELECT COUNT(*)
            FROM profession
            WHERE UPPER(name) LIKE '%' || UPPER(?) || '%'
            """;

    private static final String SQL_FIND_BY_NAME = """
            SELECT *
            FROM profession
            WHERE UPPER(name) LIKE '%' || UPPER(?) || '%'
            ORDER BY id
            LIMIT ?
            OFFSET ?
            """;

    public List<Profession> findByName(String name, int limit, int offset) {
        List<Profession> professions = new ArrayList<>();

        try (
                Connection connection = db.getConnection()
        ) {
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_NAME);
            statement.setString(1, name);
            statement.setInt(2, limit);
            statement.setInt(3, offset);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                Profession order = new Profession(
                        resultSet.getLong("id"),
                        resultSet.getString("name")
                );
                professions.add(order);
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return professions;
    }

    public Integer countResults(String name) {
        try (
                Connection connection = db.getConnection()
        ) {
            PreparedStatement statement = connection.prepareStatement(SQL_COUNT_BY_NAME);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}