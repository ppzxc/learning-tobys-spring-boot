package ppzxc.configuration.auto;

import ppzxc.configuration.MyConfigurationProperties;

@MyConfigurationProperties(prefix = "server")
public class ServerProperties {

  private String contextPath = "";
  private int port = 8080;

  public String getContextPath() {
    return contextPath;
  }

  public void setContextPath(String contextPath) {
    this.contextPath = contextPath;
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }
}
