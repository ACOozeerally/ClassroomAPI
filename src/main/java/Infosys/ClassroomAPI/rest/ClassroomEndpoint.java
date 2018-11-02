package Infosys.ClassroomAPI.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import Infosys.ClassroomAPI.domain.Trainees;
import Infosys.ClassroomAPI.repository.ClassroomRepository;

@Path("/classroom")
public class ClassroomEndpoint {

	@Inject
	private ClassroomRepository classRepo;

	@Path("/getAllClassrooms")
	@GET
	@Produces({ "application/json" })
	public String getAllClassrooms() {
		return classRepo.getAllClassrooms();
	}

	@Path("/getClassroom/{id}")
	@GET
	@Produces({ "application/json" })
	public String getClassroom(@PathParam("id") Long classroomID) {
		return classRepo.getClassroom(classroomID);
	}

	@Path("/createClassroom")
	@POST
	@Produces({ "application/json" })
	public String createClassroom(String classroom) {
		return classRepo.createClassroom(classroom);
	}

	@Path("/updateClassroom/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateClassroom(@PathParam("id") Long classroomID, String classroom){
		{
			return classRepo.updateClassroom(classroomID, classroom);
		}
	}

	@Path("/deleteClassroom/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteClassroom(@PathParam("id") Long classroomID) {
		return classRepo.deleteClassroom(classroomID);
	}

	public void setService(ClassroomRepository classRepo) {
		this.classRepo = classRepo;
	}

}