import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/testdb";
        String username = "postgres";
        String password = "admin";

        try {
            Connection connection = DriverManager.getConnection(url,username,password);

            String query = "INSERT INTO tutorials(id,description,published,title) VALUES(?,?,?,?)";
            String query2 = "SELECT * FROM tutorials";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            PreparedStatement preparedStatement1 = connection.prepareStatement(query2);

            preparedStatement.setInt(1,1);
            preparedStatement.setString(2,"NewItem");
            preparedStatement.setBoolean(3,true);
            preparedStatement.setString(4,"ExampleTitle");

//            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSet resultSet1 = preparedStatement1.executeQuery();

            while (resultSet1.next()){
                int id = resultSet1.getInt("id");
                String description = resultSet1.getString("description");

                System.out.println(id);
                System.out.println(description);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }


    }
}