package com.keystoreapi_teste;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public class Main {

	public static void main(String[] args) throws KeyStoreException {
		
		char[] pwdArray = "password".toCharArray();
		
		KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType()); // ou KeyStore.getInstance("JKS");
		
		try {
			
			ks.load(null, pwdArray);			//O load pode ser usado para abrir uma keystore existente, poré quando passado null no
												// primeiro parametro criamos uma novas
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (CertificateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		//ARMAZENANDO A KEYSTORE
		
		try (FileOutputStream fos = new FileOutputStream("../com.keystoreapi_teste/src/com/keystoreapi_teste/pasta_de_keystore/newKeyStoreFileName.jks")) {
		    try {
		    	
				ks.store(fos, pwdArray);
				
			} catch (KeyStoreException e) {
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (CertificateException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//CARREGANDO UMA KEY STORE EXISTENTE
		
		KeyStore keyStoreExistente = KeyStore.getInstance("JKS");
		
		try {
			keyStoreExistente.load(new FileInputStream("../com.keystoreapi_teste/src/com/keystoreapi_teste/pasta_de_keystore/newKeyStoreFileName.jks"), pwdArray);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (CertificateException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//IMPORTANDO CERTIFICADO
		
		keyStoreExistente.setCertificateEntry("", null);
		
	}
}
