package com.jax.queries;

public class Users {

    private Users() {
    }

    public static final String SELECT_ALL = "SELECT * FROM users";
    public static final String FIND_BY_USERNAME = "SELECT * FROM user WHERE `username`=?";
    public static final String UPDATE_USER = "UPDATE users SET username = ? WHERE id = ?";

    public static final String CREATE_TABLE = "CREATE TABLE users " +
            "(" +
            "id int(11) PRIMARY KEY," +
            "username varchar(256)," +
            "password varchar(256)," +
            "email varchar(256)" +
            ")";
    public static final String DROP_TABLE = "DROP TABLE users";
}
