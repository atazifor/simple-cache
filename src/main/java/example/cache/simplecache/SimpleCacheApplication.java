package example.cache.simplecache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@EnableCaching
@SpringBootApplication
public class SimpleCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleCacheApplication.class, args);
    }

    @Bean
    public KeyGenerator multiplyKeyGenerator() {
        return (Object target, Method method, Object... params) -> {
            return Stream.of(target.getClass().getName(), method.getName(), Arrays.stream(params).toList())
                    .collect(Collectors.toList());
        };
    }
}
