package br.com.kemedico.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import br.com.kemedico.daos.UsuarioDAO;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private UsuarioDAO usuarioDao;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/cadastro/**").permitAll().antMatchers("/login/").permitAll()
				.antMatchers("/premium/beneficios").permitAll().antMatchers(HttpMethod.GET, "/pesquisa/*").permitAll()
				.antMatchers(HttpMethod.POST, "/pesquisa/*").permitAll().antMatchers("/profsaude/*").permitAll()
				.antMatchers("/clinica/*").permitAll().antMatchers("/media/imagem/**").permitAll()
				.antMatchers("/minhaconta/***").authenticated().antMatchers("/*").permitAll().anyRequest()
				.authenticated().and().formLogin().loginPage("/login").failureForwardUrl("/cadastro")
				.defaultSuccessUrl("/").permitAll().and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll().logoutSuccessUrl("/login");

	}

	@Override
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioDao).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}

}
