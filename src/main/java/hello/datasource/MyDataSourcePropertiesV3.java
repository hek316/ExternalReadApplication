package hello.datasource;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import org.hibernate.validator.constraints.time.DurationMax;
import org.hibernate.validator.constraints.time.DurationMin;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.validation.annotation.Validated;

import java.time.Duration;
import java.util.List;

@Getter
@ConfigurationProperties("my.datasource")
@Validated
public class MyDataSourcePropertiesV3 {

    @NotEmpty
    private String url;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    private Etc etc;


    public MyDataSourcePropertiesV3(String url, String username, String
            password,  Etc etc) {
        System.out.println("MyDataSourcePropertiesV3 생성자 호출 불변객체 " + url + " , " + username);
        this.url = url;
        this.username = username;
        this.password = password;
        this.etc = etc;
    }

    @Getter
    public static class Etc {

        @Min(1) @Max(999)
        private int maxConnection;

        @DurationMin(seconds = 1)
        @DurationMax(seconds = 60)
        private Duration timeout;

        private List<String> options;

        public Etc(int maxConnection, Duration timeout, @DefaultValue("DEFAULT")
        List<String> options) {
            System.out.println("Etc 생성자 호출 불변객체 " + maxConnection + " , " + timeout);
            this.maxConnection = maxConnection;
            this.timeout = timeout;
            this.options = options;
        }
    }
}