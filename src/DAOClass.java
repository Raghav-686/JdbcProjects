import java.sql.*;
import java.util.Scanner;

public class DAOClass
{
    Connection con = null;
    PreparedStatement ps = null;
    Scanner sc=new Scanner(System.in);

    DAOClass() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
    }
    public void insert() throws SQLException
    {
        ps = con.prepareStatement("insert into detail values (?,?,?,?)");
        System.out.println("Enter the name:");
        ps.setString(1,sc.nextLine());
        System.out.println("Enter the age");
        sc.nextLine();
        ps.setInt(2,sc.nextInt());
        System.out.println("Enter the fess");
        ps.setInt(3,sc.nextInt());
        System.out.println("Enter the rollno");
        ps.setInt(4,sc.nextInt());
        ps.executeUpdate();
        System.out.println("inserted Successfully");
    }
    public  void delete() throws SQLException
    {
        ps = con.prepareStatement("DELETE from detail where rollno = ?");
        System.out.println("input the rollno you want to delete");
        ps.setInt(1,sc.nextInt());
        ps.executeUpdate();
        System.out.println("Deleted Successfully");
    }
    public void modify() throws SQLException
    {
        ps = con.prepareStatement("update detail set fess = ?  where rollno = ?");
        System.out.println("Enter the rollno");
            ps.setInt(2,sc.nextInt());
        System.out.println("Enter the fees");
            ps.setInt(1,sc.nextInt());
            ps.executeUpdate();
        System.out.println("Modify Successfully");
    }

    public void display() throws SQLException, ClassNotFoundException
    {
        //Statement s=con.createStatement();
        ps = con.prepareStatement("select * from detail");
        ResultSet rs = ps.executeQuery();
        while (rs.next())
        {
            System.out.println(rs.getString(1));
            System.out.println(rs.getInt(2));
            System.out.println(rs.getInt(3));
            System.out.println(rs.getInt(4));
        }
    }
        public void display(int rollno) throws SQLException
        {
            ps=con.prepareStatement("select * from detail where rollno=?");
            System.out.println("Enter the rollno you want to display");
            ps.setInt(1,sc.nextInt());
            ResultSet rs=ps.executeQuery();
            while (rs.next())
            {
                System.out.println(rs.getString(1));
                System.out.println(rs.getInt(2));
                System.out.println(rs.getInt(3));
                System.out.println(rs.getInt(4));
            }
        }

    public static void main(String[] args) throws SQLException, ClassNotFoundException
    {
        DAOClass d1 = new DAOClass();
        Scanner sc=new Scanner(System.in);
        System.out.println("press 1 to insert");
        System.out.println("press 2 to delete");
        System.out.println("press 3 to modify");
        System.out.println("press 4 to display full details");
        System.out.println("press 5 to display the detail of particular student by enter rollno");
        System.out.println("press 6 to exit");
        int n=sc.nextInt();
        while(n!=6)
        {
           if(n==1)
           {
               d1.insert();
           }
           else if(n==2)
           {
               d1.delete();
           }
           else if(n==3)
           {
               d1.modify();
           }
           else if(n==4)
           {
               d1.display();
           }
           else if(n==5)
           {
               d1.display(sc.nextInt());
           }
           else if(n==6)
           {
               System.exit(0);
           }
           else
           {
               System.out.println("enter valid number");
           }
            System.out.println("press 1 to insert");
            System.out.println("press 2 to delete");
            System.out.println("press 3 to modify");
            System.out.println("press 4 to display full details");
            System.out.println("press 5 to display the detail of particular student by enter rollno");
            System.out.println("press 6 to exit");
             n=sc.nextInt();
        }
    }
}
