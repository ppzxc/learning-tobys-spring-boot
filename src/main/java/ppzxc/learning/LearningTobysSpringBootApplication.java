package ppzxc.learning;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;

public class LearningTobysSpringBootApplication {

  public static void main(String[] args) {
    TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
    WebServer webServer = serverFactory.getWebServer(servletContext -> {
      servletContext.addServlet("hello", new HttpServlet() {
        @Override
        protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          resp.setStatus(200);
          resp.setHeader("Content-Type", "text/plain");
          resp.getWriter().print("Hello Servlet");
        }
      }).addMapping("/hello");
    });
    webServer.start();
  }
}
