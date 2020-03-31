package com.argento.argento.project.mapper;

import com.argento.argento.project.dto.MemberDto;
import com.argento.argento.project.dto.ProjectDto;
import com.argento.argento.project.entity.Member;
import com.argento.argento.project.entity.Project;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Mapper {

   public Project projectDtoToEntity(ProjectDto projectDto){

        Project project = new Project();
        project.setMemberList(new ArrayList<>());
        project.setId(projectDto.getId());
        project.setMemberList(projectDto.getMemberList());
        project.setCountry(projectDto.getCountry());
        project.setName(projectDto.getName());
        project.setStartDate(projectDto.getStartDate());
        project.setEndDate(projectDto.getEndDate());
        project.setStatus(projectDto.getStatus());
        project.setClientName(projectDto.getClientName());

        return project;
    }

    public ProjectDto projectEntityToDto(Project project){

        ProjectDto projectDto = new ProjectDto();
        projectDto.setId(project.getId());
        projectDto.setCountry(project.getCountry());
        projectDto.setStatus(project.getStatus());
        projectDto.setName(project.getName());
        projectDto.setStartDate(project.getStartDate());
        projectDto.setEndDate(project.getEndDate());
        projectDto.setMemberList(new ArrayList<>());
        projectDto.setMemberList(project.getMemberList());
        projectDto.setClientName(project.getClientName());

        return projectDto;
    }

    public Member memberDtoToEntity(MemberDto memberDto){

        Member member = new Member();
        member.setName(memberDto.getName());
        member.setSurname(memberDto.getSurname());
        member.setRole(memberDto.getRole());

        return member;
    }

    public MemberDto memberEntityToDto(Member member){

        MemberDto memberDto = new MemberDto();
        memberDto.setName(member.getName());
        memberDto.setSurname(member.getSurname());
        memberDto.setRole(member.getRole());

        return memberDto;
    }
}
