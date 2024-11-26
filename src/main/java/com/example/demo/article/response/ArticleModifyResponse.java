package com.example.demo.article.response;

import com.example.demo.article.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ArticleModifyResponse {
    private final Article article;
}
