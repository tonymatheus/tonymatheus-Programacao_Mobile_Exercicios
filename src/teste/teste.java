package teste;
import horario.*;

public class teste {

	public static void main(String[] args) {
		Horario horario = new Horario();
		
		for(int i = 0; i <= 2000; i++) {
			System.out.println(horario);
			horario.incrementaMinuto();
			horario.incrementarSegundo();
			horario.incrementarHora();
		}

	}

}
