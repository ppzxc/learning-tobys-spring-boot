package ppzxc.learning;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import ppzxc.learning.controller.HelloController;
import ppzxc.learning.service.HelloService;
import ppzxc.learning.service.SimpleHelloService;

@Configuration
public class LearningTobysSpringBootApplication {

  @Bean
  public HelloController helloController(HelloService helloService) {
    return new HelloController(helloService);
  }

  @Bean
  public HelloService helloService() {
    return new SimpleHelloService();
  }

  public static void main(String[] args) {
    AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
      @Override
      protected void onRefresh() {
        super.onRefresh();

        // Servlet Container
        TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        WebServer webServer = serverFactory.getWebServer(servletContext -> {
          servletContext.addServlet("dispatcherServlet", new DispatcherServlet(this)).addMapping("/*");
        });
        webServer.start();
      }
    };
    applicationContext.register(LearningTobysSpringBootApplication.class);
    applicationContext.refresh();
  }
}
