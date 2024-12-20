package com.example.demo.article.response;

import com.example.demo.article.dto.ArticleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ArticleResponse {
    private final ArticleDTO article;
}