package share;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	CommandAction execute(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException;
}
