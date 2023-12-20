package ppzxc.learning.controller;

import java.util.Objects;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ppzxc.learning.service.HelloService;

@RestController
public class HelloController {

  private final HelloService helloService;
  private final ApplicationContext applicationContext;

  public HelloController(HelloService helloService, ApplicationContext applicationContext) {
    this.helloService = helloService;
    this.applicationContext = applicationContext;
  }

  @GetMapping("/hello")
  @ResponseBody
  public String hello(String name) {
    return helloService.sayHello(Objects.requireNonNull(name));
  }
}
