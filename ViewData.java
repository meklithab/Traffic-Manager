import java.sql.*;

public class ViewData {
    public static void main(String[] args) {
        try {
            // Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/try1", "root", "");
            Statement stmnt = conn.createStatement();

            // stmnt.executeUpdate("Create table myguest(name varchar(100), num int , date
            // date)");

            // System.out.println("Table created!");
            stmnt.executeUpdate("Delete from myguest where name='Rose'");

            stmnt.executeUpdate("INSERT INTO myguest (name, num, date) VALUES ('Maya',567, '2011-09-09')");
            stmnt.executeUpdate("INSERT INTO myguest (name, num, date) VALUES ('Tatiana',6878, '2022-09-09')");

            ResultSet result = stmnt.executeQuery("Select * from myguest");

            while (result.next()) {
                System.out
                        .println("Name:" + result.getString(1) + " ID:" + result.getString(2) + "Date:"
                                + result.getString(3));
            }

            PreparedStatement p = conn.prepareStatement("Insert into myguest (name,num,date) values(?,?,?)");
            p.setString(1, "Rose");
            p.setInt(2, 0);
            p.setString(3, "2019-09-05");
            p.executeUpdate();

            PreparedStatement p2 = conn.prepareStatement("Select * from myguest where name=? and num=?");
            p2.setString(1, "Rose");
            p2.setInt(2, 0);

            ResultSet result2 = p2.executeQuery();
            if (result2.next()) {
                System.out.println(result2.getString("name") + " " + result2.getString("num"));

            }

            Statement s3 = conn.createStatement();
            s3.executeUpdate("Delete from myguest where name='Maya'");
            s3.executeUpdate("Insert into myguest (name,num,date) values ('jama',90,'2013-05-05')");

            ResultSet r = stmnt.executeQuery("Select name from myguest where name = 'jama'");

            if (r.next()) {
                System.out.println(r.getString(1));
            }

            DatabaseMetaData db = conn.getMetaData();
            System.out.println(db.getURL());
            System.out.println(db.getUserName());
            System.out.println(db.getConnection());
            System.out.println(db.getMaxConnections());

            System.out.println(db.getDriverName());
            System.out.println(db.getDriverVersion());
            System.out.println(db.getDriverMajorVersion());
            System.out.println(db.getDriverMinorVersion());

            System.out.println(db.getDatabaseProductName());
            System.out.println(db.getDatabaseProductVersion());
            System.out.println(db.getDatabaseMajorVersion());
            System.out.println(db.getDatabaseMinorVersion());
                                                                                                                                                                                                 
            System.out.println(db.getMaxTableNameLength());
            System.out.println(db.getMaxColumnNameLength());

            ResultSet rr = db.getTables(null, null, null, new String[] { "TABLE" });
            while (rr.next()) {
                System.out.println(rr.getString("TABLE_NAME"));

            }

            ResultSet rs = stmnt.executeQuery("SELECT * FROM MYGUEST");
            ResultSetMetaData rmeta = rs.getMetaData();

            for (int i = 1; i <= rmeta.getColumnCount(); i++) {
                System.out.printf("%-12s\t", rmeta.getColumnName(i));
                System.out.println();
            }
            // Iterate through the result and print the students' names
            while (rs.next()) {
                for (int i = 1; i <= rmeta.getColumnCount(); i++) {
                    System.out.printf("%-12s\t", rs.getObject(i));
                    System.out.println();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}