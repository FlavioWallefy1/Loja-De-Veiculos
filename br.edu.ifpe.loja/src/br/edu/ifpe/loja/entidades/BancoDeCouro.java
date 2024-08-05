package br.edu.ifpe.loja.entidades;

public class BancoDeCouro extends VeiculoDecorator {
    private double precoAcessorio = 1500.0;

    public BancoDeCouro(IVeiculo veiculo) {
        super(veiculo);
    }

    @Override
    public double getPreco() {
        return super.getPreco() + precoAcessorio;
    }
}
