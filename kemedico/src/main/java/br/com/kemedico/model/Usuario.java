package br.com.kemedico.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Table(name = "Usuario")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Usuario implements UserDetails{
	
	public Usuario(String email, String senha, String nomeCompleto, String numeroCelular, LocalDate dataNascimento,
			String numeroCpf, TipoUsuario tipoUsuario, List<Role> roles) {		
		this.email = email;
		this.senha = senha;
		this.nomeCompleto = nomeCompleto;
		this.numeroCelular = numeroCelular;
		this.dataNascimento = dataNascimento;
		this.numeroCpf = numeroCpf;
		this.tipoUsuario = tipoUsuario;
		this.roles = roles;
	}
	public Usuario() {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)	
	private long id;	
	private String email;
	private String senha;	
	private String nomeCompleto;	
	private String numeroCelular;	
	private LocalDate dataNascimento;	
	private String numeroCpf;	
	@ManyToOne(fetch = FetchType.EAGER)	
	private TipoUsuario tipoUsuario;
	@OneToMany(fetch = FetchType.EAGER)
	private List<Role> roles =  new ArrayList<Role>();

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getNumeroCelular() {
		return numeroCelular;
	}

	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNumeroCpf() {
		return numeroCpf;
	}

	public void setNumeroCpf(String numeroCpf) {
		this.numeroCpf = numeroCpf;
	}
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return roles;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", senha=" + senha + ", nomeCompleto=" + nomeCompleto
				+ ", numeroCelular=" + numeroCelular + ", dataNascimento=" + dataNascimento + ", numeroCpf=" + numeroCpf
				+ ", tipoUsuario=" + tipoUsuario + ", roles=" + roles + "]";
	}
	public Usuario getAtualizado(Usuario usr) {		
		if (this.senha == null) {
			this.senha = usr.getSenha();
		}
		if (this.nomeCompleto == null) {
			this.email = usr.getNomeCompleto();
		}
		if (this.numeroCelular == null) {
			this.email = usr.getNumeroCelular();
		}
		if (this.dataNascimento == null) {
			this.dataNascimento = usr.getDataNascimento();
		}
		if (this.numeroCpf == null) {
			this.email = usr.getNumeroCpf();
		}		
		if (this.roles == null) {
			this.roles = usr.getRoles();
		}
		if (this.tipoUsuario == null) {
			this.tipoUsuario = usr.getTipoUsuario();
		}
		return this;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
}
