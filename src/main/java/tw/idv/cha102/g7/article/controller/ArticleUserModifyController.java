package tw.idv.cha102.g7.article.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tw.idv.cha102.g7.article.entity.Article;
import tw.idv.cha102.g7.article.service.ArticleUpdateService;
import tw.idv.cha102.g7.schedule.controller.exception.ScheduleNotFoundException;

@RestController
//@RequestMapping("/Article")
public class ArticleUserModifyController {
    @Autowired
    ArticleUpdateService articleUpdateService;

    // 依據使用者輸入的ID搜尋文章，在更新文章
    @PutMapping("/Useredit/{articleId}")
    public ResponseEntity<?> edit(@PathVariable Integer articleId,
                                  @RequestBody Article updArticle){
        try {
            articleUpdateService.userEdit(articleId,updArticle);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ScheduleNotFoundException(articleId));
        }

    }


}
