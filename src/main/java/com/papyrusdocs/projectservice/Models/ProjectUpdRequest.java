package com.papyrusdocs.projectservice.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectUpdRequest {
    public int Id;
    public String ProjectName;
    public int AssignTo;
    public String Client;
    public String ContactNo;
    public LocalDate StartDate;
    public LocalDate Deadline;
}
