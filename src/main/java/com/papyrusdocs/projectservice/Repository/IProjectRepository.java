package com.papyrusdocs.projectservice.Repository;

import com.papyrusdocs.projectservice.Models.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProjectRepository extends JpaRepository<Projects, Integer> {
}
