package com.gathering.info.info.domain.resumes;

import com.gathering.info.info.domain.resumes.dto.RegisterQuestion;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class QuestionServiceImpl {
    private final QuestionRepository questionRepository;

    public void registerQuestion (Resume resume, List<RegisterQuestion> questionList) {
        List<Question> questions = questionList.stream()
                .map(question -> Question.builder()
                        .questionItem(question.questionItem())
                        .answerItem(question.answerItem())
                        .resume(resume)
                        .build())
                .toList();

        questionRepository.saveAll(questions);
    }
}
