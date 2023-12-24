package org.example.db.services;

import org.example.db.utils.Database;
import org.example.db.utils.DbConstants;
import org.example.db.utils.SqlScriptExecutor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DatabaseInitService {
    public static void main(String[] args) throws SQLException {
        Connection connection = Database.getInstance().getConnection();

        List<String> sqlStatements = SqlScriptExecutor.parseSqlScript(DbConstants.INIT_DB_FILE_PATH);
        SqlScriptExecutor.executeSqlStatements(sqlStatements, connection);

        connection.close();
    }
}
