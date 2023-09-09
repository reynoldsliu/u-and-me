package tw.idv.cha102.g7.article.service;

import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.article.entity.ArticlePicture;
import tw.idv.cha102.g7.article.entity.ArticlePosting;

import java.util.List;

@Component
public interface ArticlePostingService {

    // 新增文章
    public void postArticle(ArticlePosting article);

    // 上傳圖片與取得articleId
    public void postPicsAndSaveArticleId(List<ArticlePicture> pics);

}

