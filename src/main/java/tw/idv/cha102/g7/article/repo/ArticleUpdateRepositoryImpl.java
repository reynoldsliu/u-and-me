package tw.idv.cha102.g7.article.repo;//package tw.idv.cha102.g7.article.repo;
//
//import org.hibernate.Session;
//import org.hibernate.query.Query;
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.repository.query.FluentQuery;
//import org.springframework.stereotype.Repository;
//import tw.idv.cha102.g7.article.entity.Article;
//
//import javax.persistence.PersistenceContext;
//import java.util.List;
//import java.util.Optional;
//import java.util.function.Function;
//
//@Repository
//public class ArticleUpdateRepositoryImpl implements ArticleUpdateRepository {
//    @PersistenceContext
//    private Session session;
//
//    //  article_title, article_con
//    public int update(Article article) {
//        final StringBuilder sql = new StringBuilder()
//                .append("update article set ");
//        sql.append("article_title = :articleTitle,").append("article_con = :articleContent")
//                .append("WHERE mem_id = :memId");
//        // 將要更新的欄位名稱和對應的參數占位符添加到 SQL 語句中
//        Query<?> query = session.createNativeQuery(sql.toString());
//        // 創建 Query可使用 .setParameter() 方法來設置查詢中的參數。
//        // StringBuilder 以動態方式建立字串，.toString() 方法可將 StringBuilder 物件轉換成普通的字串。
//
//        if (article != null) {
//            // 使用更新後的 Article 物件設定參數
//            return query.setParameter("articleTitle", article.getArticleTitle())
//                    .setParameter("article_con", article.getArticleContent())
//                    .setParameter("memId", article.getMemId()) // 假設 mem_id 是 Article 的某個屬性
//                    .executeUpdate();
//                     // 執行
//        } else {
//            return 0; // 或者回傳其他錯誤狀態
//        }
//    }
//
//
//
//    @Override
//    public List<Article> findAll() {
//        return null;
//    }
//
//    @Override
//    public List<Article> findAll(Sort sort) {
//        return null;
//    }
//
//    @Override
//    public Page<Article> findAll(Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public List<Article> findAllById(Iterable<Integer> integers) {
//        return null;
//    }
//
//    @Override
//    public long count() {
//        return 0;
//    }
//
//    @Override
//    public void deleteById(Integer integer) {
//
//    }
//
//    @Override
//    public void delete(Article entity) {
//
//    }
//
//    @Override
//    public void deleteAllById(Iterable<? extends Integer> integers) {
//
//    }
//
//    @Override
//    public void deleteAll(Iterable<? extends Article> entities) {
//
//    }
//
//    @Override
//    public void deleteAll() {
//
//    }
//
//    @Override
//    public <S extends Article> S save(S entity) {
//        return null;
//    }
//
//    @Override
//    public <S extends Article> List<S> saveAll(Iterable<S> entities) {
//        return null;
//    }
//
//    @Override
//    public Optional<Article> findById(Integer integer) {
//        return Optional.empty();
//    }
//
//    @Override
//    public boolean existsById(Integer integer) {
//        return false;
//    }
//
//    @Override
//    public void flush() {
//
//    }
//
//    @Override
//    public <S extends Article> S saveAndFlush(S entity) {
//        return null;
//    }
//
//    @Override
//    public <S extends Article> List<S> saveAllAndFlush(Iterable<S> entities) {
//        return null;
//    }
//
//    @Override
//    public void deleteAllInBatch(Iterable<Article> entities) {
//
//    }
//
//    @Override
//    public void deleteAllByIdInBatch(Iterable<Integer> integers) {
//
//    }
//
//    @Override
//    public void deleteAllInBatch() {
//
//    }
//
//    @Override
//    public Article getOne(Integer integer) {
//        return null;
//    }
//
//    @Override
//    public Article getById(Integer integer) {
//        return null;
//    }
//
//    @Override
//    public Article getReferenceById(Integer integer) {
//        return null;
//    }
//
//    @Override
//    public <S extends Article> Optional<S> findOne(Example<S> example) {
//        return Optional.empty();
//    }
//
//    @Override
//    public <S extends Article> List<S> findAll(Example<S> example) {
//        return null;
//    }
//
//    @Override
//    public <S extends Article> List<S> findAll(Example<S> example, Sort sort) {
//        return null;
//    }
//
//    @Override
//    public <S extends Article> Page<S> findAll(Example<S> example, Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public <S extends Article> long count(Example<S> example) {
//        return 0;
//    }
//
//    @Override
//    public <S extends Article> boolean exists(Example<S> example) {
//        return false;
//    }
//
//    @Override
//    public <S extends Article, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
//        return null;
//    }
//
//
//    // article_pic另外做一個repository
//}
