package com.papyrusdocs.projectservice.Controllers;

import com.papyrusdocs.projectservice.Models.ProjectUpdRequest;
import com.papyrusdocs.projectservice.Models.Projects;
import com.papyrusdocs.projectservice.Models.ProjectsRequest;
import com.papyrusdocs.projectservice.Models.Response.ProjectResponse;
import com.papyrusdocs.projectservice.Services.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectsController {

    @Autowired
    private IProjectService _projectservice;

    @RequestMapping(value = "/getallprojects", method = RequestMethod.GET)
    public ResponseEntity<ProjectResponse> getAllProjects(){
        return ResponseEntity.ok(_projectservice.getAllProjects());
    }

    @RequestMapping(value = "/createproject", method = RequestMethod.POST)
    public ResponseEntity<ProjectResponse> createProjects(@RequestBody ProjectsRequest request){
        return ResponseEntity.ok(_projectservice.createProject(request));
    }

    @RequestMapping(value = "/updateproject", method = RequestMethod.POST)
    public ResponseEntity<ProjectResponse> updateProjects(@RequestBody ProjectUpdRequest request){
        return ResponseEntity.ok(_projectservice.updateProject(request));
    }

    @RequestMapping(value = "/deleteproject/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ProjectResponse> deleteProjects(@PathVariable int id){
        return ResponseEntity.ok(_projectservice.deleteProject(id));
    }
}
