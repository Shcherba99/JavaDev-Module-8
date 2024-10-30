package com.goit.pshcherba.service;

import com.goit.pshcherba.config.Database;
import com.goit.pshcherba.dto.*;
import com.goit.pshcherba.util.QueryLoader;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    public static void main(String[] args) {
        DatabaseQueryService queryService = new DatabaseQueryService();

        System.out.println("Longest projects: ");
        List<LongestProject> longestProjects = queryService.findLongestProjects();
        longestProjects.forEach(System.out::println);
        System.out.println();

        System.out.println("Max project count clients:");
        List<MaxProjectCountClient> maxProjectCountClients = queryService.findMaxProjectsClient();
        maxProjectCountClients.forEach(System.out::println);
        System.out.println();

        System.out.println("Max salary workers: ");
        List<MaxSalaryWorker> maxSalaryWorkers = queryService.findMaxSalaryWorkers();
        maxSalaryWorkers.forEach(System.out::println);
        System.out.println();

        System.out.println("Youngest & oldest workers: ");
        List<YoungestOldestWorker> youngestOldestWorkers = queryService.findYoungestOldestWorker();
        youngestOldestWorkers.forEach(System.out::println);
        System.out.println();

        System.out.println("Project prices: ");
        List<ProjectPrice> projectPrices = queryService.getProjectPrices();
        projectPrices.forEach(System.out::println);
        System.out.println();
    }


    public List<LongestProject> findLongestProjects() {
        List<LongestProject> projects = new ArrayList<>();
        String sql = QueryLoader.readSqlScript("./sql/find_longest_project.sql");

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                LongestProject longestProject = new LongestProject(
                        resultSet.getInt(1), resultSet.getInt(2));
                projects.add(longestProject);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return projects;
    }


    public List<MaxProjectCountClient> findMaxProjectsClient() {
        List<MaxProjectCountClient> clients = new ArrayList<>();
        String sql = QueryLoader.readSqlScript("./sql/find_max_projects_client.sql");

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                MaxProjectCountClient maxProjectCountClient = new MaxProjectCountClient(
                        resultSet.getString(1), resultSet.getInt(2));
                clients.add(maxProjectCountClient);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clients;
    }


    public List<MaxSalaryWorker> findMaxSalaryWorkers() {
        List<MaxSalaryWorker> workers = new ArrayList<>();
        String sql = QueryLoader.readSqlScript("./sql/find_max_salary_worker.sql");

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                MaxSalaryWorker worker = new MaxSalaryWorker(
                        resultSet.getString(1), resultSet.getInt(2));
                workers.add(worker);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return workers;
    }


    public List<YoungestOldestWorker> findYoungestOldestWorker() {
        List<YoungestOldestWorker> workers = new ArrayList<>();
        String sql = QueryLoader.readSqlScript("./sql/find_youngest_oldest_workers.sql");

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                YoungestOldestWorker worker = new YoungestOldestWorker(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getDate(3).toLocalDate());
                workers.add(worker);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return workers;
    }


    public List<ProjectPrice> getProjectPrices() {
        List<ProjectPrice> prices = new ArrayList<>();
        String sql = QueryLoader.readSqlScript("./sql/print_project_prices.sql");

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ProjectPrice price = new ProjectPrice(
                        resultSet.getInt(1), resultSet.getInt(2));
                prices.add(price);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return prices;
    }
}
