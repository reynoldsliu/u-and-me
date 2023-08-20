package tw.idv.cha102.g7.article.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tw.idv.cha102.g7.article.entity.Article;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
// updLike監聽前端頁面onclick，like++
// 新增留言後，頁面comment_num++

    // 輸入文章標題，模糊搜尋未受屏蔽的文章，可依照熱門度(讚數)排序
    @Query(value = "SELECT * FROM article WHERE articleTitle LIKE %?1% ORDER BY articleLike DESC", nativeQuery = true)
    public List<Article> findByTitleOrderByLike(String keyword);

    // 輸入文章標題，模糊搜尋未受屏蔽的文章，可依照最新po文排序
    @Query(value = "SELECT * FROM article WHERE articleTitle LIKE %?1% ORDER BY articleTime", nativeQuery = true)
    public List<Article> findByTitleOrderByTime(String keyword);

    // 查詢使用者自己發表的文章
    public List<Article> findByMemId(Integer memId);
}
