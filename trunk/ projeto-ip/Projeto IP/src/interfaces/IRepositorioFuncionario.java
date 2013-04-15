package interfaces;

import dados.pessoas.Funcionario;
import exceptions.BIException;
import exceptions.IIException;

public interface IRepositorioFuncionario {

	 void inserirFuncionario(Funcionario funcionario);
	
	 void removerFuncionario(String cpf) throws IIException;
	
	 void atualizar(Funcionario funcionario);
	
	 Funcionario pesquisarFuncionario(String cpf) throws BIException;
	//sem parametro pq ainda n�o definimos o tipo d busca que acontecer�.
	
	 Iterator iterator();
}
