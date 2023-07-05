package com.papyrusdocs.projectservice.Services;

import com.papyrusdocs.projectservice.Models.ProjectUpdRequest;
import com.papyrusdocs.projectservice.Models.Projects;
import com.papyrusdocs.projectservice.Models.ProjectsRequest;
import com.papyrusdocs.projectservice.Models.Response.ProjectResponse;
import com.papyrusdocs.projectservice.Repository.IProjectRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectService implements IProjectService{
    private final IProjectRepository _projectrepository;

    public ProjectService(IProjectRepository projectrepository){
        this._projectrepository = projectrepository;
    }

    public ProjectResponse getAllProjects(){
        var projects = _projectrepository.findAll();

        if (projects != null){

            return ProjectResponse.builder()
                    .statusCode("200 Ok")
                    .message("Success")
                    .data(projects)
                    .build();
        }

        return ProjectResponse.builder()
                .statusCode("204 No content")
                .message("There are no records on the database")
                .build();
    }

    public ProjectResponse createProject(ProjectsRequest request){
        try{
            if (request == null){

                return ProjectResponse.builder()
                        .statusCode("400 Bad request")
                        .message("Request cannot be empty")
                        .build();
            }

            var project = Projects.builder()
                    .ProjectName(request.getProjectName())
                    .AssignTo(request.getAssignTo())
                    .Client(request.getClient())
                    .ContactNo(request.getContactNo())
                    .StartDate(request.getStartDate())
                    .Deadline(request.getDeadline())
                    .build();

            _projectrepository.save(project);

            return ProjectResponse.builder()
                    .statusCode("200 Ok")
                    .message("Success")
                    .build();
        } catch (Exception ex){

            return ProjectResponse.builder()
                    .statusCode("500 Internal server error")
                    .message(ex.getMessage())
                    .build();
        }
    }

    public ProjectResponse updateProject(ProjectUpdRequest request){
        try{
            if (request == null){

                return ProjectResponse.builder()
                        .statusCode("400 Bad request")
                        .message("Request cannot be empty")
                        .build();
            }

            var project = _projectrepository.findById(request.getId());

            if (project.isPresent()){
                project.get().setProjectName(request.getProjectName());
                project.get().setAssignTo(request.getAssignTo());
                project.get().setClient(request.getClient());
                project.get().setContactNo(request.getContactNo());
                project.get().setStartDate(request.getStartDate());
                project.get().setDeadline(request.getDeadline());

                _projectrepository.save(project.get());

                return ProjectResponse.builder()
                        .statusCode("200 Ok")
                        .message("Success")
                        .build();
            }

            return ProjectResponse.builder()
                    .statusCode("404 Not found")
                    .message("Unable to find a project")
                    .build();

        } catch (Exception ex){

            return ProjectResponse.builder()
                    .statusCode("500 Internal server error")
                    .message(ex.getMessage())
                    .build();
        }
    }

    public ProjectResponse deleteProject(int id){
        try{
            if (id == 0){

                return ProjectResponse.builder()
                        .statusCode("400 Bad request")
                        .message("Id cannot be 0")
                        .build();
            }

            _projectrepository.deleteById(id);

            return ProjectResponse.builder()
                    .statusCode("200 Ok")
                    .message("Success")
                    .build();

        }catch (Exception ex){
            return ProjectResponse.builder()
                    .statusCode("500 Internal server error")
                    .message(ex.getMessage())
                    .build();
        }
    }
}
