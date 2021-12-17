import java.sql.*;

public class Jdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","");
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("SELECT DISTINCT age FROM hello WHERE age < 40");
        while (rs.next()){
            System.out.println(rs.getInt(1));
        }
    }
}
