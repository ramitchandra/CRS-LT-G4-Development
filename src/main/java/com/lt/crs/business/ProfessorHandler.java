package com.lt.crs.business;

import java.util.List;

import com.lt.crs.bean.Professor;

public interface ProfessorHandler {
	public List<Professor> getProfList();
	public Professor addProfessor(Professor prof);

}
