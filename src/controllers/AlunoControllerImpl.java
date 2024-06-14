package controllers;

import java.util.List;
import java.util.Scanner;

import entities.Aluno;
import interfaces.AlunoController;
import interfaces.AlunoRepository;

public class AlunoControllerImpl implements AlunoController {

	@Override
	public void cadastrarAluno() {

		try {
			Scanner scanner = new Scanner(System.in);
			Aluno aluno = new Aluno();
			
			System.out.println("ID DO ALUNO: ");
			aluno.setIdAluno(Integer.parseInt(scanner.nextLine()));
			
			System.out.println("NOME DO ALUNO: ");
			aluno.setNome(scanner.nextLine());

			System.out.println("MATRICULA DO ALUNO: ");
			aluno.setMatricula(scanner.nextLine());
			
			System.out.println("CPF DO ALUNO: ");
			aluno.setCpf(scanner.nextLine());
			
			AlunoRepository alunoRepository = new AlunoRepositoryImpl();
			alunoRepository.create(aluno);
			
			System.out.println("/NALUNO CADASTRADO COM SUCESSO.");

			scanner.close();

		} catch (Exception e) {
			System.out.println("ERRO" + e.getMessage());

		}

	}

	@Override
	public void atualizarAluno(){

		try {
			
			Scanner scanner = new Scanner(System.in);
			Aluno aluno = new Aluno();
			
			System.out.println("ID DO ALUNO: ");
			aluno.setIdAluno(Integer.parseInt(scanner.nextLine()));
			
			System.out.println("NOME DO ALUNO: ");
			aluno.setNome(scanner.nextLine());

			System.out.println("MATRICULA DO ALUNO: ");
			aluno.setMatricula(scanner.nextLine());
			
			System.out.println("CPF DO ALUNO: ");
			aluno.setCpf(scanner.nextLine());
			
			AlunoRepository alunoRepository = new AlunoRepositoryImpl();
			alunoRepository.update(aluno);
			
			System.out.println("/NALUNO ATUALIZADO COM SUCESSO.");

			scanner.close();

		} catch (Exception e) {
			System.out.println("ERRO" + e.getMessage());

		}

	}

	@Override
	public void deletarAluno() {
		

		try {

			Scanner scanner = new Scanner(System.in);
			
			System.out.println("\nEXCLUSÃO DE PESSOA:");

			System.out.println("ID DO ALUNO");
			int  idAluno = Integer.parseInt(scanner.nextLine());
			
			

			AlunoRepository  alunoRepository = new AlunoRepositoryImpl();
			alunoRepository.delete(idAluno);

			System.out.println("\nPESSOA EXCLUIDO COM SUCESSO!");
			
			scanner.close();
			
		} catch (Exception e) {
			System.out.println("\nERRO: " + e.getMessage());
		}
	}
	@Override
	public void consultarAlunos() { 
		try {

			System.out.println("\nCONSULTA DE ALUNOS:");

			AlunoRepository  alunoRepository = new AlunoRepositoryImpl();
			List<Aluno> lista = alunoRepository.findAll();

			for (Aluno aluno : lista) {

				System.out.println("ID.....: " + aluno.getIdAluno());
				System.out.println("NOME...: " + aluno.getNome());
				System.out.println("MATRICULA..: " + aluno.getMatricula());
				System.out.println("MATRICULA..: " + aluno.getCpf());
				System.out.println("..");
			}
		} catch (Exception e) {
			System.out.println("\nERRO: " + e.getMessage());
		}
	}
}