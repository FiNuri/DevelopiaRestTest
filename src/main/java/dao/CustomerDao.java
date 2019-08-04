package dao;

import com.example.developia.model.Сustomer;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerDao {

    private HikariDataSource connectionPool;
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private List<Map<String,String>> customerList;

    public CustomerDao(HikariDataSource connectionPool) {

        this.connectionPool = connectionPool;

    }

    public List<Map<String,String>> getAllCustomers() {
        try {
            customerList = new ArrayList<>();
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement("SELECT * FROM customers");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Сustomer cust = new Сustomer();
                cust.setAddress(resultSet.getString("address"));
                cust.setName(resultSet.getString("name"));
                cust.seteMail(resultSet.getString("email"));
                cust.setNumber(resultSet.getLong("number"));

                System.out.println(resultSet.getString("address"));
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getString("email"));
                System.out.println(resultSet.getLong("number"));

                customerList.add(new HashMap<String, String>(){{put("address", cust.getAddress());
                    put("name", cust.getName());
                    put("email", cust.geteMail());
                    put("number", cust.getNumber().toString());}});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }
}