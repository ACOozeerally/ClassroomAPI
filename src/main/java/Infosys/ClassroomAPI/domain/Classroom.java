package Infosys.ClassroomAPI.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Classroom {

	public Classroom() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "class_ID")
	private Long classroomID;
	@Column(length = 100)
	private String trainer;
	@JoinColumn(name = "class_ID", referencedColumnName="class_ID")
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Trainees> trainees;

	public Classroom(Long classroomID, String trainer, List<Trainees> trainees) {
		this.classroomID = classroomID;
		this.trainer = trainer;
		this.trainees = trainees;
	}
	
	public Long getClassroomID() {
		return classroomID;
	}

	public void setClassroomID(Long classroomID) {
		this.classroomID = classroomID;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public List<Trainees> getTrainees() {
		return trainees;
	}

	public void setTrainees(List<Trainees> trainees) {
		this.trainees = trainees;
	}

}
