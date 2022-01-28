/**
 * A classe encapsula os atributos hr e min, que simularão as horas e os minutos de um horário
 * Essa classe será usada na classe Consulta
 * @author Ítalo Moraes
 * @version 1.0
 */
class Hora{
	private byte hr;
	private byte min;

    /**
     * Construtor da classe. Inicializa os atributos com os dados fornecidos pelo usuário
     * @param hora dado da hora fornecida pelo usuário
     * @param minuto dado do minuto fornecido pelo usuário
     */
	Hora(byte hora, byte minuto){
		if(horarioValido(hora, minuto)){
			hr = hora;
			min = minuto;
		}else{System.err.println("Horário inválido. Tente novamente.");}
	}

    /**
     * Função que verifica se o horário (conjunto da hora e do minuto fornecido) é válido
     * i.e., obedece as restrições 0 <= hora <= 24 e 0 <= minuto <= 59
     * @param hora o dado da hora fornecido
     * @param minuto o dado minuto fornecido
     * @return true se o horário é válido, e false caso contrário
     */
	private boolean horarioValido(byte hora, byte minuto){
		if((hora >= 0 && hora < 24) && (minuto >= 0 && minuto < 60)) return true;
		else return false;
	}

    /**
     * Getter do atributo hora
     * @return o dado da hora da instância
     */
    public byte getHora(){
        return this.hr;
    }

    /**
     * Getter do atributo minuto
     * @return o dado do minuto da instância
     */
    public byte getMin(){
        return this.min;
    }

    /**
     * Setter do atributo hora. Verifica se o novo dado é válido e atualiza o horário caso seja
     * @param hr o novo dado da hora
     */
    public void setHora(byte hr){
        if(hr >= 0 && hr < 24) this.hr = hr;
        else System.err.println("Erro: entrada fornecida inválida.");
    }

    /**
     * Setter do atributo minuto. Verifica se o novo dado é válido e atualiza o horário caso seja
     * @param min
     */
    public void setMin(byte min){
        if(min >= 0 && min < 60) this.min = min;
        else System.err.println("Erro: entrada fornecida inválida.");
    }

    /**
     * Imprime os dados da instância de forma organizada
     */
    public String toString(){
        return String.format("%02d:%02d", this.hr, this.min);
    }
}
