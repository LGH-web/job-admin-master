package com.gsupl.controller;

import com.github.pagehelper.PageInfo;
import com.gsupl.entity.Experience;
import com.gsupl.entity.Resume;
import com.gsupl.service.ExperienceService;
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
 * @Date 2022/11/14 15:36
 * @Version 1.0
 */
@RestController
@RequestMapping("/experience")
public class ExperienceController {

    @Autowired
    private ExperienceService experienceService;
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private UserDataService userDataService;

    @PostMapping("/create")
    public Result create(@RequestBody Experience experience) {
        int flag = experienceService.create(experience);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/delete")
    public Result delete(String ids) {
        int flag = experienceService.delete(ids);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/update")
    public Result update(@RequestBody Experience experience) {
        int flag = experienceService.update(experience);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/detail")
    public Result detail(Integer id) {
        return Result.success(experienceService.detail(id));
    }

    @PostMapping("/query")
    public Map<String, Object> query(@RequestBody Experience experience) {
        UserData user = userDataService.getUser();
        Resume resumeParam = resumeService.detail(user.getId());
        if(resumeParam == null) {
            return Result.success(new PageInfo<>());
        }
        experience.setResumeId(resumeParam.getId());
        PageInfo<Experience> pageInfo = experienceService.query(experience);
        pageInfo.getList().forEach(item -> {
            Resume resume = resumeService.detail(item.getResumeId());
            item.setResume(resume);
        });
        return Result.success(pageInfo);
    }

}
