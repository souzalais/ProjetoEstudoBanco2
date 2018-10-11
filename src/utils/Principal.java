package utils;

import dao.PessoaDAO;

public class Principal {

	public static void main(String[] args) {


		Pessoa p = new Pessoa(99129,"M",15,12819);
		
		
		PessoaDAO pDao = new PessoaDAO();
		//pDao.adicionar(p);
		
		pDao.buscarPorNome("M");
		//pDao.buscarPorRg(12819);
	}

}
