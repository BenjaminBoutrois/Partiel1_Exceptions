package eu.ensup.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import eu.ensup.domaine.User;
import eu.ensup.exceptions.UserNotFoundException;
import eu.ensup.service.IUserService;

@Controller
public class UserController
{
	@Autowired
	private IUserService userService;

	@GetMapping(path = { "/", "/login" })
	public String home(Model model)
	{
		return "login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute(name = "login") String login,
			@ModelAttribute(name = "password") String password, Model model, HttpSession session)
	{
		String pageRedirect = "login";

		try
		{
			User user = new User();
			user.setLogin(login);
			user.setPassword(password);

			System.out.println(user.getLogin() + user.getPassword());

			User userRetour = userService.login(user);

			System.out.println(userRetour.toString());

			if (userRetour != null && userRetour.getLogin().equalsIgnoreCase(login)
					&& userRetour.getPassword().equalsIgnoreCase(password))
			{

				pageRedirect = "home";

				String profil;
				if (userRetour.getProfil().equalsIgnoreCase("D"))
				{
					profil = "Directeur";
				}
				else
				{
					profil = "Responsable";
				}

				session.setAttribute("user", userRetour);

				model.addAttribute("profil", profil);
			}
			else
			{
				model.addAttribute("error", "Impossible d'effectuer l'authentification.");
			}
		}
		catch (UserNotFoundException e)
		{
			model.addAttribute("error", e.getMessage());
		}

		return pageRedirect;
	}
}
