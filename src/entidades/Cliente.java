package entidades;


/**
 * Cliente e um objeto filho de Pessoa que herda todos os atributos de pessoa.
 * Ele e responsavel por representar os clientes de uma locadora. 
 * @author Tercio, Aleciano e Leonardo
 * @see entidades.Pessoa
 */



public class Cliente extends Pessoa {

/**
 * Cliente e um objeto filho de Pessoa que herda todos os atributos de pessoa
 * Ele e responsavel por representar os clientes de uma locadora. 
 * @see Pessoa
 */
	
	/**
	 * Construtor vazio
	 */
	public Cliente() {
		super();
		
	}

	/**Construtor que inicializa os atributos de cliente

	 * @param nome nome do cliente
	 * @param cpf cpf do cliente
	 * @param logradouro rua em que o cliente mora
	 * @param numero numero da casa do cliente
	 * @param bairro bairro em que o cliente mora
	 * @param cidade cidade onde o cliente mora
	 * @param cep CEP da rua do cliente
	 * @param email endereco eletronico do cliente
	 * @param fone numero do telefone residencial do cliente 
	 * @param celular numero do telefone movel do cliente

	 */

	public Cliente(String nome, String cpf, String logradouro, int numero,
			String bairro, String cidade, String cep, String email,
			String fone, String celular) {
		super(nome, cpf, logradouro, numero, bairro, cidade, cep, email, fone, celular);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Cliente [Nome()=" + getNome() + ", Cpf()=" + getCpf()
				+ ", Logradouro()=" + getLogradouro() + ", Numero()="
				+ getNumero() + ", Bairro()=" + getBairro()
				+ ", Cidade()=" + getCidade() + ", Cep()=" + getCep()
				+ ", Email()=" + getEmail() + ", Fone()=" + getFone()
				+ ", Celular()=" + getCelular() /*+ ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";*/
				;
	}
	
	
	
}
