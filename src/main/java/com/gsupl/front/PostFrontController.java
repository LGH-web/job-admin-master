package com.gsupl.front;

import com.github.pagehelper.PageInfo;
import com.gsupl.service.PostService;
import com.gsupl.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author LGH
 * @Date 2022/11/14 16:30
 * @Version 1.0
 */
@RestController
@RequestMapping("/f/post")
public class PostFrontController {
    @Autowired
    private PostService postService;

    @PostMapping("/query")
    public Map<String,Object> getPostList(@RequestBody Map<String,Object> map) {
        PageInfo<Map<String, Object>> postList = postService.getPostList(map);
        return Result.success(postList);
    }

}
