package tw.idv.cha102.g7.article.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.idv.cha102.g7.article.entity.Article;
import tw.idv.cha102.g7.article.repo.ArticleUpdateRepository;
import tw.idv.cha102.g7.article.service.ArticleUpdateService;

@Service
public class ArticleUpdateServiceImpl implements ArticleUpdateService {
    @Autowired
    private ArticleUpdateRepository articleUpdateRepository;


    // 使用者編輯文章
    @Override
    public String userEdit(Integer articleId, Article oldArticle) {
        Article updArticle = articleUpdateRepository.findById(articleId).orElse(null);
        if (updArticle != null) {
            updArticle.setArticleTitle(oldArticle.getArticleTitle());
            updArticle.setArticleContent(oldArticle.getArticleContent());

            articleUpdateRepository.save(updArticle);
            return "更新成功！";
        } else {
            return "更新失敗，查詢的行程不存在";
        }
    }

    @Override
    public String adminEdit(Article oldArticle) {
        Integer articleId = oldArticle.getArticleId();
        Article updArticle = articleUpdateRepository.findById(articleId).orElse(null);
        if (updArticle != null) {
            updArticle.setArticleSta(oldArticle.getArticleSta());
            articleUpdateRepository.save(updArticle);
            return "更新成功！";
        } else {
            return "更新失敗，查詢的行程不存在";
        }
    }

}
