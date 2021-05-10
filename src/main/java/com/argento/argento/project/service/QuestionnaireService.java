package com.argento.argento.project.service;

import com.argento.argento.project.entity.Questionnaire;
import com.argento.argento.project.repository.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class QuestionnaireService {

    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    @Transactional
    public void savefilledQuestionnaire(Questionnaire questionnaire){
        questionnaireRepository.save(questionnaire);
    }

    public List<Questionnaire> getUserQuestionnaires(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        System.out.println(name);
        return questionnaireRepository.findAll();
    }
}
