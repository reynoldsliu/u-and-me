package tw.idv.cha102.g7.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Time;
import java.sql.Timestamp;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "schedule_de")
public class ScheduleDetail {

	@Id
	@Column(name = "schde_id")
	private Integer schdeId;

	@Column(name = "sch_id")
	private Integer schId;

	@Column(name = "attr_id")
	private Integer attrId;

	@Column(name = "schde_starttime")
	private Timestamp schdeStarttime;

	@Column(name = "schde_staytime")
	private Time schdeStaytime;

	@Column(name = "schde_transtime")
	private Time schdeTranstime;

	@Column(name = "schde_trans")
	private Integer schdeTrans;

	@Column(name = "schde_costname")
	private String schdeCostname;

	@Column(name = "schde_cost")
	private Integer schdeCost;

	@Column(name = "schde_remark")
	private String schdeRemark;

}
