package com.argento.argento.project.dto;

import com.argento.argento.project.entity.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class ProjectDto {

    private Long id;
    private String name;
    private String clientName;
    private String country;
    private String status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private List<Member> memberList;

    public void addMember(Member member){
        this.memberList.add(member);
    }

    public ProjectDto(){
        this.memberList = new ArrayList<>();
    }
}
