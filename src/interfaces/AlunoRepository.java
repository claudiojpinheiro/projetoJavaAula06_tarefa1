package interfaces;

import java.util.List;

import entities.Aluno;

public interface AlunoRepository {

	void create(Aluno aluno) throws Exception;

	void update(Aluno aluno) throws Exception;

	void delete(Integer idAluno) throws Exception;

	List<Aluno> findAll() throws Exception; 

}
