package br.com.kemedico.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.kemedico.model.MeioPagamento;
import br.com.kemedico.model.PrecoCifrao;

@Repository
@Transactional
public class PagamentoDAO {
	@PersistenceContext
	EntityManager manager;

	public void salva(MeioPagamento mp) {
		manager.persist(mp);
	}

	public List<MeioPagamento> getAll() {
		if (!hasAny()) {
			String[] nomeMeio = { "cartão de crédito", "cartão de débito", "dinheiro", "cheque", "Pic Pay" };
			for (int i = 0; i < nomeMeio.length; i++) {
				salva(new MeioPagamento(nomeMeio[i]));
			}
		}
		return manager.createQuery("select mp from MeioPagamento mp", MeioPagamento.class).getResultList();
	}

	public boolean hasAny() {
		try {
			manager.createQuery("select mp from MeioPagamento mp", MeioPagamento.class).getResultList().get(0);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public List<PrecoCifrao> getCifroes() {
		try {
			manager.createQuery("from PrecoCifrao", PrecoCifrao.class).getResultList().get(0);
		} catch (Exception e) {
			String[] cifroes = { "de R$ 80,00 a R$159,00", "de R$ 160,00 a R$239,00", "de R$ 240,00 a R$319,00",
					"de R$ 320,00 a R$399,00", "de R$ 400,00 pra cima" };
			for (int i = 1; i <= cifroes.length; i++) {
				salvacifra(new PrecoCifrao(i, cifroes[i - 1]));
			}
		}
		return manager.createQuery("from PrecoCifrao order by cifroes", PrecoCifrao.class).getResultList();
	}

	public void salvacifra(PrecoCifrao pc) {
		manager.persist(pc);
	}

	public List<MeioPagamento> getAllByIds(List<MeioPagamento> lista) {
		ArrayList<MeioPagamento> list = new ArrayList<MeioPagamento>();
		if (lista != null) {
			for (int i = 0; i < lista.size(); i++) {
				list.add(getById(lista.get(i).getIdMeio()));

			}
		}

		return list;
	}

	public MeioPagamento getById(Long id) {
		return manager.createQuery("from MeioPagamento where idMeio = :id", MeioPagamento.class).setParameter("id", id)
				.getSingleResult();
	}
}
