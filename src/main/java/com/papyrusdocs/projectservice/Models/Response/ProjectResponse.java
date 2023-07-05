package com.papyrusdocs.projectservice.Models.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProjectResponse {
    public String statusCode;
    public String message;
    public List<?> data;
}
