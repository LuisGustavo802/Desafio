package com.desafio.desafio.service;

import com.desafio.desafio.domain.Process;

import java.util.List;

public interface ProcessService {

    public List<Process> getAll();

    public Process getById( Long idProcess );

    public Long insert ( Process process );
}
