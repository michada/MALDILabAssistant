package es.uvigo.ei.sing.mla.view.models;

import org.springframework.util.StringUtils;
import org.zkoss.bind.annotation.Command;

import es.uvigo.ei.sing.mla.model.entities.User;
import es.uvigo.ei.sing.mla.services.UserService;
import es.uvigo.ei.sing.mla.services.UserServiceImpl;

public class UserViewModel {

	private UserService service;

	private String signInUsername;
	private String signInPassword;

	private String signUpUsername;
	private String signUpPassword;

	@Command
	public void signIn() {
		User user = service.getUser(this.signInUsername);

		if (user != null &&
				user.getPassword().equals(this.signInPassword)) {
			
			System.out.println("HAS INICIADO SESIÓN");
		} else {
			System.out.println("LOGIN NO VÁLIDO");
		}
	}

	@Command
	public void signUp() {
		if (StringUtils.hasLength(this.signUpUsername)
				&& StringUtils.hasLength(this.signUpPassword)) {

			System.out.println("TE HAS REGISTRADO");

			service.addUser(new User(signUpUsername, signUpPassword));
		} else {
			System.out.println("CAMPOS VACÍOS");
		}
	}
}
