package principal;

import controllers.AlunoControllerImpl;
import interfaces.AlunoController;

public class Main {

	public static void main(String[] args) {

		AlunoController alunoController = new AlunoControllerImpl();

		try {
			alunoController.consultarAlunos();
		} catch (Exception e) {
			System.out.println("ERRO" + e.getMessage());
		}

	}

}
