package com.desafio.desafio.dao;

import com.desafio.desafio.domain.FeedbackProcess;

import java.util.List;

public interface FeedbackProcessDAO {

    public List<FeedbackProcess> getByProcess(Long idProcess );

    public List<FeedbackProcess> getByIdUser(Long idUser );

    public FeedbackProcess getByIdUserAndIdProcess(Long idUser, Long idProcess );

    public void insert ( FeedbackProcess feedbackProcess);

    public void update ( FeedbackProcess feedbackProcess);
}
