package pl.umcs.oop.database;
import java.util.HashMap;
import java.util.Map;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    static private final Map<String, Connection> connections = new HashMap<>();

    static public Connection getConnection() {
        return getConnection("");
    }

    static public Connection getConnection(String name) {
        return connections.get(name);
    }

    static public void connect(String filePath) {
        connect(filePath, "");
    }

    static public void connect(String filePath, String connectionName){
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + filePath);
            connections.put(connectionName, connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static public void disconnect() {
        disconnect("");
    }

    static public void disconnect(String connectionName){
        try {
            Connection connection = connections.get(connectionName);
            connection.close();
            connections.remove(connectionName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

