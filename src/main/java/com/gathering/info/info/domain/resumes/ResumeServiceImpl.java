package com.gathering.info.info.domain.resumes;

import com.gathering.info.info.domain.corporations.entity.Corporation;
import com.gathering.info.info.domain.corporations.repository.CorporationsRepository;
import com.gathering.info.info.domain.resumes.dto.RegisterResume;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ResumeServiceImpl implements ResumeService{

    private final ResumeRepository resumeRepository;
    private final QuestionServiceImpl questionService;
    private final CorporationsRepository corporationsRepository;
    @Override
    public void registerResume(RegisterResume registerResumeList) {
        Corporation corporation = corporationsRepository.findById(registerResumeList.corporationId())
                .orElseThrow(IllegalArgumentException::new);

        List<Question> questions = registerResumeList.registerQuestions().stream()
                .map(question -> Question.builder()
                        .questionItem(question.questionItem())
                        .answerItem(question.answerItem())
                        .build())
                .toList();

        Resume resume = Resume.builder()
                .corporation(corporation)
                .questionList(questions)
                .build();
        resumeRepository.save(resume);

    }
}
