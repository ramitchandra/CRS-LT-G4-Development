package com.lt.crs.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lt.crs.bean.Grades;
import com.lt.crs.bean.Professor;

@Component
public class ProfessorHandlerImpl implements ProfessorHandler {
	List<Professor> profList= new ArrayList<>();
	public List<Grades> gradeList = new ArrayList<>();
	
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
	
	@Override
	public List<Grades> insertGrade() {
		Grades grade1 = new Grades();
		grade1.setStudentId(0001);
		grade1.setGrade("A");
		gradeList.add(grade1);
		
		Grades grade2 = new Grades();
		grade2.setStudentId(0002);
		grade2.setGrade("B");
		gradeList.add(grade2);
		
		return gradeList;
		
	}

	@Override
	public List<Grades> viewGrades() {
		
		return gradeList;
	}

	@Override
	public int listStudent(int studentOption) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public Professor deleteProfessor(int professorId) {
		Professor deletedProfessor=null;
		for(Professor pro: profList) {
			if(pro.getProfessorId()==professorId) {
				deletedProfessor=pro;
				profList.remove(pro);
				break;
			}
		}
		return deletedProfessor;
	}
	
}
