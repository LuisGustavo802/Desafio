package com.desafio.desafio.service;

import com.desafio.desafio.dao.ProcessDAO;
import com.desafio.desafio.domain.Process;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    private ProcessDAO processDAO;

    @Override
    public List<Process> getAll() { return processDAO.getAll(); }

    @Override
    public Process getById(Long idProcess) { return processDAO.getById( idProcess ); }

    @Override
    public Long insert(Process process) { return processDAO.insert( process ); }
}