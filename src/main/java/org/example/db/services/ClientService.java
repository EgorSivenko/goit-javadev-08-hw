package org.example.db.services;

import org.example.db.entity.Client;
import org.example.db.utils.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private final PreparedStatement createSt;
    private final PreparedStatement getByIdSt;
    private final PreparedStatement setNameSt;
    private final PreparedStatement deleteByIdSt;
    private final PreparedStatement listAllSt;

    public ClientService(Connection connection) throws SQLException {
        createSt = connection.prepareStatement("INSERT INTO clients (client_name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
        getByIdSt = connection.prepareStatement("SELECT client_name FROM clients WHERE client_id = ?");
        setNameSt = connection.prepareStatement("UPDATE clients SET client_name = ? WHERE client_id = ?");
        deleteByIdSt = connection.prepareStatement("DELETE FROM clients WHERE client_id = ?");
        listAllSt = connection.prepareStatement("SELECT client_id, client_name FROM clients");
    }

    public long create(String name) throws SQLException {
        createSt.setString(1, name);

        try {
            createSt.executeUpdate();
        } catch (SQLException ex) {
            throw new IllegalArgumentException("Client name is too short");
        }

        try (ResultSet resultSet = createSt.getGeneratedKeys()) {
            if (!resultSet.next()) {
                return -1;
            }
            return resultSet.getLong(1);
        }
    }

    public String getById(long id) throws SQLException {
        if (id < 1)
            throw new IllegalArgumentException("Client id cannot be <= 0");

        getByIdSt.setLong(1, id);

        try (ResultSet resultSet = getByIdSt.executeQuery()) {
            if (!resultSet.next()) {
                throw new IllegalStateException("Client with id " + id + " doesn't exist");
            }
            return resultSet.getString("client_name");
        }
    }

    public boolean setName(long id, String name) throws SQLException {
        if (id < 1)
            throw new IllegalArgumentException("Client id cannot be <= 0");

        setNameSt.setString(1, name);
        setNameSt.setLong(2, id);

        try {
            int update = setNameSt.executeUpdate();
            return update != 0;
        } catch (SQLException ex) {
            throw new IllegalArgumentException("Client name is too short");
        }
    }

    public boolean deleteById(long id) throws SQLException {
        if (id < 1)
            throw new IllegalArgumentException("Client id cannot be <= 0");

        deleteByIdSt.setLong(1, id);

        try {
            int update = deleteByIdSt.executeUpdate();
            return update != 0;
        } catch (SQLException ex) {
            throw new IllegalArgumentException(
                    "Client with id " + id + " cannot be deleted due to foreign key constraint");
        }
    }

    public List<Client> listAll() throws SQLException {
        List<Client> clients = new ArrayList<>();

        try (ResultSet resultSet = listAllSt.executeQuery()) {
            while (resultSet.next()) {
                var client = new Client();
                client.setClientId(resultSet.getLong("client_id"));
                client.setClientName(resultSet.getString("client_name"));
                clients.add(client);
            }
        }
        return clients;
    }

    public static void main(String[] args) throws SQLException {
        ClientService clientService = new ClientService(Database.getInstance().getConnection());
        System.out.println(clientService.create("egor"));
        System.out.println(clientService.getById(4));
        System.out.println(clientService.setName(10, "john"));
        System.out.println(clientService.deleteById(8));
        System.out.println(clientService.listAll());
    }
}
