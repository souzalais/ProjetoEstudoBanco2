package dao;

import java.util.ArrayList;

import utils.Pessoa;

public interface InterfacePessoaDAO {

	void adicionar(Pessoa p);
	void remover(Pessoa p);
	ArrayList<Pessoa> listar();
	void alterar(Pessoa p);

}

