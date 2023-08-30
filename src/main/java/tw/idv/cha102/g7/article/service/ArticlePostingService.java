package tw.idv.cha102.g7.article.service;

import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.article.entity.ArticlePosting;

@Component
public interface ArticlePostingService {

    // 新增文章
    public void postArticle(ArticlePosting article);

}

