package com.desafio.desafio.service;

import com.desafio.desafio.dao.FeedbackProcessDAO;
import com.desafio.desafio.domain.FeedbackProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FeedbackProcessServiceImpl implements FeedbackProcessService {

    @Autowired
    private FeedbackProcessDAO processDAO;

    @Override
    public List<FeedbackProcess> getByProcess(Long idProcess) { return processDAO.getByProcess( idProcess ); }

    @Override
    public List<FeedbackProcess> getByIdUser(Long idUser) { return processDAO.getByIdUser( idUser ); }

    @Override
    public FeedbackProcess getByIdUserAndIdProcess(Long idUser, Long idProcess) { return processDAO.getByIdUserAndIdProcess( idUser, idProcess ); }

    @Override
    public void insert(FeedbackProcess feedbackProcess) { processDAO.insert(feedbackProcess); }

    @Override
    public void update(FeedbackProcess feedbackProcess) { processDAO.update(feedbackProcess); }
}
