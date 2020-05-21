package com.Sales.SalesWeb.service.hadoop.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbManager {

    private Integer lastStatementIndex = 10;

    private Integer initCountStatement = 10;

    private Connection connection;

    private List<EntityStatement> statements = new ArrayList<>();

    public DbManager() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sales", "postgres", "admin");
            for (int i = 1; i < initCountStatement; i++) {
                statements.add(new EntityStatement(connection.createStatement(), false));
            }
        } catch (SQLException e) {
            loggingError(e);
        }
    }

    public  void loggingError(SQLException e) throws RuntimeException {
        String stringError = String.format("Error cod - %s; Message - %s; State - %s",
                e.getErrorCode(), e.getMessage(), e.getSQLState());
        System.out.println(stringError);
        throw new RuntimeException(stringError);
    }

    public Connection getConnection() {
        return connection;
    }

    public  EntityStatement getStatement() {
        int currentSize = statements.size();
        for (EntityStatement statement : statements) {
            if (!statement.getIsWork()) {
                return statement;
            }
        }
        try {
            for (int i = 1; i < 4; i++) {
                statements.add(new EntityStatement(connection.createStatement(), false));
            }
        } catch (SQLException e) {
            loggingError(e);
        }
        return statements.get(currentSize + 1);
    }
}


