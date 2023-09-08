package tw.idv.cha102.g7.article.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tw.idv.cha102.g7.article.entity.ArticlePicture;
import tw.idv.cha102.g7.article.entity.ArticlePosting;
import tw.idv.cha102.g7.article.service.ArticlePostingService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class ArticlePostingController {
    @Autowired
    private ArticlePostingService articlePostingService;

    // 新增文章
    @PostMapping("/post")

    public void insert(@RequestBody ArticlePosting article) {

        articlePostingService.postArticle(article);

    }


    // 新增文章的圖片
    @PostMapping("/post_pics")
    // void-->ResponseEntity<E>
    public void insert(@RequestParam("files") MultipartFile[] files) throws IOException {
        List<ArticlePicture> pics = new ArrayList<>();

        for (MultipartFile file : files) {
            ArticlePicture pic = new ArticlePicture();
            pic.setArticlePic(file.getBytes()); // 將 MultipartFile 轉換成 byte[]
            pics.add(pic);  // 存到pics陣列中
        }
        articlePostingService.postPicsAndSaveArticleId(pics);
    }

}
