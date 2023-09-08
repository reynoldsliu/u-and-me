package tw.idv.cha102.g7.article.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tw.idv.cha102.g7.article.entity.Article;
import tw.idv.cha102.g7.article.entity.ArticleComment;
import tw.idv.cha102.g7.article.entity.ArticlePicture;
import tw.idv.cha102.g7.article.service.ArticleSingleArticleService;

import java.util.List;

@RestController
@RequestMapping("/article_comment")
@CrossOrigin
public class ArticleCommentController {
    @Autowired
    ArticleSingleArticleService articleSingleArticleService;

    //文章詳情呈現該articleId所有 留言
    @GetMapping("/{articleId}")
    public List<ArticleComment> findAllByArticleId(@PathVariable Integer articleId) {
        return articleSingleArticleService.findAllByArticleId(articleId);
    }

    //文章詳情頁面新增留言
    @PostMapping("/post/{articleId}")
    public Integer insert(@RequestBody ArticleComment comment,
                       @PathVariable Integer articleId) {
        articleSingleArticleService.postComment(comment, articleId);
        return articleId;
    }

    //文章詳情呈現特定articleId 文章
    @GetMapping("/articleId/{articleId}")
    public Article getByArticleId(@PathVariable Integer articleId){
        return articleSingleArticleService.getByArticleId(articleId);
    }

    //文章詳情呈現特定articleId 圖片
    @GetMapping("/articleId/article_pic/{articleId}")
    public List<ArticlePicture> postArticle(@PathVariable Integer articleId){
        return articleSingleArticleService.findPicByArticleId(articleId);
    }
}