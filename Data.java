class Data {
    private byte dia;
    private byte mes;
    private int ano;
    
    Data(byte d, byte m, int a){
        if(dataValida(d, m, a)){
            dia = d; mes = m; ano = a;
        }else{System.out.println("Data inválida! Operação encerrada."); System.exit(0);}
    }

    private boolean dataValida(byte d, byte m, int a){
        if(m > 12 || m < 1) return false;

        if(m == 4 || m == 6 || m == 9 || m == 11){
            if(d > 30 || d < 1) return false;
        }else if(m == 2){
            if(isBissexto(a) && (d > 29 || d < 1)) return false;
            else if(d > 28 || d < 1) return false;
        }else if(d > 31 || d < 1)return false;
        
        return true;
    }

    private boolean isBissexto(int ano){
        if(ano%4 == 0 && (ano%100 != 0 || ano%400 == 0)) return true;
        return false;
    }
    
    public byte compara(byte d, byte m, int a){
        if(dia == d && mes == m && ano == a) return 0;
        if(ano > a || mes > m || dia > d) return 1;
        else return -1;
    }

    public byte getDia(){
        return dia;
    }

    public byte getMes(){
        return mes;
    }

    public int getAno(){
        return ano;
    }

    public void setDia(int dia){
        if(dia, this.mes, this.ano) this.dia = dia;
        else System.err.println("Erro: data" + dia + "/" + this.mes + "/" + this.ano " inválida.");
    }

    public void setMes(int mes){
        if(this.dia, mes, this.ano) this.mes = mes;
        else System.err.println("Erro: data" + this.dia + "/" + mes + "/" + this.ano " inválida.");
    }

    public void setDia(int ano){
        if(this.dia, this.mes, ano) this.mes = mes;
        else System.err.println("Erro: data" + this.dia + "/" + this.mes + "/" + ano " inválida.");
    }

    public Data clone(){
        Data copia = new Data(this.dia, this.mes, this.ano);
        return copia;
    }

    @Override
    public String toString(){
        System.out.printf("%02d/%02d/%02d\n", this.dia, this.mes. this.ano);
        return "";
    }
}