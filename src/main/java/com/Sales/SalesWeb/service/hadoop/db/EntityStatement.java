package com.Sales.SalesWeb.service.hadoop.db;

import java.sql.Statement;

public class EntityStatement {

    private Statement statement;

    private Boolean isWork;

    public EntityStatement(Statement statement, Boolean isWork) {
        this.statement = statement;
        this.isWork = isWork;
    }

    public Statement getStatement() {
        return statement;
    }

    public Boolean getIsWork() {
        return isWork;
    }

    public void setWork(Boolean work) {
        isWork = work;
    }
}
