package config;

import org.minig.config.ServiceConfig;
import org.minig.server.service.impl.MailContext;
import org.minig.server.service.impl.SimpleMailContextImpl;
import org.minig.server.service.submission.TestJavaMailSenderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.ConversionServiceFactoryBean;

@Configuration
@ComponentScan(basePackages = "org.minig.server.service")
@Profile({ "test" })
public class ServiceTestConfig {

    @Bean(name = "mailContext")
    public MailContext mailContext() {
        return new SimpleMailContextImpl();
    }

    @Bean(name = "javaMailSenderFactory")
    public TestJavaMailSenderFactory javaMailSenderFactory() {
        return new TestJavaMailSenderFactory();
    }

    @Bean
    public ConversionServiceFactoryBean conversionService() {
        return new ServiceConfig().conversionService();
    }
}
