package com.papyrusdocs.projectservice.Services;

import com.papyrusdocs.projectservice.Models.ProjectUpdRequest;
import com.papyrusdocs.projectservice.Models.Projects;
import com.papyrusdocs.projectservice.Models.ProjectsRequest;
import com.papyrusdocs.projectservice.Models.Response.ProjectResponse;

import java.util.List;

public interface IProjectService {
    ProjectResponse getAllProjects();
    ProjectResponse createProject(ProjectsRequest request);
    ProjectResponse updateProject(ProjectUpdRequest request);
    ProjectResponse deleteProject(int id);
}
