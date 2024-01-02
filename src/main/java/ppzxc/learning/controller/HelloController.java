package ppzxc.learning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ppzxc.learning.service.HelloService;

@RestController
public class HelloController {

  private final HelloService helloService;

  public HelloController(HelloService helloService) {
    this.helloService = helloService;
  }

  @GetMapping("/hello")
  @ResponseBody
  public String hello(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException();
    }
    return helloService.sayHello(name);
  }
}
