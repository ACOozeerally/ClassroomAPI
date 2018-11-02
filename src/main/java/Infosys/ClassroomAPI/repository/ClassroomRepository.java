package Infosys.ClassroomAPI.repository;

import java.util.List;

import Infosys.ClassroomAPI.domain.Trainees;

public interface ClassroomRepository {
	
	String getAllClassrooms();

	String createClassroom(String classroom);

	String deleteClassroom(Long classroomID);

	String getClassroom(Long classroomID);

	String updateClassroom(Long id, String classroom);

}
