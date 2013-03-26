package entidades;

public class Funcionario extends Pessoa {
	
	private int matricula;
	private String login;
	private String senha;
	
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
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
				+ ", getCelular()=" + getCelular() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}