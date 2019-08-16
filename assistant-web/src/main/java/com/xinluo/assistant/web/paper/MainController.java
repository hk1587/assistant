package com.xinluo.assistant.web.paper;

import com.xinluo.assistant.common.annotation.Authentication;
import com.xinluo.assistant.service.paper.PaperService;
import com.xinluo.assistant.web.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController extends BaseController {

    @Autowired
    PaperService paperService;


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/test")
    @ResponseBody
    @Authentication
    public Object test() {
        Integer count = paperService.getCount();
        logger.info("桃李春风一杯酒,江湖夜雨十年灯");
        logger.error("仰天大笑出门去,我辈岂是蓬蒿人");
        logger.error("出师未捷身先死,长使英雄泪满襟");
        return  "苟利国家生死以，岂因祸福避趋之";
    }

   }
