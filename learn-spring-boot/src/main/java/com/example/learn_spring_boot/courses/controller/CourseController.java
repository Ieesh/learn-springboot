package com.example.learn_spring_boot.courses.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.learn_spring_boot.courses.bean.Course;
import com.example.learn_spring_boot.courses.repository.CourseRepository;

@RestController
public class CourseController {

	@Autowired
	private CourseRepository repository;

	// https://localhost:8080/courses
	@GetMapping("/courses")
	public List<Course> getAllCourses() {

//		return Arrays.asList(new Course(1, "Learn Microservice", "in28minutes"),
//				new Course(2, "Learn React", "in 28 minutes"));

		return repository.findAll();
	}

	@GetMapping("/courses/{id}")
	public Course getCourse(@PathVariable long id) {
		Optional<Course> course = repository.findById(id);
		if (course.isEmpty()) {
			throw new RuntimeException("Course not found with id" + id);
		}
		return course.get();
		//return new Course(3, "Learn js 3", "in 28 min");

}

	@PostMapping("/courses")

	public void createCourse(@RequestBody Course course) {
		repository.save(course);

		}



		@PutMapping("/courses/{id}")

		public void updateCourse(@PathVariable long id, @RequestBody Course course) {
			repository.save(course);

		}

		@DeleteMapping("/courses/{id}")
		public void deleteCourse(@PathVariable long id) {
			repository.deleteById(id);
		}

	}


// get- retrieve infor
// post-create a new resource
// put-update/replace a resource
// patch- to update a part of resource
// delete-to delete the entire resource
