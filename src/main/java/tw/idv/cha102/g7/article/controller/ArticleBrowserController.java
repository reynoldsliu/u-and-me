package tw.idv.cha102.g7.article.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tw.idv.cha102.g7.article.entity.Article;
import tw.idv.cha102.g7.article.service.ArticleBackEndService;
import tw.idv.cha102.g7.article.service.ArticleBrowserService;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleBrowserController {
    @Autowired
    private ArticleBrowserService articleBrowserService;
    @Autowired
    private ArticleBackEndService articleBackEndService;



    //首頁呈現所有未下架文章
    @GetMapping("/publicArticles")
    public List<Article> findPublicArticle(){
        return articleBrowserService.findPublicArticle();
    }

    // 透過文章標題搜尋相關文章
    @GetMapping("/articles/{title}")
    public List<Article> findByArticleTitle(@PathVariable String keyword) {
        return articleBrowserService.findByArticleTitle(keyword);
    }

    // 新增文章
    // 可以新增，但若資料庫中有相同id的行程，資料會被覆蓋過去


    // 刪除文章
    @DeleteMapping("/delete/{articleId}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer articleId) {
        try {
            articleBrowserService.deleteByArticleId(articleId);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }


}
