package lsgwr.exam.initializer;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.util.CharsetUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements InitializingBean {

    @Autowired
    QuestionInitTest questionInitTest;
    @Autowired
    QuestionInitTest1 questionInitTest1;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void afterPropertiesSet() throws Exception {
        questionInitTest.name();
        questionInitTest1.name();

        ClassPathResource classPathResource = new ClassPathResource("init.sql");
        String readString = FileUtil.readString(classPathResource.getFile(), CharsetUtil.UTF_8);
        jdbcTemplate.execute(readString);
    }


}
