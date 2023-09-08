package tw.idv.cha102.g7.article.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.article.entity.Article;
import tw.idv.cha102.g7.article.entity.ArticlePicture;
import tw.idv.cha102.g7.article.entity.ArticlePosting;
import tw.idv.cha102.g7.article.repo.ArticlePictureRepository;
import tw.idv.cha102.g7.article.repo.ArticlePostingRepository;
import tw.idv.cha102.g7.article.service.ArticlePostingService;

import java.util.List;

@Component
public class ArticlePostingServiceImpl implements ArticlePostingService {
    @Autowired
    ArticlePostingRepository articlePostingRepository;
    @Autowired
    ArticlePictureRepository articlePictureRepository;

    private ArticlePosting article;

    @Override
    public void postArticle(ArticlePosting article) {
        this.article = article;
        articlePostingRepository.save(article);

    }

//    public void saveArticleId() {
//        articlePostingRepository.save(article);
//        article.getArticleId();
//    }

    public void postPicsAndSaveArticleId(List<ArticlePicture> pics) {
        Integer articleId = article.getArticleId();
        System.out.println(articleId);

        for (ArticlePicture picture : pics) {
            picture.setArticleId(articleId); // 设置每个图片对象的 articleId
        }
        articlePictureRepository.saveAll(pics);
    }

}
