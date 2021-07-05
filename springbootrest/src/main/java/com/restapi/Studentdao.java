package com.restapi;

import java.util.ArrayList;
import java.util.List;

public class Studentdao {
	List<StudentPojo> stu;
	
	public Studentdao() {
		stu=new ArrayList<StudentPojo>();
		
		StudentPojo s1=new StudentPojo();
		s1.setName("swetha");
		s1.setId(1);
		s1.setEmail("swe@gmail.com");
		
		StudentPojo s2=new StudentPojo();
		s2.setName("xyz");
		s2.setId(2);
		s2.setEmail("xyz@gmail.com");
		
		stu.add(s1);
		stu.add(s2);
		
	}
	
	public List<StudentPojo> getStudents(){
		return stu;
	}
	
	public StudentPojo getStudent(int id) {
		for (StudentPojo s:stu) {
			if (s.getId()==id)
				return s;
		}
		return null;
	}

	public StudentPojo create(StudentPojo s1) {
		stu.add(s1);
		return s1;
	}
	
	public StudentPojo update(StudentPojo s1) {
		for (StudentPojo s:stu) {
			if (s.getId()==s1.getId()) {
				s.setName(s1.getName());
				s.setEmail(s1.getEmail());
				return s;
			}
		}
		return null;
	}

	public void delStudent(int id) {
		for (StudentPojo s:stu) {
			if (s.getId()==id) {
				stu.remove(s);
				break;
			}
		}
	}
}
