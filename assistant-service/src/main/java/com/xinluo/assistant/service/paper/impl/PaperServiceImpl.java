package com.xinluo.assistant.service.paper.impl;

import com.xinluo.assistant.jpa.paper.PaperDao;
import com.xinluo.assistant.service.paper.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : ChengJing
 * @description : 患者业务逻辑处理实现层
 * @date: Created in 下午2:54 2018/11/6
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PaperServiceImpl implements PaperService {


    @Autowired
    PaperDao paperDao;

    @Override
    public Integer getCount() {
        Integer count = paperDao.getCount();
        return  count;
    }
}
