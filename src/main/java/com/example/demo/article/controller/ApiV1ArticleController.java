package com.example.demo.article.controller;

import com.example.demo.article.dto.ArticleDTO;
import com.example.demo.article.entity.Article;
import com.example.demo.article.service.ArticleService;
import com.example.demo.global.rsData.RsData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/articles")
@RequiredArgsConstructor
public class ApiV1ArticleController {
    private final ArticleService articleService;

    @AllArgsConstructor
    @Getter
    public static class ArticlesResponse {
        private final List<ArticleDTO> articleList;
    }

    @GetMapping("")
    public RsData<ArticlesResponse> list() {
        List<ArticleDTO> articleList = new ArrayList<>();

        Article article1 = new Article("제목 1", "내용 1");
        articleList.add(new ArticleDTO(article1));

        Article article2 = new Article("제목 2", "내용 2");
        articleList.add(new ArticleDTO(article2));

        Article article3 = new Article("제목 3", "내용 3");
        articleList.add(new ArticleDTO(article3));

        return RsData.of("200", "게시글 다건 조회 성공", new ArticlesResponse(articleList));
    }

    @Getter
    @AllArgsConstructor
    public static class ArticleResponse {
        private  final ArticleDTO article;
    }

    @GetMapping("/{id}")
    public RsData<ArticleResponse> getArticle(@PathVariable("id") Long id) {
        Article article = new Article("제목 1", "내용 1");

        ArticleDTO articleDTO = new ArticleDTO(article);

        return RsData.of("200", "게시글 단건 조회 성공", new ArticleResponse(articleDTO));
    }

    @PostMapping("")
    public String create(@RequestParam("subject") String subject,
                         @RequestParam("content") String content) {
        System.out.println(subject);
        System.out.println(content);

        return "생성";
    }

    @PatchMapping("/{id}")
    public String modify(@PathVariable("id") Long id, @RequestParam("subject") String subject,
                         @RequestParam("content") String content) {
        System.out.println(id);
        System.out.println(subject);
        System.out.println(content);
        return "수정";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        System.out.println(id);
        return "삭제";
    }
}
