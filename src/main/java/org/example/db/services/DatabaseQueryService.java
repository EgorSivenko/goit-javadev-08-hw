package org.example.db.services;

import org.example.db.model.*;
import org.example.db.utils.Database;
import org.example.db.utils.SqlScriptExecutor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.example.db.utils.DbConstants.*;

public class DatabaseQueryService {
    public static void main(String[] args) throws SQLException {
        Connection connection = Database.getInstance().getConnection();

        System.out.println(findMaxSalaryWorkers(connection));
        System.out.println(findMaxProjectsClients(connection));
        System.out.println(findLongestProjects(connection));
        System.out.println(findYoungestEldestWorkers(connection));
        System.out.println(findProjectPrices(connection));

        connection.close();
    }

    public static List<MaxSalaryWorker> findMaxSalaryWorkers(Connection connection) {
        List<MaxSalaryWorker> maxSalaryWorkers = new ArrayList<>();
        List<String> sqlStatements = SqlScriptExecutor.parseSqlScript(FIND_MAX_SALARY_WORKER_FILE_PATH);

        try (Statement statement = connection.createStatement()) {
            for (String sqlStatement : sqlStatements) {
                ResultSet resultSet = statement.executeQuery(sqlStatement);
                while (resultSet.next()) {
                    MaxSalaryWorker maxSalaryWorker = new MaxSalaryWorker();
                    maxSalaryWorker.setWorkerName(resultSet.getString("worker_name"));
                    maxSalaryWorker.setSalary(resultSet.getInt("salary"));
                    maxSalaryWorkers.add(maxSalaryWorker);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return maxSalaryWorkers;
    }

    public static List<MaxProjectsClient> findMaxProjectsClients(Connection connection) {
        List<MaxProjectsClient> maxProjectsClients = new ArrayList<>();
        List<String> sqlStatements = SqlScriptExecutor.parseSqlScript(FIND_MAX_PROJECTS_CLIENT_FILE_PATH);

        try (Statement statement = connection.createStatement()) {
            for (String sqlStatement : sqlStatements) {
                ResultSet resultSet = statement.executeQuery(sqlStatement);
                while (resultSet.next()) {
                    MaxProjectsClient maxProjectsClient = new MaxProjectsClient();
                    maxProjectsClient.setClientName(resultSet.getString("client_name"));
                    maxProjectsClient.setProjectCount(resultSet.getInt("project_count"));
                    maxProjectsClients.add(maxProjectsClient);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return maxProjectsClients;
    }

    public static List<LongestProject> findLongestProjects(Connection connection) {
        List<LongestProject> longestProjects = new ArrayList<>();
        List<String> sqlStatements = SqlScriptExecutor.parseSqlScript(FIND_LONGEST_PROJECT_FILE_PATH);

        try (Statement statement = connection.createStatement()) {
            for (String sqlStatement : sqlStatements) {
                ResultSet resultSet = statement.executeQuery(sqlStatement);
                while (resultSet.next()) {
                    LongestProject longestProject = new LongestProject();
                    longestProject.setProjectId(resultSet.getLong("project_id"));
                    longestProject.setMonthCount(resultSet.getInt("month_count"));
                    longestProjects.add(longestProject);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return longestProjects;
    }

    public static List<YoungestEldestWorker> findYoungestEldestWorkers(Connection connection) {
        List<YoungestEldestWorker> youngestEldestWorkers = new ArrayList<>();
        List<String> sqlStatements = SqlScriptExecutor.parseSqlScript(FIND_YOUNGEST_ELDEST_WORKERS_FILE_PATH);

        try (Statement statement = connection.createStatement()) {
            for (String sqlStatement : sqlStatements) {
                ResultSet resultSet = statement.executeQuery(sqlStatement);
                while (resultSet.next()) {
                    YoungestEldestWorker youngestEldestWorker = new YoungestEldestWorker();
                    youngestEldestWorker.setType(resultSet.getString("type"));
                    youngestEldestWorker.setWorkerName(resultSet.getString("worker_name"));
                    youngestEldestWorker.setBirthday(resultSet.getDate("birthday").toLocalDate());
                    youngestEldestWorkers.add(youngestEldestWorker);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return youngestEldestWorkers;
    }

    public static List<ProjectPrice> findProjectPrices(Connection connection) {
        List<ProjectPrice> projectPrices = new ArrayList<>();
        List<String> sqlStatements = SqlScriptExecutor.parseSqlScript(PRINT_PROJECT_PRICES_FILE_PATH);

        try (Statement statement = connection.createStatement()) {
            for (String sqlStatement : sqlStatements) {
                ResultSet resultSet = statement.executeQuery(sqlStatement);
                while (resultSet.next()) {
                    ProjectPrice projectPrice = new ProjectPrice();
                    projectPrice.setProjectId(resultSet.getLong("project_id"));
                    projectPrice.setProjectPrice(resultSet.getLong("project_price"));
                    projectPrices.add(projectPrice);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return projectPrices;
    }
}
