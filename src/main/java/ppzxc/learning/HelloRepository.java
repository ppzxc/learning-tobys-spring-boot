package ppzxc.learning;

public interface HelloRepository {

  Hello findHello(String name);

  void increase(String name);

  default int countOf(String name) {
    Hello hello = findHello(name);
    return hello == null ? 0 : hello.getCount();
  }
}
