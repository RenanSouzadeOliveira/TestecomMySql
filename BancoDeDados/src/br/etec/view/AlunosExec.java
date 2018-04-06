package br.etec.view;

import java.sql.Connection;

import br.etec.model.Alunos;
import br.etec.persistence.AlunosJdbcDAO;
import br.etec.persistence.Conexao;

public class AlunosExec {
	public static void main(String args[]) {
		Alunos alunos = new Alunos();
		try {
			
			alunos.setNome("Jeferson Roberto de Lima");
			alunos.setEndereco("Av Águia de Haia, 2600");
			alunos.setBairro("Jd São Nicolau");
			
			Connection connection = Conexao.getConnection();
			AlunosJdbcDAO alunosJdbcDao = new AlunosJdbcDAO(connection);
			
			//alunosJdbcDao.salvar(alunos);
			alunosJdbcDao.listar();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
