package hello.datasource;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.List;

@Slf4j
@Data
public class MyDataSource {
    private String url;
    private String username;
    private String password;
    private int maxConnections;

    public MyDataSource(String url, String username, String password, int maxConnections, Duration timeout, List<String> options) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.maxConnections = maxConnections;
        this.timeout = timeout;
        this.options = options;
    }

    private Duration timeout;

    private List<String> options;

    // PostConstruct 메서드는 해당 빈이 실제로 생성되어 초기화 될 때만 호출됨
    // 빈이 스프링 컨테이너에 의해 생성되고, 의존성 주입이 완료된 후 실행됨. 사용되지 않아 컨테이너가 빈을 생성하지 않으면 해당 메서드는 호출 X
    @PostConstruct
    public void init() {
        log.info("url: {}", url);
        log.info("username: {}", username);
        log.info("password: {}", password);
        log.info("maxConnections: {}", maxConnections);
        log.info("timeout: {}", timeout);
        log.info("options: {}", options);

    }


}
