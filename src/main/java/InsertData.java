import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class InsertData extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException
    {
        try {
            // Initialize the database
            Connection con = ConnectionConfig.getConnection();
            PreparedStatement st = con.prepareStatement("insert into KontoData values(?, ?, ?)");
            st.setString(1, request.getParameter("KontoNavn"));
            st.setString(2, request.getParameter("KontoKode"));
            st.setString(3, request.getParameter("KontoKode"));

            st.executeUpdate();

            st.close();
            con.close();

            PrintWriter out = response.getWriter();
            out.println("<html><body><b>Successfully Inserted"
                    + "</b></body></html>");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}