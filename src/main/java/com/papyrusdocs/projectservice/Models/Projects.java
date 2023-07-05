package com.papyrusdocs.projectservice.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Builder
@Table(name = "Projects")
public class Projects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int Id;
    public String ProjectName;
    public int AssignTo;
    public String Client;
    public String ContactNo;
    @Column(columnDefinition = "DATE")
    public LocalDate StartDate;
    @Column(columnDefinition = "DATE")
    public LocalDate Deadline;

}
