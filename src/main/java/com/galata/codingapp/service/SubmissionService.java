package com.galata.codingapp.service;

import com.galata.codingapp.model.Submission;
import com.galata.codingapp.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SubmissionService {

    @Autowired
    private SubmissionRepository submissionRepository;

    public List<Submission> getAllSubmissions() {
        return submissionRepository.findAll();
    }

    public Optional<Submission> getSubmissionById(Long id) {
        return submissionRepository.findById(id);
    }

    public List<Submission> getSubmissionsByUsernameAndTaskId(String username, Long taskId) {
        return submissionRepository.findByUsernameAndTaskId(username, taskId);
    }

    public Submission createSubmission(Submission submission) {
        return submissionRepository.save(submission);
    }

    public Submission updateSubmission(Long id , Submission updatedSubmission) {
        return submissionRepository.findById(id)
                .map(submission -> {
                    submission.setCode(updatedSubmission.getCode());
                    submission.setCorrect(updatedSubmission.isCorrect());
                    submission.setSubmittedAt(updatedSubmission.getSubmittedAt());
                    return submissionRepository.save(submission);
                })
                .orElseThrow(() -> new RuntimeException("Submission not found"));
    }

    public void deleteSubmission(Long id) {
        if (submissionRepository.existsById(id)) {
            submissionRepository.deleteById(id);
        } else {
            throw new RuntimeException("Submission not found");
        }
    }
}

