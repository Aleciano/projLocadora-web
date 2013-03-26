package entidades;


/**
 * @author tercio, aleciano e leonardo
 *
 *Cliente é um objeto filho de pessoa que herda todos os atributos de pessoa
 *Ele é responsavel por representar os clientes de uma locadora de video  
 *
 */

public class Cliente extends Pessoa {

	/**
	 * Construtor vazio
	 */
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

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
	public Cliente(String nome, String cpf, String logradouro, int numero,
			String bairro, String cidade, String cep, String email,
			String fone, String celular) {
		super(nome, cpf, logradouro, numero, bairro, cidade, cep, email, fone, celular);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Cliente [getNome()=" + getNome() + ", getCpf()=" + getCpf()
				+ ", getLogradouro()=" + getLogradouro() + ", getNumero()="
				+ getNumero() + ", getBairro()=" + getBairro()
				+ ", getCidade()=" + getCidade() + ", getCep()=" + getCep()
				+ ", getEmail()=" + getEmail() + ", getFone()=" + getFone()
				+ ", getCelular()=" + getCelular() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
}
