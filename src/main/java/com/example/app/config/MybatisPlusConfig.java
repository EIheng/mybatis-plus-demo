package com.example.app.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * @author 幕冬
 * @since 2022年01月21日
 */
@Slf4j
@Configuration
public class MybatisPlusConfig {

    public MybatisPlusConfig() {
        log.info("启用MyBatis-Plus自动填充处理器");
    }

    @Bean
    public MetaObjectHandler entityTimeFillHandler() {
        return new MetaObjectHandler() {
            @Override
            public void insertFill(MetaObject metaObject) {
                this.setFieldValByName("createTime", new Date(), metaObject);
                this.setFieldValByName("updateTime", new Date(), metaObject);
            }

            @Override
            public void updateFill(MetaObject metaObject) {
                this.setFieldValByName("updateTime", new Date(), metaObject);
            }
        };
    }
}
