/**
 * 
 */
package entidades;

/**
 * @author aleciano, tercio e leonardo
 * Pessoa é classe abstrata que pode ser utilizada para modelar qualquer
 * objeto do mundo real que seja um ser humano
 * 
 *
 * 
 */
public abstract class Pessoa {

	private String nome;
	private String cpf;
	private String logradouro;
	private int numero;
	private String bairro;
	private String cidade;
	private String cep;
	private String email;
	private String fone;
	private String celular;

	/**Construtor que inicializa os atributos de cliente
	 * @param nome nome do cliente
	 * @param cpf cpf do cliente
	 * @param logradouro rua em que o cliente mora
	 * @param numero numero da casa do cliente
	 * @param bairro bairro em que o cliente mora
	 * @param cidade cidade onde o cliente mora
	 * @param cep CEP da rua do cliente
	 * @param email endereço eletrônico do cliente
	 * @param fone numero do telefone residencial do cliente 
	 * @param celular numero do telefone móvel do cliente
	 */
	public Pessoa(String nome, String cpf, String logradouro, int numero,
			String bairro, String cidade, String cep, String email,
			String fone, String celular) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
		this.email = email;
		this.fone = fone;
		this.celular = celular;
	}

	/**
	 * @return o nome de pessoa
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome é o nome que pessoa deve receber
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return o CPF de pessoa
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf é o CPF de pessoa
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return o nome da rua que pessoa mora
	 */ 
	public String getLogradouro() {
		return logradouro;
	}

	/**
	 * @param logradouro o nome da rua que pessoa mora
	 */
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	/**
	 * @return o numero da casa de pessoa
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero numero da casa de pessoa
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return o bairro de pessoa
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * @param bairro o bairro que pessoa mora
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * @return cidade que pessoa mora
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @param cidade a cidade que pessoa mora
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * @return o CEP da rua que pessoa mora
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * @param cep o CEP da rua que pessoa mora
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * @return o e-mail de pessoa
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email o e-mail de pessoa
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return o numero de telefone de pessoa
	 */
	public String getFone() {
		return fone;
	}

	/**
	 * @param fone o numero de telefone de pessoa
	 */
	public void setFone(String fone) {
		this.fone = fone;
	}

	/**
	 * @return o numero do celular de pessoa
	 */
	public String getCelular() {
		return celular;
	}

	/**
	 * @param celular o numero do celular de pessoa
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}

	/**
	 * construtor vazio
	 */
	public Pessoa() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", cpf=" + cpf + ", logradouro="
				+ logradouro + ", numero=" + numero + ", bairro=" + bairro
				+ ", cidade=" + cidade + ", cep=" + cep + ", email=" + email
				+ ", fone=" + fone + ", celular=" + celular + "]";
	}

	
	
}
