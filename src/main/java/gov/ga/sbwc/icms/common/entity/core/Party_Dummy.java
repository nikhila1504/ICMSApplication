package gov.ga.sbwc.icms.common.entity.core;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Party_Dummy")
public class Party_Dummy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	@Column(name = "name")
	private String name;

	@Column(name = "party_type")
	private String partyType;

	@Column(name = "email")
	private String emailId;
	
//	 @OneToOne
//	 @JoinColumn(name = "calendar_id")
//	 private Calendar calendar;

	public Party_Dummy() {

	}

	public int getId() {
		return Id;
	}

//	public Calendar getCalendar() {
//		return calendar;
//	}
//
//	public void setCalendar(Calendar calendar) {
//		this.calendar = calendar;
//	}

	public void setId(int id) {
		Id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPartyType() {
		return partyType;
	}

	public void setPartyType(String partyType) {
		this.partyType = partyType;
	}

	
}
