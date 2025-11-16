import java.sql.*;

class practice
{
    public static void main(String A[])
    {
        try
        {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection cobj = DriverManager.getConnection("jdbc:mysql://localhost/practice", "root", "");

            Statement sobj = cobj.createStatement();

            ResultSet robj = sobj.executeQuery("Select * From Student");

            System.out.println("-----------------------------------");

            while(robj.next())
            {
                // print
                System.out.println("Roll No : " + robj.getInt("Rno"));
                System.out.println("Name : " + robj.getString("Name"));
                System.out.println("City : " + robj.getString("City"));
                System.out.println("Marks : " + robj.getInt("Marks"));
                System.out.println("-----------------------------------");
            }

            robj.close();
            sobj.close();
            cobj.close();

        }
        catch(Exception eobj)
        {
            System.out.println("Exception is : " + eobj);
        }

    }
}