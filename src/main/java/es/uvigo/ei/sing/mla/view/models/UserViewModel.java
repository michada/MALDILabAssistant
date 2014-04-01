package es.uvigo.ei.sing.mla.view.models;

import org.springframework.util.StringUtils;
import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Messagebox;

import es.uvigo.ei.sing.mla.model.entities.User;
import es.uvigo.ei.sing.mla.services.UserService;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class UserViewModel {
	@WireVariable
	private UserService userService;

	private String signInUsername = "signInUsername";
	private String signInPassword = "signInPassword";

	private String signUpUsername = "signUpUsername";
	private String signUpPassword = "signUpPassword";

	public String getSignInUsername() {
		return signInUsername;
	}

	public void setSignInUsername(String signInUsername) {
		this.signInUsername = signInUsername;
	}

	public String getSignInPassword() {
		return signInPassword;
	}

	public void setSignInPassword(String signInPassword) {
		this.signInPassword = signInPassword;
	}

	public String getSignUpUsername() {
		return signUpUsername;
	}

	public void setSignUpUsername(String signUpUsername) {
		this.signUpUsername = signUpUsername;
	}

	public String getSignUpPassword() {
		return signUpPassword;
	}

	public void setSignUpPassword(String signUpPassword) {
		this.signUpPassword = signUpPassword;
	}

	@Command
	public void signIn() {
		User user = userService.getUser(this.signInUsername);

		if (user != null && user.getPassword().equals(this.signInPassword)) {

			Executions.getCurrent().sendRedirect("home.zul");
		} else {
			Messagebox.show("Wrong login / password");
		}
	}

	@Command
	public void signUp() {
		if (StringUtils.hasLength(this.signUpUsername)
				&& StringUtils.hasLength(this.signUpPassword)
				&& userService.getUser(signUpUsername) == null) {

			userService.addUser(new User(signUpUsername, signUpPassword));

			Executions.getCurrent().sendRedirect("home.zul");
		} else {
			Messagebox.show("Sign Up fields cannot be empty");
		}
	}
}
