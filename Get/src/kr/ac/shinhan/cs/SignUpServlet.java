package kr.ac.shinhan.cs;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUpServlet extends HttpServlet {
   public void doPost(HttpServletRequest req, HttpServletResponse resp)
         throws IOException {
      resp.setCharacterEncoding("UTF-8");
      resp.setContentType("text/html");
      
      String id = req.getParameter("id");
      String userID = req.getParameter("userID");
      String name = req.getParameter("name");
      String password = req.getParameter("password");
      Long key = null;
      boolean check = false ;

      PersistenceManager pm = MyPersistenceManager.getManager();
      Query qry = pm.newQuery(UserAccount.class);
      List<UserAccount> userList = (List<UserAccount>) qry.execute();

      
      
      for (UserAccount u : userList) {
         
         if (id.equals(u.getUserID())) {
            
         check = true;
            
         
         }
         
         
         
         
      }
      
      if(check == true){
         resp.getWriter().println("<html>");
         resp.getWriter().println("<body>");
         resp.getWriter().println("<h1>" + "회원가입" + "<h1>");
         resp.getWriter().println("이미 존재하는 아이디 입니다.");
         resp.getWriter().println("<br>  <br>  <a href='login.html'>처음으로</a>"+"</br>");
         resp.getWriter().println("</body>");
         resp.getWriter().println("</html>");
      }

         else{
            UserAccount ua = new UserAccount(id, password, name, key);
            MyPersistenceManager.getManager().makePersistent(ua);
            
           

            resp.sendRedirect("login.html");
         }
         
   }

}