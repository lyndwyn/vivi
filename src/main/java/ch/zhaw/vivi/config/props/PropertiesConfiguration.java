package ch.zhaw.vivi.config.props;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.io.IOException;
import java.util.Properties;

@Configuration
public class PropertiesConfiguration {

    @Bean
    public Properties jwtProperties() throws IOException {
        var props = new Properties();
        props.load(getClass().getResourceAsStream("/jwt.properties"));
        return props;
    }

    @Primary
    @Bean
    public Properties applicationProperties() throws IOException {
        var props = new Properties();
        props.load(getClass().getResourceAsStream("/application.properties"));
        return props;
    }

}
