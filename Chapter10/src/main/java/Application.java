import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.course")
public class Application {
    //固定写法,入口
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
