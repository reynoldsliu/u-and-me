package tw.idv.cha102.g7.article.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.article.entity.ArticlePosting;
import tw.idv.cha102.g7.article.repo.ArticlePostingRepository;
import tw.idv.cha102.g7.article.service.ArticlePostingService;

@Component
public class ArticlePostingServiceImpl implements ArticlePostingService {
    @Autowired
    ArticlePostingRepository articlePostingPostingRepository;

    @Override
    public void postArticle(ArticlePosting article)
    {
        articlePostingPostingRepository.save(article);
    }


}
