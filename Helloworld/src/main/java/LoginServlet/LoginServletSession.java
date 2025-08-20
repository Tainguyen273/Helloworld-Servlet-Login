package LoginServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = ("/LoginS"))
public class LoginServletSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String pass = request.getParameter("password");

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		if ("phuoctai".equals(username) && "123".equals(pass)) {
			HttpSession session = request.getSession();
			session.setAttribute("name", username);
			response.sendRedirect("Profile");
		} else {
			out.print("<p style='color:red;'>Tài khoản hoặc mật khẩu không chính xác</p>");
			out.print("<a href='loginSession.html'>Quay lại</a>");
		}
	}
}