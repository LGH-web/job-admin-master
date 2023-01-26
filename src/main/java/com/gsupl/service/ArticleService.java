package com.gsupl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gsupl.entity.Article;
import com.gsupl.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @Author LGH
 * @Date 2022/11/14 14:54
 * @Version 1.0
 */
@Service
public class ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    public int create(Article article) {
        return articleMapper.create(article);
    }

    public int delete(String ids) {
        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if (!StringUtils.isEmpty(s)) {
                articleMapper.delete(Integer.parseInt(s));
                row++;
            }
        }
        return row;
    }

    public int delete(Integer id) {
        return articleMapper.delete(id);
    }

    public int update(Article article) {
        return articleMapper.update(article);
    }

    public PageInfo<Article> query(Article article) {
        if (article != null && article.getPage() != null) {
            PageHelper.startPage(article.getPage(), article.getLimit());
        }
        return new PageInfo<>(articleMapper.query(article));
    }

    public Article detail(Integer id) {
        return articleMapper.detail(id);
    }

    public int count(Article article) {
        return articleMapper.count(article);
    }

    public PageInfo<Article> getArticlesByChannelId(Article article) {
        if (article != null && article.getPage() != null) {
            PageHelper.startPage(article.getPage(), article.getLimit());
        }
        return new PageInfo<>(articleMapper.getArticlesByChannelId(article.getChannelId()));
    }

}
