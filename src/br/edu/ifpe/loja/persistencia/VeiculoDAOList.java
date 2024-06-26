package br.edu.ifpe.loja.persistencia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import br.edu.ifpe.loja.entidades.Veiculo;

public class VeiculoDAOList implements IVeiculoDAO{

	private List<Veiculo> lista;
	private static VeiculoDAOList instancia;

	private VeiculoDAOList() {
		this.lista = new ArrayList<>();
	}

	protected static VeiculoDAOList getInstancia() { 
		if (instancia == null) {
			instancia = new VeiculoDAOList();
		}

		return instancia;
	}

	public void inserir(Veiculo veiculo) { 
		this.lista.add(veiculo);
	}

	public void editar(Veiculo veiculo) {
		for (Veiculo veiculos : lista) {
			if (veiculos.getPlaca().equalsIgnoreCase(veiculo.getPlaca())) {
                veiculos.setModelo(veiculo.getModelo());
                veiculos.setMarca(veiculo.getMarca());
                veiculos.setAnoFabricacao(veiculo.getAnoFabricacao());
                veiculos.setAnoModelo(veiculo.getAnoModelo());
                return;
            }
		} 
	}



	public void remover(String placa) {
		for (Iterator<Veiculo> iterator = lista.iterator(); iterator.hasNext();) {
			Veiculo veiculo = iterator.next();
			if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
				iterator.remove();
				return;
			}
		}
	}

	public List<Veiculo> listarTodos() {
		return lista;
	}

	public List<Veiculo> consultar(String modelo) {
		List<Veiculo> veiculosEncontrados = new ArrayList<>();
		for (Veiculo veiculo : lista) {
			if (veiculo.getModelo().equalsIgnoreCase(modelo)) {
				veiculosEncontrados.add(veiculo);
			}
		}
		return veiculosEncontrados;
	}

}
