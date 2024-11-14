import java.util.*;
import java.sql.*;

class ConnectionDB{
    private static String url = "jdbc:mysql://localhost:3306/busreservation";
    private static String user = "root";
    private static String pass = "root1root2";
    public static Connection myConnection() throws SQLException{
        return DriverManager.getConnection(url,user,pass);
    }
}

class BusDao{
    public static void display() throws SQLException{
        Connection con = ConnectionDB.myConnection();
        String query = "select * from bus";
        Statement st = con.createStatement();
        ResultSet rst = st.executeQuery(query);
        while(rst.next())
        {
            System.out.println("BusNo is: "+rst.getInt(1));
            System.out.println("Capacity is: "+rst.getInt(2));
            System.out.println("Ac is: "+rst.getInt(3));
        }
    }
    public static int getCapacity(int busno) throws SQLException{
        Connection con = ConnectionDB.myConnection();
        String query = "select capacity from bus where busno = ?;";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1,busno);
        ResultSet rst = pst.executeQuery();
        if(rst.next())
        {
            return rst.getInt(1);
        }
        else{
            throw new SQLException("No bus found with busno "+busno);
        }
    }
    public static void updateCapacity(int busno, int capacity) throws SQLException{
        Connection con = ConnectionDB.myConnection();
        String query = "update bus set capacity = ? where busno = ?;";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1,capacity);
        pst.setInt(2,busno);
        int row = pst.executeUpdate();
        System.out.println("No of rows affected "+row);
    }
}

class BookingDao{
    public static void display() throws SQLException{
        Connection con = ConnectionDB.myConnection();
        String query = "select * from booking";
        Statement st = con.createStatement();
        ResultSet rst = st.executeQuery(query);
        while(rst.next())
        {
            System.out.println("Bus No: "+rst.getInt(1));
            System.out.println("Name is: "+rst.getString(2));
            System.out.println("Seats are :"+rst.getInt(3));

        }
    }

    public static void book(int busno,String name, int seats) throws SQLException
    {
        Connection con = ConnectionDB.myConnection();
        String query = "insert into booking values(?,?,?);";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1,busno);
        pst.setString(2, name);
        pst.setInt(3,seats);
        int row = pst.executeUpdate();
        System.out.println("No of rows affected "+ row);
    }

    public static boolean remove(String name) throws SQLException{
        Connection con = ConnectionDB.myConnection();
        String query = "delete from booking where name = ?;";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1,name);
        int row = pst.executeUpdate();
        System.out.println("No of rows affected "+row);
        return row>0;
    }

    public static int getbusno(String name) throws SQLException{
        Connection con = ConnectionDB.myConnection();
        String query = "select busno from booking where name = ?;";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1,name);
        ResultSet rst = pst.executeQuery();
        if(rst.next())
        {
            return rst.getInt(1);
        }
        else{
            throw new SQLException("No booking for that name "+name);
        }
    }

    public static int getseats(String name) throws SQLException{
        Connection con = ConnectionDB.myConnection();
        String query = "select seats from booking where name = ?;";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1,name);
        ResultSet rst = pst.executeQuery();
        if(rst.next())
        {
            return rst.getInt(1);
        }
        else{
            throw new SQLException("No booking for that name "+name);
        }
    }
}
class Booking{
    static int busno;
    static String name;
    static int seats;
    Scanner sc = new Scanner(System.in);
    Booking()
    {
        System.out.println("Enter the busno: ");
        busno = sc.nextInt();
        System.out.println("Enter the name: ");
        name = sc.next();
        System.out.println("Enter the seats: ");
        seats = sc.nextInt();
    }
    public static boolean isAvailable() throws SQLException{
        int currentcapacity = BusDao.getCapacity(busno);
        if(seats<=currentcapacity)
        {
            BusDao.updateCapacity(busno, currentcapacity-seats);
            BookingDao.book(busno,name,seats);
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean cancel(String name) throws SQLException{
        int seats = BookingDao.getseats(name);
        int busno = BookingDao.getbusno(name);
        BusDao.updateCapacity(busno, BusDao.getCapacity(busno)+seats);
        return BookingDao.remove(name);
    }
}
class Main{
    public static void main(String[]args) throws SQLException
    {
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            BusDao.display();
            System.out.println("Enter your choice");
            System.out.println("1---- Book");
            System.out.println("2---- Cancel");
            System.out.println("3---- Show bookings");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice)
            {
                case 1:
                    Booking b = new Booking();
                    if(b.isAvailable())
                    {
                        System.out.println("Booked");
                    }
                    else{
                        System.out.println("No seats available or invalid bus number");
                    }
                    break;

                case 2:
                    System.out.println("Enter the name to cancel");
                    String name = sc.nextLine();
                    if(Booking.cancel(name))
                    {
                        System.out.println("Cancelled");
                    }
                    else{
                        System.out.println("Cancellation failed");
                    }
                    break;

                case 3:
                    BookingDao.display();
                    break;

                default:
                    System.out.println("Invalid choice try again");
            }
        }
    }
}
