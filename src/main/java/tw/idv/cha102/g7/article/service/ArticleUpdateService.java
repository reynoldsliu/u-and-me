package tw.idv.cha102.g7.article.service;

import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.article.entity.Article;

@Component
public interface ArticleUpdateService {
    // 使用者編輯文章
    public String userEdit(Integer articleId, Article article);

    // 管理員修改上下架狀態
    public String adminEdit(Article article);


    }
