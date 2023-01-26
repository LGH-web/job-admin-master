package com.gsupl.front;

import com.github.pagehelper.PageInfo;
import com.gsupl.entity.Article;
import com.gsupl.service.ArticleService;
import com.gsupl.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author LGH
 * @Date 2022/11/14 16:21
 * @Version 1.0
 */
@RestController
@RequestMapping("/f/article")
public class ArticleFrontController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/detail")
    public Result detail(Integer id) {
        //每点击一次浏览量加一（每调用一次方法，浏览量加一）
        Double views = redisTemplate.opsForZSet().incrementScore("views", id, 1);
        Article article = articleService.detail(id);
        if(views != null) {
            article.setViews(views.intValue());
        } else {
            article.setViews(0);
        }
        return Result.success(article);
    }

    @PostMapping("/query")
    public Map<String, Object> query(@RequestBody Article article) {
        PageInfo<Article> pageInfo = articleService.getArticlesByChannelId(article);
        return Result.success(pageInfo);
    }
}
