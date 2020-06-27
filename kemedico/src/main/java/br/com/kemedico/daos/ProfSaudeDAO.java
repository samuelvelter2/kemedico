package br.com.kemedico.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.kemedico.model.Bairro;
import br.com.kemedico.model.Cidade;
import br.com.kemedico.model.Especializacao;
import br.com.kemedico.model.MeioPagamento;
import br.com.kemedico.model.PlanoSaude;
import br.com.kemedico.model.ProfissionalSaude;
import br.com.kemedico.utils.Resultado;

@Repository
@Transactional
public class ProfSaudeDAO {
	@PersistenceContext
	private EntityManager entityManager;

	public void salva(ProfissionalSaude saude) {
		entityManager.persist(saude);
	}

	public List<ProfissionalSaude> lista() {
		return entityManager.createQuery("select P from ProfissionalSaude P", ProfissionalSaude.class).getResultList();
	}

	public void update(ProfissionalSaude prof) {
		entityManager.merge(prof);
	}

	public ProfissionalSaude getById(long id) {

		TypedQuery<ProfissionalSaude> query = entityManager
				.createQuery("select P from ProfissionalSaude P where P.id = :id", ProfissionalSaude.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public Resultado<ProfissionalSaude> getFiltrados(List<PlanoSaude> planos, Cidade cd, List<Bairro> br,
			List<MeioPagamento> meios, Especializacao esp, String order, int quantidadePagina, int pagina) {
		Resultado<ProfissionalSaude> result = new Resultado<>();
		StringBuilder builder = new StringBuilder();
		builder.append("db.Usuario.find({");
		builder.append("$query:{");
		if (planos != null) {
			if (!planos.isEmpty()) {
				builder.append("planosParticular:");
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
					if (i < meios.size() - 1) {
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
			builder.append("$or : [{especializacao1_idEsp :");
			builder.append(esp.getIdEsp());
			builder.append("}");
			builder.append(",");
			builder.append("{");
			builder.append("especializacao2_idEsp:");
			builder.append(esp.getIdEsp());
			builder.append("}");
			builder.append("]");

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

		System.out.println(builder.toString());

		Query querybd = entityManager.createNativeQuery(builder.toString(), ProfissionalSaude.class);
		List<ProfissionalSaude> list = querybd.getResultList();

		System.out.println(list);
		result.setQtTotal(querybd.getMaxResults());
		querybd.setMaxResults(quantidadePagina);
		querybd.setFirstResult(quantidadePagina * pagina);
		result.setResultados(list);
		result.setQtResultados(result.getResultados().size());

		return result;

	}

	public List<ProfissionalSaude> getByNomeParcial(String nomeParcial) {
		return entityManager
				.createQuery("from ProfissionalSaude where nomeCompleto like %:nome%", ProfissionalSaude.class)
				.setParameter("nome", nomeParcial).getResultList();
	}

}
