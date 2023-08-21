package tw.idv.cha102.g7.customer.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "chat")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerChat implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @Column(name = "chat_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer chatId;

    @Column(name = "mem_id")
    private Integer memId;

    @Column(name = "host_id", insertable = false)
    private Integer hostId;

    @Column(name = "chat_time")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp chatTime;

    @Column(name = "chat_type", insertable = false)
    private Integer chatType;

    @Column(name = "chat_point")
    private Integer chatPoint;

    @Column(name = "chat_con")
    private String chatCon;

}
