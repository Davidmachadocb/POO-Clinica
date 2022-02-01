/**
 * A classe data é usada para encapsular os dados de dia, mês e ano, bem como correlacioná-los para formar
 * uma data.
 * Nele há também métodos de impressão e validação.
 * @author Ítalo Moraes
 * @version 1.0
 */
class Data {
    private byte dia;
    private byte mes;
    private int ano;
    
    /**
     * Construtor da classe Data. Inicializa os atrobutos com os dados passados pelo usuário
     * @param d o dado do dia a ser encapsulado
     * @param m o dado do mês a ser encapsulado
     * @param a o dado do ano a ser encapsulado
     */
    Data(byte d, byte m, int a){
        if(dataValida(d, m, a)){
            dia = d; mes = m; ano = a;
        }else{System.out.println("Data inválida! Tente novamente.");}
    }

    /**
     * Função que valida a data fornecida.
     * A validação consiste em verificar se os dados individuais estão no limite especificado
     * @param d dado do dia
     * @param m dado do mês
     * @param a dado do ano
     * @return true se a data é válida, e false caso contrário
     */
    private boolean dataValida(byte d, byte m, int a){
        if(m > 12 || m < 1) return false;               // 1 <= ano <= 12

        if(m == 4 || m == 6 || m == 9 || m == 11){      // Abril, Junho, Setembro e Novembro têm 30 dias
            if(d > 30 || d < 1) return false;           // 1 <= dia <= 30
        }else if(m == 2){                               // Se o mês for Fevereiro
            if(isBissexto(a) && (d > 29 || d < 1)) return false;            // Verifica se o ano é bissexto e se o dia atende ao limite 1 <= dia <= 29 (caso bissexto)
            else if(d > 28 || d < 1) return false;                          // Verifica se o dia atende ao limite 1 <= dia <= 28 (caso não-bissexto)
        }else if(d > 31 || d < 1)return false;                              // 1 <= dia <= 31 (caso em que o mês em questão é qualquer outro exceto os já mencionados)
        
        return true;
    }

    /**
     * Verifica se o ano é bissexto usando a fórmula do ano bissexto
     * @param ano o dado do ano a ser verificado
     * @return true se o ano for bissexto, e false caso contrário
     */
    private boolean isBissexto(int ano){
        if(ano%4 == 0 && (ano%100 != 0 || ano%400 == 0)) return true;
        return false;
    }
    
    /**
     * Getter do atributo dia
     * @return o dado do dia armazenado na instância
     */
    public byte getDia(){
        return dia;
    }

    /**
     * Getter do atributo mes
     * @return o dado do mês armazenado na instância
     */
    public byte getMes(){
        return mes;
    }

    /**
     * Getter do atributo ano
     * @return o dado do ano armazenado na instância
     */
    public int getAno(){
        return ano;
    }

    /**
     * Setter do atributo dia.
     * Verifica se a data com o dia passado por parâmetro é válida
     * A data é atualizada se a mesma for válida
     * @param dia dado do novo dia 
     */
    public void setDia(byte dia){
        if(dataValida(dia, this.mes, this.ano)) this.dia = dia;
        else System.err.println("Erro: data " + toString(dia, this.mes, this.ano) + " inválida.");
    }

    /**
     * Setter do atributo mes.
     * Verifica se a data com o mes passado por parâmetro é válida
     * A data é atualizada se a mesma for válida
     * @param mes dado do novo mês
     */
    public void setMes(byte mes){
        if(dataValida(this.dia, mes, this.ano)) this.mes = mes;
        else System.err.println("Erro: data " + toString(this.dia, mes, this.ano) + " inválida.");
    }

    /**
     * Setter do atributo ano.
     * Verifica se a data com o ano passado por parâmetro é válida
     * A data é atualizada se a mesma for válida
     * @param ano dado do novo ano
     */
    public void setAno(int ano){
        if(dataValida(this.dia, this.mes, ano)) this.ano = ano;
        else System.err.println("Erro: data " + toString(this.dia, this.mes, ano) + " inválida.");
    }

    /**
     * Caso todos os atributos tiverem que ser alterados, esse método deverá ser chamado
     * Será verificada se a nova data é válida. Se sim, a data será atualizada
     * @param dia o dado do novo dia
     * @param mes o dado  do novo mês
     * @param ano o dado  do novo ano
     */
    public void atualizaData(byte dia, byte mes, int ano){
        if(!dataValida(dia, mes, ano)) System.err.println("Erro: data " + toString(dia, mes, ano) + " inválida.");
        else{
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        }
    }

    /**
     * Imprime os dados dos atributos de forma organizada
     * @return os dados formatados para impressão
     */
    public String toString(){
        return String.format("%02d/%02d/%02d", this.dia, this.mes, this.ano);
    }

    /**
     * Versão sobrecarregada do toString() usada para nas mensagens de erro dos métodos de atualização
     * @param dia o dado do dia passado por parâmetro
     * @param mes o dado do mês passado por parâmetro
     * @param ano o dado do ano passado por parâmetro
     * @return os dados formatados para impressão
     */
    public String toString(byte dia, byte mes, int ano){
        return String.format("%02d/%02d/%02d", dia, mes, ano);
    }
}
