package com.goit.pshcherba.service;

import com.goit.pshcherba.config.Database;
import com.goit.pshcherba.entity.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 1000;

    public static void main(String[] args) {
        ClientService clientService = new ClientService();

        // Create
        try {
            System.out.println(clientService.create("Viktor"));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        // Get by id:
        System.out.println(clientService.getById(5));

        // Set name:
        try {
            clientService.setName(10, "Oksana");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        // Delete by id:
        clientService.deleteById(9);

        // List all:
        clientService.listAll().forEach(System.out::println);
    }

    public long create(String name) throws IllegalArgumentException {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("The size of the name must be at least " + MIN_NAME_LENGTH + " and not more than " + MAX_NAME_LENGTH + ".");
        }

        String sql = "INSERT INTO megasoft.client(name) VALUES(?)";

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, name);
            statement.executeUpdate();
            return getGeneratedKey(statement);
        } catch (SQLException e) {
            System.err.println("Error while creating client: " + e.getMessage());
            return -1;
        }
    }

    public String getById(long id) {
        String name = null;
        String sql = "SELECT с.name FROM megasoft.client с WHERE с.id = ?";

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                name = resultSet.getString(1);
            } else {
                System.err.println("ID not found.");
            }

        } catch (SQLException e) {
            System.err.println("Error while fetching client by ID: " + e.getMessage());
        }

        return name;
    }

    public void setName(long id, String name) throws IllegalArgumentException {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("The size of the name must be at least " + MIN_NAME_LENGTH + " and not more than " + MAX_NAME_LENGTH + ".");
        }

        String sql = "UPDATE megasoft.client c SET c.name = ? WHERE c.id = ?";

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setLong(2, id);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                System.err.println("Client with ID " + id + " not found.");
            }

        } catch (SQLException e) {
            System.err.println("Error while updating client name: " + e.getMessage());
        }
    }

    public void deleteById(long id) {

        String sql = "DELETE FROM megasoft.client WHERE megasoft.client.id = ?";
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                System.err.println("Client with ID " + id + " not found.");
            }
        } catch (SQLException e) {
            System.err.println("Error while deleting client: " + e.getMessage());
        }
    }

    public List<Client> listAll() {
        String sql = "SELECT * FROM megasoft.client";
        List<Client> clients = new ArrayList<>();

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                clients.add(new Client(
                        resultSet.getInt(1),
                        resultSet.getString(2)));
            }

        } catch (SQLException e) {
            System.err.println("Error while listing clients: " + e.getMessage());
        }

        return clients;
    }

    private long getGeneratedKey(PreparedStatement preparedStatement) {
        long generatedId = -1;
        try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                generatedId = generatedKeys.getInt(1);
            } else {
                System.err.println("Creating client failed, no ID obtained.");
            }
        } catch (SQLException e) {
            System.err.println("Error while retrieving generated key: " + e.getMessage());
        }

        return generatedId;
    }
}
