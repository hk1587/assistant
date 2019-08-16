package com.xinluo.assistant.jpa.paper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

/**
 * @author : ChengJing
 * @description :
 * @date: Created in 下午2:58 2018/11/6
 */
@Repository
public interface PaperDao {

    Integer getCount();
}
