package Infosys.ClassroomAPI.repository;
import static javax.transaction.Transactional.TxType.*;


import java.util.Collection;
import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import Infosys.ClassroomAPI.Util.JSONUtil;
import Infosys.ClassroomAPI.domain.Classroom;
import Infosys.ClassroomAPI.domain.Trainees;

@Transactional(SUPPORTS)
@Default
public class ClassroomDBRepository implements ClassroomRepository {

	@Inject
	private JSONUtil util;

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	public String getAllClassrooms() {
		Query query = manager.createQuery("Select a FROM Classroom a");
		Collection<Classroom> classrooms = (Collection<Classroom>) query.getResultList();
		return util.getJSONForObject(classrooms);
	}

	@Transactional(REQUIRED)
	public String createClassroom(String classroom) {
		Classroom aClassroom = util.getObjectForJSON(classroom, Classroom.class);
		manager.merge(aClassroom);
		return "{\"message\": \"classroom sucessfully added\"}";
	}

	// @Transactional(REQUIRED)
	// public String updateClassroom(Long id, String classroomToUpdate) {
	// Classroom updatedClassroom = util.getObjectForJSON(classroomToUpdate,
	// Classroom.class);
	// Classroom classroomFromDB = findClassroom(id);
	// if (classroomToUpdate != null) {
	// classroomFromDB = updatedClassroom;
	// manager.merge(classroomFromDB);
	// }
	// return "{\"message\": \"account sucessfully updated\"}";
	// }
	//
	@Transactional(REQUIRED)
	public String updateClassroom(Long id, String classroom) {
		Classroom aClassroom = util.getObjectForJSON(classroom, Classroom.class);
		//Classroom aClassroom = new Classroom(id, trainer, trainees);
		Classroom classroomInDB = findClassroom(id);
		classroomInDB.setTrainer(aClassroom.getTrainer());
		classroomInDB.setTrainees(aClassroom.getTrainees());

		return "{\"message\": \"Account has been sucessfully updated\"}";
	}

	@Transactional(REQUIRED)
	public String deleteClassroom(Long id) {
		Classroom classroomInDB = findClassroom(id);
		if (classroomInDB != null) {
			manager.remove(classroomInDB);
		}
		return "{\"message\": \"classroom sucessfully deleted\"}";
	}

	private Classroom findClassroom(Long id) {
		return manager.find(Classroom.class, id);
	}

	public String getClassroom(Long id) {
		Classroom aClassroom = manager.find(Classroom.class, id);
		return util.getJSONForObject(aClassroom);
	}


	

}