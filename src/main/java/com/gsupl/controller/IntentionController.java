package com.gsupl.controller;

import com.github.pagehelper.PageInfo;
import com.gsupl.entity.Intention;
import com.gsupl.entity.Resume;
import com.gsupl.service.IntentionService;
import com.gsupl.service.ResumeService;
import com.gsupl.service.UserDataService;
import com.gsupl.utils.Result;
import com.gsupl.vo.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author LGH
 * @Date 2022/11/14 15:53
 * @Version 1.0
 */
@RestController
@RequestMapping("/intention")
public class IntentionController {
    @Autowired
    private IntentionService intentionService;
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private UserDataService userDataService;

    @PostMapping("/create")
    public Result create(@RequestBody Intention intention) {
        int flag = intentionService.create(intention);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/delete")
    public Result delete(String ids) {
        int flag = intentionService.delete(ids);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/update")
    public Result update(@RequestBody Intention intention) {
        int flag = intentionService.update(intention);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/detail")
    public Result detail(Integer id) {
        return Result.success(intentionService.detail(id));
    }

    @PostMapping("/query")
    public Map<String, Object> query(@RequestBody Intention intention) {
        UserData user = userDataService.getUser();
        Resume resumeParam = resumeService.detail(user.getId());
        if(resumeParam == null) {
            return Result.success(new PageInfo<>());
        }
        intention.setResumeId(resumeParam.getId());
        PageInfo<Intention> pageInfo = intentionService.query(intention);
        pageInfo.getList().forEach(item -> {
            Resume resume = resumeService.detail(item.getResumeId());
            item.setResume(resume);
        });
        return Result.success(pageInfo);
    }


}
