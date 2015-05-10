package kr.ac.shinhan.cs;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowUser extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		Cookie[] cookieList = req.getCookies();

		for (Cookie c : cookieList) {

			if (c.getName().equals("loged_in_id"))

			{

				String id = c.getValue();

				System.out.println("Hello " + id);

			}

		}

		

	}
}
