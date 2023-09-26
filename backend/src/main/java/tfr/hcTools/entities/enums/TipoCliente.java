package tfr.hcTools.entities.enums;

public enum TipoCliente {
	
	PESSOAFISICA(1, "Pessoa Física"),
	EMPRESARIAL(2, "Empresarial"),
	PUBLICO(3, "Público");
	
	private int cod;
	private String descricao;
	
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static TipoCliente toEnum(Integer tipo) {
		if (tipo == null) {
			tipo = null;
		}
		
		for(TipoCliente x : TipoCliente.values()) {
			if(tipo.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Código inválido");
		
	}

}
