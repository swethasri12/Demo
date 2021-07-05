package com.restapi;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentResource {
	
	Studentdao repo=new Studentdao();
	@GetMapping("students")
	public List<StudentPojo> getStudents() {
		
		System.out.println("getStudent called");
		
		return repo.getStudents();
	}
	

	@GetMapping("student/{id}")
	public StudentPojo getStudent(@PathVariable int id) {
		
		System.out.println("getStudent called");
		
		return repo.getStudent(id);
	}
	
	

	@PostMapping("student")
	public StudentPojo createStudents(StudentPojo s1) {
		repo.create(s1);
		return s1;
	}
	
	@PutMapping("student")
	public StudentPojo  updateStudent(StudentPojo s1) {
		if (repo.getStudent(s1.getId())!=null) {
			return repo.update(s1);
		}
		return null;
	}
	
	
	@DeleteMapping("student/{id}")
	public StudentPojo delStudent(@PathVariable int id) {
		if (repo.getStudent(id)!=null) {
			repo.delStudent(id);
			return repo.getStudent(id);
		}
		else
			return null;
	}
	
}
