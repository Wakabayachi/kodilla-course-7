package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 
 */
public class DbManagerTestSuite {

    @Test
    public void testSelectUsersAndPosts() {
        // Lista użytkowników do sprawdzenia asercji
        List<String> expectedUsers = List.of("Jan Kowalski", "Anna Nowak");

        // Lista użytkowników zwróconych przez zapytanie
        List<String> actualUsers = new ArrayList<>();

        try (Connection connection = getConnection("jdbc:your_database_url", "username", "password");
             Statement statement = connection.createStatement()) {

            String sqlQuery = "SELECT u.firstname, u.lastname " +
                    "FROM USERS u " +
                    "JOIN POSTS p ON u.id = p.user_id " +
                    "GROUP BY u.id, u.firstname, u.lastname " +
                    "HAVING COUNT(p.id) >= 2";

            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String fullname = firstname + " " + lastname;
                actualUsers.add(fullname);
                System.out.println(fullname);
            }

            // Sprawdzenie, czy liczba rekordów się zgadza
            assertEquals(expectedUsers.size(), actualUsers.size(), "Number of users with at least two posts should match the expected number.");

            // Dodatkowe asercje mogą być dodane tutaj, aby porównać zawartość list

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}