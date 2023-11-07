package ru.grabber;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PsqlStore implements Store, AutoCloseable {
    private Connection cnn;

    public PsqlStore(Properties config) {
        try {
            Class.forName(config.getProperty("jdbc.driver"));
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
        try {
            this.cnn = DriverManager.getConnection(
                    config.getProperty("jdbc.url"),
                    config.getProperty("jdbc.username"),
                    config.getProperty("jdbc.password")
                );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void save(Post p) {
        try (PreparedStatement statement =
                     cnn.prepareStatement(
                             "insert into post (name, text, link, created) "
                                     + "values (?, ?, ?, ?) on conflict do nothing")) {
            statement.setString(1, p.getName());
            statement.setString(2, p.getText());
            statement.setString(3, p.getUrl());
            statement.setDate(4, java.sql.Date.valueOf(p.getCreatedDate()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Post> getAll() {
        List<Post> postList = new ArrayList<>();
        try (PreparedStatement statement = cnn.prepareStatement("select * from post")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Post p = new Post(resultSet.getInt("id"),
                            resultSet.getString("link"),
                            resultSet.getString("name"),
                            resultSet.getString("text"),
                            LocalDate.parse(resultSet.getString("created"))
                            );
                    postList.add(p);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return postList;
    }

    @Override
    public Post findById(int id) {
        Post post = new Post(-1, "h", "d", "t", LocalDate.parse("2000-01-01"));
        try (PreparedStatement statement =
                     cnn.prepareStatement("select * from post where id = ?")) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    post.setId(resultSet.getInt("id"));
                    post.setUrl(resultSet.getString("link"));
                    post.setName(resultSet.getString("name"));
                    post.setText(resultSet.getString("text"));
                    post.setCreatedDate(LocalDate.parse(resultSet.getString("created")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return post;
    }

    @Override
    public void close() throws Exception {
        if (cnn != null) {
            cnn.close();
        }
    }
}
