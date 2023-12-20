package ppzxc.learning;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import ppzxc.learning.controller.HelloController;
import ppzxc.learning.service.SimpleHelloService;

public class LearningTobysSpringBootApplication {

  public static void main(String[] args) {
    // Spring ApplicationContext
    GenericWebApplicationContext applicationContext = new GenericWebApplicationContext();
    applicationContext.registerBean(SimpleHelloService.class);
    applicationContext.registerBean(HelloController.class);
    applicationContext.refresh();

    // Servlet Container
    TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
    WebServer webServer = serverFactory.getWebServer(
      servletContext -> servletContext.addServlet("dispatcherServlet", new DispatcherServlet(applicationContext))
        .addMapping("/*"));
    webServer.start();
  }
}
