package tw.idv.cha102.g7.attraction.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "private_attraction")
public class AttrPrivateDTO {
    @Id
    @Column(name = "mem_id")
    private Integer memId;
    @Column(name = "attr_id")
    private Integer id;
    @Column(name = "attr_veri_sta")
    private Short veriSta;
    @Column(name = "attr_sta")
    private Short sta;
    @Column(name = "attr_name")
    private String name;
    @Column(name = "attr_addr")
    private String addr;
    @Column(name = "attr_lon")
    private Float lon;//google api可透過地址定位經緯度
    @Column(name = "attr_lat")
    private Float lat;
    @Column(name = "attr_illa")
    private String illa;
    @Column(name = "attr_type_id")
    private Integer typeId;
    @Column(name = "attr_buss_time")
    private String bussTime;
    @Column(name = "attr_cost_range")
    private Short costRange;
    @Column(name = "attr_rep")
    private String rep;
}
