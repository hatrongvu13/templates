package com.jax.utils;

import com.jax.queries.Users;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.List;

public class DatabaseUtil {

    private static final Logger logger = LogManager.getLogger(DatabaseUtil.class);

    private Connection connection;

    private String url;
    private String username;
    private String password;
    private String dbName;

    public DatabaseUtil() {
        if (connection == null) {
            createConnection();
        } else {
            logger.info("Connection is already connected.");
        }
    }

    private void createConnection() {
        try {
            connection = DriverManager.getConnection(url + dbName, username, password);
            logger.info("Success create database connection.");
        } catch (SQLException sqlException) {
            logger.error(sqlException);
        }
    }

    private boolean executeUpdate(List<String> updateProperties) {
        try {
            if (connection == null) {
                createConnection();
            }
            PreparedStatement preparedStatement = connection.prepareStatement(Users.UPDATE_USER);
            int i = 1;
            for (String parameter : updateProperties){
                preparedStatement.setString(i, parameter);
                i++;
            }
            connection.setAutoCommit(true);

            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }
}
