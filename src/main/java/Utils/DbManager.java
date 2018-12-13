package Utils;

import Model.Klient;
import Model.Samochod;
import Model.Usterka;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.io.IOException;
import java.sql.SQLException;

public class DbManager {

    private static final String JDBC_Driver = "jdbc:sqlite:bazadanych.db";
    private static final Logger LOGGER = LoggerFactory.getLogger(DbManager.class);

    private static ConnectionSource connectSource;

    private static void createConnect() {
        try {
            connectSource = new JdbcConnectionSource(JDBC_Driver);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    public static ConnectionSource getConnectSource() {
        if (connectSource == null) {
            createConnect();
        }
        return connectSource;
    }

    private static void closeConnect() {
        if (connectSource != null) {
            try {
                connectSource.close();
            } catch (IOException e) {
                LOGGER.warn(e.getMessage());
            }
        }
    }

    private static void createTable() {
        try {
            TableUtils.createTableIfNotExists(connectSource, Klient.class);
            TableUtils.createTableIfNotExists(connectSource, Samochod.class);
            TableUtils.createTableIfNotExists(connectSource, Usterka.class);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    private static void dropTable() {
        try {
            TableUtils.dropTable(connectSource, Klient.class, true);
            TableUtils.dropTable(connectSource, Samochod.class, true);
            TableUtils.dropTable(connectSource, Usterka.class, true);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    public static void initDatabase() {
        createConnect();
        dropTable();
        createTable();
        closeConnect();
    }


}
