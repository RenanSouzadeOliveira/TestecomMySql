package br.etec.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.etec.model.Alunos;


public class AlunosJdbcDAO {

	private Connection conn;
	
	
	public AlunosJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	
	public void salvar(Alunos c) throws SQLException {
		String sql = "insert into alunos(nome, endereco, bairro) values ('"+c.getNome()+"','"+c.getEndereco()+"','"+c.getBairro()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
                prepareStatement.close();
	}
	
	public List<Alunos> listar() {
		String sql = "select * from alunos";
        System.out.println(sql);		
        List<Alunos> alunos = new ArrayList<Alunos>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String endereco = rs.getString("endereco");
				String bairro = rs.getString("bairro");
				
				Alunos aluno = new Alunos();
				aluno.setId(id);
				aluno.setNome(nome);
				aluno.setEndereco(endereco);
				aluno.setBairro(bairro);
				alunos.add(aluno);
				System.out.println(id);
				System.out.println(nome);
				System.out.println(endereco);
				System.out.println(bairro);
				
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alunos;
	}
	
/*	public Alunos findById(Integer id) {
		String sql = "select * from alunos where id= "+id;
        System.out.println(sql);		        
        Alunos aluno = null;
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				aluno = new Alunos();
				int idAluno = rs.getInt("id");
				String nome = rs.getString("nome");
				String endereco = rs.getString("endereco");
				String bairro = rs.getString("bairro");
				
				aluno.setId(id);
				aluno.setNome(nome);
				aluno.setEndereco(endereco);
				aluno.setBairro(bairro);
			
			}
			prepareStatement.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aluno;
	} */
}