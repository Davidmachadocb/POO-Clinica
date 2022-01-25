class Hora{
	private byte hr;
	private byte min;

	Hora(byte hora, byte minuto){
		if(horarioValido(hora, minuto)){
			hr = hora;
			min = minuto;
		}else{System.err.printl("Horário inválido. Tente novamente."); System.exit(0);}
	}

	private boolean horarioValido(byte hora, byte minuto){
		if((hora >= 0 && hora < 24) && (minuto >= 0 && minuto < 60)) return true;
		else return false;
	}

    public byte getHora(){
        return this.hr;
    }

    public byte getMin(){
        return this.min;
    }

    public void setHora(byte hr){
        if(hr >= 0 && hr < 24) this.hr = hr;
        else System.err.println("Erro: entrada fornecida inválida.");
    }

    public void setMin(byte min){
        if(min >= 0 && min < 60) this.min = min;
        else System.err.println("Erro: entrada fornecida inválida.");
    }

	private void mostraHorario(){
		System.out.printf("%02d:%02d\n", this.hr, this.min);
	}

    @Override
    public String toString(){
        mostraHorario();
        return "";
    }
}