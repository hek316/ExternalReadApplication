package hello.datasource;

import hello.config.MyDataSourceConfigV1;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@ConfigurationProperties("my.datasource")
public class MyDataSourcePropertiesV1 {

    private String url;
    private String username;
    private String password;
    private Etc etc = new Etc();

    public MyDataSourcePropertiesV1() {
        System.out.println("MyDataSourceConfigV1 생성자 호출");
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        System.out.println("setUrl 호출 " + url);
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        System.out.println("setUsername 호출 " + username);
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        System.out.println("password 호출 " + password);
        this.password = password;
    }

    public Etc getEtc() {
        return etc;
    }

    public void setEtc(Etc etc) {
        this.etc = etc;
    }


    public static class Etc {
        private int maxConnection;
        private Duration timeout;
        private List<String> options = new ArrayList<>();

        public Etc() {
            System.out.println("Etc 생성자 호출");
        }

        public int getMaxConnection() {
            return maxConnection;
        }

        public void setMaxConnection(int maxConnection) {
            System.out.println("setMaxConnection " + maxConnection);
            this.maxConnection = maxConnection;
        }

        public Duration getTimeout() {
            return timeout;
        }

        public void setTimeout(Duration timeout) {
            System.out.println("setTimeout  " + timeout);
            this.timeout = timeout;
        }

        public List<String> getOptions() {
            return options;
        }

        public void setOptions(List<String> options) {
            System.out.println("setOptions  " + options);
            this.options = options;
        }
    }
}
