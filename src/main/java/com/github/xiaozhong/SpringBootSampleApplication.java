package com.github.xiaozhong;

import com.github.xiaozhong.msg.Producer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringBootSampleApplication {

    private static final Log logger = LogFactory.getLog(SpringBootSampleApplication.class);

	public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Producer.class);
        context.refresh();
        Producer producer = context.getBean(Producer.class);
        while (true) {
            try {
                producer.sendMessage("{\"userAddress\":\"china, shanghai\",\"userName\":\"my name\",\"userPhone\":\"1234567\"}");
            } catch (Exception e) {
                logger.error("send message error", e);
            }
        }

    }

}
