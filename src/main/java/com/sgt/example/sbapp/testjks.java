package com.sgt.example.sbapp;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
public class testjks {

	public static void main(String[] argv) throws Exception {
		
		String path = "C:\\Users\\n130065\\workspace\\simplesrpingbootapp\\src\\main\\resources\\apis-sandbox.jks";
	    FileInputStream is = new FileInputStream(path);

	    KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
	    keystore.load(is, "P4ssW0rD".toCharArray());

	    String alias = "testapisecret";

	    Key key = keystore.getKey(alias, "P4ssW0rD".toCharArray());
	    //  if (key instanceof PrivateKey) {
	      // Get certificate of public key
	      Certificate cert = keystore.getCertificate(alias);

	      // Get public key
	      PublicKey publicKey = cert.getPublicKey();

	      // Return a key pair
	      new KeyPair(publicKey, (PrivateKey) key);
	      System.out.println("llll "+publicKey.getAlgorithm());
	      System.out.println("llll "+publicKey.getEncoded());
	      byte[] fileBytes = Files.readAllBytes(Paths.get(path));
	      System.out.println( new String( fileBytes, "US-ASCII" ));
	      // }
	  }
	}
