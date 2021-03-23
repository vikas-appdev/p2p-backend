package com.gradlic.p2p.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.gradlic.p2p.model.Customer;
import com.gradlic.p2p.repository.CustomerRepository;
import com.gradlic.p2p.utils.Address;

@RestController
public class AuthToken {
	
	private static final String CLIENT_ID = "637395983133-m5cftbg3k5vtfc6t032bgta809a7u83m.apps.googleusercontent.com";
	
	@Autowired
	private CustomerRepository customerRepository;

	@PostMapping("api/v1/tokensignin")
	public Customer vaildateToken(@RequestBody String idTokenString) throws GeneralSecurityException, IOException {
		
		
		
		final NetHttpTransport transport = GoogleNetHttpTransport.newTrustedTransport();
	    final JacksonFactory jsonFactory = JacksonFactory.getDefaultInstance();
		
		GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
				// Specify the CLIENT_ID of the app that accesses the backend:
				.setAudience(Collections.singletonList(CLIENT_ID))
				// Or, if multiple clients access the backend:
			    //.setAudience(Arrays.asList(CLIENT_ID_1, CLIENT_ID_2, CLIENT_ID_3))
				.build();
		
		// (Receive idTokenString by HTTPS POST)
		
		GoogleIdToken idToken = verifier.verify(idTokenString);
		
		if(idToken!=null) {
			Payload payload = idToken.getPayload();
			
			//Print user identifier
			String userId = payload.getSubject();
			System.out.println(userId);
			
			// Get profile information from payload
			  String email = payload.getEmail();
			  boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
			 
			  //String name = (String) payload.get("name");
			  String pictureUrl = (String) payload.get("picture");
			  String locale = (String) payload.get("locale");
			  String familyName = (String) payload.get("family_name");
			  String givenName = (String) payload.get("given_name");
			  
			// Use or store profile information
			  
			  Customer customer = new Customer();
			  Address address = new Address();
			  address.setLatitude(0.0);
			  address.setLongitude(0.0);
			  customer.setId(userId);
			  customer.setFirstName(givenName);
			  customer.setLastName(familyName);
			  customer.setProfilePic(pictureUrl);
			  customer.setEmail(email);
			  customer.setLocale(locale);
			  customer.setEmailVerified(emailVerified);
			  customer.setAddress(address);
			  
			  Optional<Customer> optional = customerRepository.findById(userId);
			  if(!optional.isPresent()) {
				  Customer saved = customerRepository.save(customer);
				  return saved;
			  }
			  
			  return optional.get();
			  
			
			
		}
		return null;
	}

}
