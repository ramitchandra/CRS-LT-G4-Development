package com.lt.crs.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lt.crs.bean.Professor;

@Component
public class ProfessorHandlerImpl implements ProfessorHandler {
	List<Professor> profList= new ArrayList<>();
	
	@Override
	public List<Professor> getProfList() {
		return profList;
	}
	@Override
	public Professor addProfessor(Professor prof) {
		Professor newProf = new Professor();
		newProf.setProfessorId(prof.getProfessorId());
		newProf.setProfessorName(prof.getProfessorName());
		profList.add(newProf);
		
		return newProf;
	}
	
}
