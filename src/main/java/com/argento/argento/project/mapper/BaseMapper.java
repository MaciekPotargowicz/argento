package com.argento.argento.project.mapper;

import com.argento.argento.project.dto.ProjectDto;
import com.argento.argento.project.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
@MapperConfig(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
public interface BaseMapper {

    Project mapProjectDtoToProjectEntity(ProjectDto projectDto);

    ProjectDto mapProjectEntityToProjectDto(Project project);

    List<ProjectDto> mapProjectEntityListToProjectDtoList(List<Project> projectList);

    Project updateProject(ProjectDto projectDto);
}
