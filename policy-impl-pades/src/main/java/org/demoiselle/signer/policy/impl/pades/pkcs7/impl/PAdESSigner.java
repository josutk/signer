package org.demoiselle.signer.policy.impl.pades.pkcs7.impl;

import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.cert.Certificate;

import org.demoiselle.signer.policy.engine.factory.PolicyFactory.Policies;
import org.demoiselle.signer.policy.impl.cades.SignerAlgorithmEnum;
import org.demoiselle.signer.policy.impl.cades.pkcs7.impl.CAdESSigner;
import org.demoiselle.signer.policy.impl.pades.pkcs7.PCKS7Signer;

public class PAdESSigner implements PCKS7Signer{

	private CAdESSigner cAdESSigner;
	
	
	public PAdESSigner() {
		cAdESSigner = new CAdESSigner(null, Policies.AD_RB_PADES_1_1, true);
	}

	public PAdESSigner(Policies police) {
		cAdESSigner = new CAdESSigner(null, police , true);
	}
	public PAdESSigner(String algorithm, Policies police) {
		cAdESSigner = new CAdESSigner(algorithm, police , true);
	}
	
	@Override
	public void setProvider(Provider provider) {
		cAdESSigner.setProvider(provider);
	}

	@Override
	public void setPrivateKey(PrivateKey privateKey) {
		cAdESSigner.setPrivateKey(privateKey);
	}

	@Override
	public void setPublicKey(PublicKey publicKey) {
		cAdESSigner.setPublicKey(publicKey);
	}

	@Override
	public void setAlgorithm(String algorithm) {
		cAdESSigner.setAlgorithm(algorithm);
	}

	@Override
	public void setAlgorithm(SignerAlgorithmEnum algorithm) {
		cAdESSigner.setAlgorithm(algorithm);
	}

	@Override
	/**
	 * Not for PAdES
	 * @param content
	 * @return null
	 */
	public byte[] doAttachedSign(byte[] content) {
		return null;
	}

	@Override
	public byte[] doDetachedSign(byte[] content) {
		return cAdESSigner.doDetachedSign(content);
	}

	@Override
	public Provider getProvider() {
		return cAdESSigner.getProvider();
	}

	@Override
	public PrivateKey getPrivateKey() {
		return cAdESSigner.getPrivateKey();
	}

	@Override
	public String getAlgorithm() {
		return cAdESSigner.getAlgorithm();
	}

	@Override
	public PublicKey getPublicKey() {
		return cAdESSigner.getPublicKey();
	}

	@Override
	public byte[] doHashSign(byte[] hash) {
		return cAdESSigner.doHashSign(hash);
	}

	@Override
	public void setCertificates(Certificate[] certificate) {
		cAdESSigner.setCertificates(certificate);
	}

	@Override
	public void setSignaturePolicy(Policies signaturePolicy) {
		cAdESSigner.setSignaturePolicy(signaturePolicy);
	}
}
