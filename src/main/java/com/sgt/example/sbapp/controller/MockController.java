package com.sgt.example.sbapp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.cryptacular.bean.KeyStoreFactoryBean;
import org.cryptacular.io.FileResource;
import org.cryptacular.io.Resource;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;
 
 




@RestController
@RequestMapping(value = "/Applicationmock")
public class MockController {

 
	
 	@Value("${http.client.ssl.key-store:C:\\datos\\SSL\\testapis\\apis-sandbox.jks}")
	private String jkspath;
	@GetMapping("failure")
	public ResponseEntity<R4jResponse> backendFailure() {
		throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "This is a remote exception");
	}

	@GetMapping("success")
//	public ResponseEntity<R4jResponse> backendBSuccess() {
	public ResponseEntity<R4jResponse> backendBSuccess(HttpServletRequest httpservletrequest) throws IOException, KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException, CertificateException {
		R4jResponse response = new R4jResponse();
		response.setOutputcode("002");
		response.setOutputmessage("Service success: SANPIS Microservices with Azure");
		//return new ResponseEntity<>(response, HttpStatus.OK);
		System.out.println("CABECERA Authorization ************* "+httpservletrequest.getHeader("Authorization"));
		
		
		 Resource resourceS = new FileResource(new File(jkspath));
         Resource resourceK = new FileResource(new File(jkspath));
        final KeyStore trustStore = new KeyStoreFactoryBean(resourceS, "jks",
        		"P4ssW0rD").newInstance();
        
        final KeyStore keyStore = new KeyStoreFactoryBean(resourceK, "jks",
        		"P4ssW0rD").newInstance();
		
		
        //System.out.println("llll "+keyStore.getCertificate("testapisecret"));
        System.out.println("llll "+keyStore.getCertificate("sslpostgresql"));
        
		return new ResponseEntity<>(response  , HttpStatus.OK);
	}

	@GetMapping("ignore")
	public ResponseEntity<R4jResponse> ignore() {

		R4jResponse response = new R4jResponse();
		response.setOutputcode("003");
		response.setOutputmessage("Service ignore");
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		// throw new BusinessLogicException("This exception is ignored by the
		// CircuitBreaker");
	}

	@PostMapping("successtimeout")
	public ResponseEntity<R4jResponse> timeout(@RequestBody @Valid R4jRequest r4jrequest) {
		System.out.println("successtimeout IN");
		
		System.out.println("successtimeout  " + r4jrequest.getInputcode());
		System.out.println("successtimeout  " + r4jrequest.getInputmessage());
		

		try {
			TimeUnit.SECONDS.sleep(60);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date date= new Date();
		 long time = date.getTime();
		 Timestamp ts = new Timestamp(time);
		 
		R4jResponse response = new R4jResponse();
		response.setOutputcode("004");
		response.setOutputmessage("Service timeout at: "+ts.toString());
		System.out.println("successtimeout OUT " + response);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

 
	 
	
	@GetMapping("/sb/my-profile/")
	public ResponseEntity<R4jResponse> me() {

		R4jResponse response = new R4jResponse();
		response.setOutputcode("003");
		response.setOutputmessage("Service ignore");
		return new ResponseEntity<>(response, HttpStatus.OK);
		// throw new BusinessLogicException("This exception is ignored by the
		// CircuitBreaker");
	}
}
