package eu.ensup.controllers;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eu.ensup.domaine.Course;
import eu.ensup.service.ICourseService;

@Controller
@RequestMapping("/course")
public class CourseController
{
	@Autowired
	private ICourseService courseService;

	@RequestMapping("/list")
	public String listCourses(Model model)
	{
		List<Course> courses = courseService.getAllCourses();

		if (courses != null)
		{
			model.addAttribute("courses", courses);
		}

		return "coursListe";
	}

	@GetMapping("/create")
	public String createCourse(Model model)
	{
		return "coursCreer";
	}

	@PostMapping("/save")
	public String saveCourse(@ModelAttribute(name = "courseTime") String courseTime,
			@ModelAttribute(name = "courseTheme") String courseTheme, Model model)
	{
		int nbHeure = Integer.valueOf(courseTime);
		Course cours = new Course(courseTheme, nbHeure);

		System.out.println(cours.getNumberHours());

		Response responseFromService = courseService.createCourse(cours);

		if (responseFromService.getStatus() == 200 || responseFromService.getStatus() == 204)
			model.addAttribute("message", "Elément enregistré avec succès");
		else
			model.addAttribute("error", "Un problème est survenu. Veuillez réessayer.");

		model.addAttribute("courses", courseService.getAllCourses());

		return "cours";
	}

	@GetMapping("/edit")
	public String editCourse(@RequestParam(name = "id", required = false) Long id, Model model)
	{
		model.addAttribute("message", null);
		
		Course course = courseService.getCourseById(id);
		model.addAttribute("course", course);

		return "coursModifier";
	}

	@PutMapping("/update/{id}")
	public String updateCourse(@Validated @RequestBody Course course, Model model)
	{
		model.addAttribute("cours", null);

		Response responseFromService = courseService.updateCourse(course.getIdCourse(), course);

		if (responseFromService.getStatus() == 200 || responseFromService.getStatus() == 204)
			model.addAttribute("message", "Elément modifié avec succès");
		else
			model.addAttribute("message", "Un problème est survenu. Veuillez réessayer.");

		model.addAttribute("cours", null);
		model.addAttribute("courses", courseService.getAllCourses());
		
		
		courseService.updateCourse(course.getIdCourse(), course);
		model.addAttribute("course", course);
		
		return "coursListe";
	}

	@GetMapping("/delete")
	public String deleteCourse(@RequestParam(name = "id", required = false) Long id, Model model)
	{
		model.addAttribute("cours", null);

		Response responseFromService = courseService.deleteCourse(id);

		if (responseFromService.getStatus() == 200 || responseFromService.getStatus() == 204)
			model.addAttribute("message", "Elément supprimé avec succès");
		else
			model.addAttribute("error", "Un problème est survenu. Veuillez réessayer.");

		model.addAttribute("courses", courseService.getAllCourses());
		
		return "coursListe";
	}
}
