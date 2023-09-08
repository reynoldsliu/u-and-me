package tw.idv.cha102.g7.article.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

// 複合主鍵
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "article_collection")
public class ArticleCollection {

    @EmbeddedId
    private ArticleCollectionId id;

    @Column(name="ac_follow_date")
    private Date acFollowDate;

}
