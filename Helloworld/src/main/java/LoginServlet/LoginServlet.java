package LoginServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String user = request.getParameter("username");
		String pass = request.getParameter("password");

		if ("phuoctai".equals(user) && "123".equals(pass)) {
			Cookie cookie = new Cookie("username", user);
			cookie.setMaxAge(30);
			response.addCookie(cookie);
			response.sendRedirect("hello");
		} else {
			response.sendRedirect("Helloworld/login");
		}
	}
}
