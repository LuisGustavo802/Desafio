package com.desafio.desafio.dao;

import com.desafio.desafio.domain.Process;

import java.util.List;

public interface ProcessDAO {

    public List<Process> getAll();

    public Process getById( Long idProcess );

    public Long insert ( Process process );
}
