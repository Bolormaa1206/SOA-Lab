package mn.edu.num.userjsonservice.service;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import jakarta.annotation.PostConstruct;
import mn.edu.num.auth.ValidateTokenRequest;
import mn.edu.num.auth.ValidateTokenResponse;

@Service
public class SoapAuthClient {

	private final WebServiceTemplate webServiceTemplate = new WebServiceTemplate();

	@PostConstruct
	public void init() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("mn.edu.num.auth");
		try {
			marshaller.afterPropertiesSet();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		webServiceTemplate.setMarshaller(marshaller);
		webServiceTemplate.setUnmarshaller(marshaller);
		webServiceTemplate.setDefaultUri("http://localhost:8080/ws");
	}

	public boolean validateToken(String token) {
		ValidateTokenRequest request = new ValidateTokenRequest();
		request.setToken(token);

		ValidateTokenResponse response = (ValidateTokenResponse) webServiceTemplate.marshalSendAndReceive(request);

		return response.isValid();
	}
}