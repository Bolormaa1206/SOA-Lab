package mn.edu.num.userjsonservice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mn.edu.num.userjsonservice.model.UserProfile;
import mn.edu.num.userjsonservice.service.SoapAuthClient;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/users")
public class UserController {

	private final SoapAuthClient soapAuthClient;
	private final Map<String, UserProfile> users = new HashMap<>();

	public UserController(SoapAuthClient soapAuthClient) {
		this.soapAuthClient = soapAuthClient;

		// sample user
		users.put("1",
				new UserProfile("1", "Bolormaa", "bolormaa@gmail.com", "Software engineering student", "99112233"));
	}

	// CREATE
	@PostMapping
	public Object createUser(@RequestBody UserProfile userProfile,
			@RequestHeader(value = "Authorization", required = false) String token) {

		if (token == null || !soapAuthClient.validateToken(token)) {
			return "Access denied";
		}

		users.put(userProfile.getId(), userProfile);
		return userProfile;
	}

	// READ
	@GetMapping("/{id}")
	public Object getUser(@PathVariable String id,
			@RequestHeader(value = "Authorization", required = false) String token) {

		if (token == null || !soapAuthClient.validateToken(token)) {
			return "Access denied";
		}

		UserProfile user = users.get(id);

		if (user == null) {
			return "User not found";
		}

		return user;
	}

	// UPDATE
	@PutMapping("/{id}")
	public Object updateUser(@PathVariable String id, @RequestBody UserProfile userProfile,
			@RequestHeader(value = "Authorization", required = false) String token) {

		if (token == null || !soapAuthClient.validateToken(token)) {
			return "Access denied";
		}

		if (!users.containsKey(id)) {
			return "User not found";
		}

		userProfile.setId(id);
		users.put(id, userProfile);

		return userProfile;
	}

	// DELETE
	@DeleteMapping("/{id}")
	public Object deleteUser(@PathVariable String id,
			@RequestHeader(value = "Authorization", required = false) String token) {

		if (token == null || !soapAuthClient.validateToken(token)) {
			return "Access denied";
		}

		UserProfile removed = users.remove(id);

		if (removed == null) {
			return "User not found";
		}

		return "User deleted successfully";
	}
}