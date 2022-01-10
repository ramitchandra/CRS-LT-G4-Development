package com.lt.crs.business;

import java.util.List;

import com.lt.bean.Grades;
import com.lt.bean.Professor;

public interface ProfessorHandler {
	public List<Professor> getProfList();
	public Professor addProfessor(Professor prof);
	public int listStudent(int studentOption);
	public Professor deleteProfessor(int professorId);

}
