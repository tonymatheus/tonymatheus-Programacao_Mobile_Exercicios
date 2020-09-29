package horario;

public class Horario {
	public int segundos;

	public Horario() {
		segundos = 0;
	}

	public Horario(int hora, int minuto, int segundo) {
		setHora(hora);
		setMinuto(minuto);
		setSegundo(segundo);
	}

	public int getHora() {
		return conversorTempo()[0];
	}

	public void setHora(int hora) {
		if (!(hora >= 0 && hora <= 23))
			throw new IllegalStateException("Hora não é Válida");
		segundos += hora * 3600;
	}

	public int getMinuto() {
		return conversorTempo()[1];
	}

	public void setMinuto(int minuto) {
		if (!(minuto >= 0 && minuto <= 59)) {
			throw new IllegalStateException("Minuto não válido");
		}
		segundos += minuto * 60;
	}

	public int getSegundo() {
		return conversorTempo()[2];
	}

	public void setSegundo(int segundo) {
		if (!(segundo >= 0 && segundo <= 59)) {
			throw new IllegalStateException("Minuto Não válido");
		}
		segundos += segundo;
	}

	public void incrementarSegundo() {
		if (isLastSecond()) {
			segundos = 0;
		} else {
			segundos++;
		}
	}

	public void incrementaMinuto() {
		if (getMinuto() == 59) {
			segundos -= 60 * 59;
			incrementarHora();
		} else {
			segundos += 60;
		}
	}

	public void incrementarHora() {
		if (getHora() == 23)
			segundos -= 3600 * 23;
		else {
			segundos += 3600;

		}
	}

	public boolean isLastSecond() {
		int lastSecond = 86399;
		if (segundos == lastSecond)
			return true;
		return false;
	}

	private int[] conversorTempo() {
		int hora = this.segundos / 3600;
		int minuto = (this.segundos - 3600 * hora) / 60;
		int segundos = this.segundos - (3600 * hora) - (60 * minuto);

		int[] horario = { hora, minuto, segundos };
		return horario;
	}

	@Override
	public String toString() {
		int[] horario = conversorTempo();
		return  String.format("%02d:%02d:%02d", horario[0], horario[1], horario[2]);
	}
	

}
