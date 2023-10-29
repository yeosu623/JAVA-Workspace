package KimYeongHan.SpringLecture2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)) // Annotation 중에 Configuration 을 제외한다.
public class AutoAppConfig {


}
