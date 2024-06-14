package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Aluno;
import factories.ConnectionFactory;
import interfaces.AlunoRepository;

public class AlunoRepositoryImpl implements AlunoRepository {

	@Override
	public void create(Aluno aluno) throws Exception {
				
		Connection connection = ConnectionFactory.getConnection();
		String sql = "insert into aluno(idAluno, nome, matricula, cpf) values(?,?,?,?)";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, aluno.getIdAluno());
		statement.setString(2, aluno.getNome());
		statement.setString(3, aluno.getMatricula());
		statement.setString(4, aluno.getCpf());
		statement.execute();
		
		connection.close();
				

	}

	@Override
	public void update(Aluno aluno) throws Exception {
		
		Connection connection = ConnectionFactory.getConnection();
		String sql = "update aluno set nome=?, matricula=?, cpf=? where idAluno = ?";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, aluno.getNome());
		statement.setString(2, aluno.getMatricula());
		statement.setString(3, aluno.getCpf());
		statement.setObject(4,aluno.getIdAluno());
		statement.execute();
		
		connection.close();
				

	}
	
	@Override
	public void delete(Integer idAluno) throws Exception {
		
		Connection connection = ConnectionFactory.getConnection();
		String sql = " delete from aluno where idAluno = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, idAluno);
		statement.execute();
				
		connection.close();

	}

	@Override
	public List<Aluno> findAll() throws Exception {
		
		Connection connection = ConnectionFactory.getConnection();
		String sql = "select * from aluno";
		PreparedStatement statement = connection.prepareStatement(sql);		
		
		ResultSet resultSet = statement.executeQuery();
		
		List<Aluno> lista = new ArrayList<Aluno>();
		
			while(resultSet.next()) { 
				Aluno aluno = new Aluno();
				aluno.setIdAluno(resultSet.getInt("idAluno"));
				aluno.setNome(resultSet.getString("nome"));
				aluno.setMatricula(resultSet.getString("matricula"));
				aluno.setCpf(resultSet.getString("cpf"));
				
				lista.add(aluno);
			}
		
			connection.close();
		
		
		return lista;
	}

}
