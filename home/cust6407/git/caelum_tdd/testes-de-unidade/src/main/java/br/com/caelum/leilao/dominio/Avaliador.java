package br.com.caelum.leilao.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Avaliador {
	private Double maiorDeTodos = Double.NEGATIVE_INFINITY;
	private List<Double> maioresValores;
	private Double menorDeTodos = Double.POSITIVE_INFINITY;

	public void Avalia(Leilao leilao) throws Exception {
		maioresValores = new ArrayList<Double>();
		Lance LanceAnterior = null;
		Map<Integer, Integer> lancePorIdUsuario = new HashMap<Integer, Integer>();

		if (leilao.getLances().size() == 0) {
			throw new RuntimeException("É preciso ao menos um lance para a avaliaçcao do leilão.");
		}

		for (Lance lance : leilao.getLances()) {
			if (LanceAnterior != null
					&& LanceAnterior.getValorProposto() <= lance
							.getValorProposto()) {
				throw new Exception(
						"Valor do lance não pode ser menor igual ao lance anterior");
			}

			if (LanceAnterior != null
					&& LanceAnterior.getUsuario().getNome() != lance
							.getUsuario().getNome()) {
				throw new Exception(
						"Não é permitido dois lances siguidos por um mesmo usuário");
			}

			if (lancePorIdUsuario.containsKey(lance.getUsuario().getId())
					&& lancePorIdUsuario.get(lance.getUsuario().getId()) >= 5) {
				throw new Exception(
						"Não é permitido mais de 5 lances por um mesmo usuário");
			}

			if (lancePorIdUsuario.containsKey(lance.getUsuario().getId())) {
				lancePorIdUsuario.put(lance.getUsuario().getId(),
						lancePorIdUsuario.get(lance.getUsuario().getId()) + 1);
			} else {
				lancePorIdUsuario.put(lance.getUsuario().getId(), 0);
			}

			if (lance.getValorProposto() > this.maiorDeTodos) {
				this.maiorDeTodos = lance.getValorProposto();
			}
			if (lance.getValorProposto() < this.menorDeTodos) {
				this.menorDeTodos = lance.getValorProposto();
			}
			this.maioresValores.add(lance.getValorProposto());

		}

		Collections.sort(this.maioresValores);
	}

	public Double getMaiorDeTodos() {
		return maiorDeTodos;
	}

	public List<Double> getMaioresValores() {
		return maioresValores;
	}

	public Double getMenorDeTodos() {
		return menorDeTodos;
	}

	public List<Double> getTreMaioresLances() {
		int i = this.maioresValores.size();
		int k = i;
		List<Double> maioresValores = new ArrayList<Double>();

		if (i > 3) {
			i = 3;
		}
		for (int j = 1; j <= i; j++) {
			maioresValores.add(this.maioresValores.get(k - j));
		}
		return maioresValores;
	}

	public void setMaiorDeTodos(Double maiorDeTodos) {
		this.maiorDeTodos = maiorDeTodos;
	}

	public void setMenorDeTodos(Double menorDeTodos) {
		this.menorDeTodos = menorDeTodos;
	}
}
