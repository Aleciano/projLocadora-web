package entidades;

/**
 * @author tercio
 *Esta classe e filha de Pessoa e modela um funcionario qualquer do mundo real
 *Funcionario possui 
 *uma matricula @param matricula
 *um login @param login
 *uma senha de login @param senha
 *e todos os atributos de uma Pessoa
 *
 */
/**
 * @author tercio
 *
 */
public class Funcionario extends Pessoa {

	private int matricula;
	private String login;
	private String senha;
	
	public int getMatricula() {
		return matricula;
	}
	/**
	 * @param matricula matricula do funcionario
	 */
	
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	/**
	 * @return o logim do funcionario
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @param login login do funcionario
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * @returna senha do funcionario
	 */
	public String getSenha() {
		return senha;
	}
	/**
	 * @param senha a senha do funcionario
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	/**construtor
	 * @param nome nome do funcionario
	 * @param cpf cpf do funcionario
	 * @param logradouro rua onde mora o funcionario
	 * @param numero numero da casa do funcionario
	 * @param bairro bairro onde mora o funcionario
	 * @param cidade cidade em que mora o funcionario
	 * @param cep CEP do funcionario
	 * @param email endereco eletronico do funcionario
	 * @param fone numero do telefone do funcionario
	 * @param celular numero do celular do funcionario
	 * @param matricula matricula do funcionario
	 * @param login login do funcionario
	 * @param senha senha do funcionario
	 */
	public Funcionario(String nome, String cpf, String logradouro, int numero,
			String bairro, String cidade, String cep, String email,
			String fone, String celular, int matricula, String login,
			String senha) {
		super(nome, cpf, logradouro, numero, bairro, cidade, cep, email, fone,
				celular);
		this.matricula = matricula;
		this.login = login;
		this.senha = senha;
	}
	/**
	 * construtor vazio
	 */
	public Funcionario(){
		
	}
	@Override
	public String toString() {
		return "Funcionario [matricula=" + matricula + ", login=" + login
				+ ", senha=" + senha + ", getMatricula()=" + getMatricula()
				+ ", getLogin()=" + getLogin() + ", getSenha()=" + getSenha()
				+ ", getNome()=" + getNome() + ", getCpf()=" + getCpf()
				+ ", getLogradouro()=" + getLogradouro() + ", getNumero()="
				+ getNumero() + ", getBairro()=" + getBairro()
				+ ", getCidade()=" + getCidade() + ", getCep()=" + getCep()
				+ ", getEmail()=" + getEmail() + ", getFone()=" + getFone()
				+ ", getCelular()=" + getCelular() /*+ ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";*/
				;
	}
	
	
}