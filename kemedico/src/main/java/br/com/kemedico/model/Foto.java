package br.com.kemedico.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.bson.types.ObjectId;

@Entity
public class Foto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private ObjectId idFoto;
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] fotoConteudo;
	public ObjectId getIdFoto() {
		return idFoto;
	}
	public void setIdFoto(ObjectId idFoto) {
		this.idFoto = idFoto;
	}
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
	

}
