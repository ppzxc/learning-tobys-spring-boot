package ppzxc.learning;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import ppzxc.learning.controller.HelloController;

public class LearningTobysSpringBootApplication {

  public static void main(String[] args) {
    // Spring ApplicationContext
    GenericApplicationContext applicationContext = new GenericApplicationContext();
    applicationContext.registerBean(HelloController.class);
    applicationContext.refresh();

    // Servlet Container
    TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
    WebServer webServer = serverFactory.getWebServer(
      servletContext -> servletContext.addServlet("frontcontroller", new HttpServlet() {
        @Override
        protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
          if (req.getRequestURI().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name())) {
            String name = req.getParameter("name");

            HelloController helloController = applicationContext.getBean(HelloController.class);
            String ret = helloController.hello(name);

            resp.setContentType(MediaType.TEXT_PLAIN_VALUE);
            resp.getWriter().print(ret);
          } else {
            resp.setStatus(HttpStatus.NOT_FOUND.value());
          }
        }
      }).addMapping("/*"));
    webServer.start();
  }
}
