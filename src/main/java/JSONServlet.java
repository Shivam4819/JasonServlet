import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "JSONServlet",urlPatterns = {"/display"})
public class JSONServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       StringBuffer buffer=new StringBuffer();
       String line=null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                buffer.append(line);
            System.out.println("yooo");
            System.out.println(buffer.toString());
        } catch (Exception e) { /*report an error*/ }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        //object.put("name","shivam");
        //object.put("age",new Integer(22));
        //object.put("email","shivam4819@gmail.com");

       // System.out.println(object);
       // out.println(object);
    }
}
