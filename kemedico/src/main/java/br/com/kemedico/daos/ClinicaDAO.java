package br.com.kemedico.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.kemedico.model.Bairro;
import br.com.kemedico.model.Cidade;
import br.com.kemedico.model.Clinica;
import br.com.kemedico.model.Especializacao;
import br.com.kemedico.model.MeioPagamento;
import br.com.kemedico.model.PlanoSaude;
import br.com.kemedico.utils.Resultado;

@Repository
@Transactional
public class ClinicaDAO {
	@PersistenceContext
	EntityManager entityManager;

	public void salva(Clinica clinica) {
		entityManager.persist(clinica);
	}

	public List<Clinica> lista() {
		return entityManager.createQuery("select C from Clinica C", Clinica.class).getResultList();
	}

	public Clinica getById(long id) {
		return entityManager.createQuery("from Clinica where id = :id", Clinica.class).setParameter("id", id)
				.getSingleResult();
	}

	public void update(Clinica cli) {
		entityManager.merge(cli);
	}

	@SuppressWarnings("unchecked")
	public Resultado<Clinica> getFiltrados(List<PlanoSaude> planos, Cidade cd, List<Bairro> br,
			List<MeioPagamento> meios, Especializacao esp, String order, int quantidadePagina, int pagina) {
		Resultado<Clinica> result = new Resultado<>();
		StringBuilder builder = new StringBuilder();
		builder.append("db.Usuario.find({");
		builder.append("$query:{");
		if (planos != null) {
			if (!planos.isEmpty()) {
				builder.append("planos:");
				builder.append("{$in:");
				builder.append("[");
				for (int i = 0; i < planos.size(); i++) {
					builder.append(planos.get(i).getId());
					if (i < planos.size() - 1) {
						builder.append(",");
					}
				}
				builder.append("]");
				builder.append("}");
				builder.append(",");
			}

		}
		if (meios != null) {
			if (!meios.isEmpty()) {

				builder.append("meiosPagamento:");
				builder.append("{$in:");
				builder.append("[");
				for (int i = 0; i < meios.size(); i++) {
					builder.append(meios.get(i).getIdMeio());
					if (i < br.size() - 1) {
						builder.append(",");
					}
				}
				builder.append("]");
				builder.append("}");
				builder.append(",");
			}
		}
		if (cd != null) {
			builder.append("cidade_idCidade:");
			builder.append(cd.getIdCidade());
			builder.append(",");
		}
		if (br != null) {
			if (!br.isEmpty()) {

				builder.append("bairro_idBairro:");
				builder.append("{$in:");
				builder.append("[");
				for (int i = 0; i < br.size(); i++) {
					builder.append(br.get(i).getIdBairro());
					if (i < br.size() - 1) {
						builder.append(",");
					}
				}
				builder.append("]");
				builder.append("}");
				builder.append(",");
			}
		}

		if (esp != null) {
			builder.append("especialidades:");
			builder.append(esp.getIdEsp());

		}
		builder.append("}");
		builder.append(",");
		builder.append("$orderby:{");
		builder.append("premium:-1");
		if (order != null) {
			builder.append(",");
			if (order.equals("av")) {
				builder.append("mediaAvaliada:-1");
			}
			if (order.equals("pc")) {
				builder.append("cifroes_cifroes:1");
			}
		}
		builder.append("}");
		builder.append("}");

		builder.append(")");

		Query querybd = entityManager.createNativeQuery(builder.toString(), Clinica.class);
		System.out.println(builder.toString());
		System.out.println(querybd.getResultList());
		result.setQtTotal(querybd.getMaxResults());
		querybd.setMaxResults(quantidadePagina);
		querybd.setFirstResult(quantidadePagina * pagina);
		result.setResultados(querybd.getResultList());
		result.setQtResultados(result.getResultados().size());

		return result;

	}
}
