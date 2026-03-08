package mn.edu.num.usersoapservice.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import mn.edu.num.auth.LoginUserRequest;
import mn.edu.num.auth.LoginUserResponse;
import mn.edu.num.auth.RegisterUserRequest;
import mn.edu.num.auth.RegisterUserResponse;
import mn.edu.num.auth.ValidateTokenRequest;
import mn.edu.num.auth.ValidateTokenResponse;

@Endpoint
public class AuthEndpoint {

	private static final String NAMESPACE_URI = "http://num.edu.mn/auth";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "RegisterUserRequest")
	@ResponsePayload
	public RegisterUserResponse registerUser(@RequestPayload RegisterUserRequest request) {

		RegisterUserResponse response = new RegisterUserResponse();
		response.setMessage("User registered successfully");

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "LoginUserRequest")
	@ResponsePayload
	public LoginUserResponse loginUser(@RequestPayload LoginUserRequest request) {

		LoginUserResponse response = new LoginUserResponse();
		response.setToken("sample-token-123");

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "ValidateTokenRequest")
	@ResponsePayload
	public ValidateTokenResponse validateToken(@RequestPayload ValidateTokenRequest request) {

		ValidateTokenResponse response = new ValidateTokenResponse();

		if ("sample-token-123".equals(request.getToken())) {
			response.setValid(true);
		} else {
			response.setValid(false);
		}

		return response;
	}
}