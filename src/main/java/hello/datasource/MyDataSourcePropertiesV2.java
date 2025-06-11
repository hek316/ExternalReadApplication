package hello.datasource;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;
import java.time.Duration;
import java.util.List;

@Getter
@ConfigurationProperties("my.datasource")
public class MyDataSourcePropertiesV2 {
    private String url;
    private String username;
    private String password;
    private Etc etc;
    public MyDataSourcePropertiesV2(String url, String username, String
            password, @DefaultValue Etc etc) {
        System.out.println("MyDataSourcePropertiesV2 생성자 호출 불변객체" + url + " , " + username);
        this.url = url;
        this.username = username;
        this.password = password;
        this.etc = etc;
    }
    @Getter
    public static class Etc {

        private int maxConnection;
        private Duration timeout;
        private List<String> options;

        public Etc(int maxConnection, Duration timeout, @DefaultValue("DEFAULT")
        List<String> options) {
            System.out.println("Etc 생성자 호출 불변객체" + maxConnection + " , " + timeout);
            this.maxConnection = maxConnection;
            this.timeout = timeout;
            this.options = options;
        }
    }
}