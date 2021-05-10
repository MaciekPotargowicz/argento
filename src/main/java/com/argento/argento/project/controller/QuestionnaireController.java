package com.argento.argento.project.controller;

import com.argento.argento.project.entity.Questionnaire;
import com.argento.argento.project.service.QuestionnaireService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController {

    @Autowired
    private QuestionnaireService service;

    @PostMapping(value = "/save")
    public ResponseEntity<String> savefilledQuestionnaire(@RequestBody Questionnaire questionnaire){
        service.savefilledQuestionnaire(questionnaire);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "questionnaire/all")
    public List<Questionnaire> getUserQuestionnaires(){
        return service.getUserQuestionnaires();
    }
}
