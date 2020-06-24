package br.com.kemedico.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Foto {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long idFoto;
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] fotoConteudo;
	
	public byte[] getFoto() {
		return fotoConteudo;
	}
	public void setFoto(byte[] fotoConteudo) {
		this.fotoConteudo = fotoConteudo;
	}
	public static Foto getFoto(byte[] fotoConteudo) {
		Foto foto =  new Foto();
		foto.setFoto(fotoConteudo);
		return foto;
		
	}
	public long getIdFoto() {
		return idFoto;
	}
	public void setIdFoto(long idFoto) {
		this.idFoto = idFoto;
	}
	@Override
	public String toString() {
		return "Foto [idFoto=" + idFoto + "]";
	}
	

}
