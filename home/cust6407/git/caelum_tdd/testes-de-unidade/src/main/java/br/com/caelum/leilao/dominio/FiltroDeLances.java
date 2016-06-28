package br.com.caelum.leilao.dominio;

import java.util.ArrayList;
import java.util.List;

public class FiltroDeLances {
	public List<Lance> filtra(List<Lance> lances) {
		List<Lance> resultado = new ArrayList<Lance>();

		for (Lance lance : lances) {
			if (lance.getValorProposto() > 1000.00
					&& lance.getValorProposto() < 3000.00) {
				resultado.add(lance);
			} else if (lance.getValorProposto() > 500.00
					&& lance.getValorProposto() < 700.00) {
				resultado.add(lance);
			} else if (lance.getValorProposto() > 5000.00) {
				resultado.add(lance);
			}
		}
		return resultado;
	}
}
