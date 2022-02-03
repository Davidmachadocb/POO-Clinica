/**
 * A classe Clinico encapsula os dados de um clinico.
 * Pelo fato da classe Clinico extender a classe abstrata Pessoa, Clinico contém os atributos
 * e métodos desta última
 * @author Ítalo Moraes
 * @version 1.0
 */
class Clinico extends Pessoa {
    private String registro;
    private Especialidade espec;

    /**
     * Construtor da classe Clinico. Inicializa os atributos da instância com informações recebidas pelo
     * usuário
     * @param nome o nome completo passado por parâmetro
     * @param endereco o endereço passado por parâmetro
     * @param numTelefone o número de contato passado por parâmetro
     * @param registro o registro CRM passado por parâmetro
     * @param espec a especialidade médica passada por parâmetro. Se o nome passado não corresponder
     * a nenhum dos listados, um erro será emitido
     */
    Clinico(String nome, String endereco, String numTelefone, String registro, String espec){
        super(nome, endereco, numTelefone);
        this.registro = registro;
        for(Especialidade it : Especialidade.values()){
            if(it.getWord().equalsIgnoreCase(espec)) this.espec = it;
        }
    }

    /**
     * Getter do atributo registro
     * @return o registro passado para a instância do objeto
     */
    public String getRegistro() {
        return registro;
    }

    /**
     * Getter do atributo espec
     * @return a especialidade médica passada para a instância do objeto
     */
    public String getEspecialidade() {
        if(this.espec != null) return espec.getWord();
        else return "";
    }

    /**
     * Setter do atributo registro
     * @param registro o novo CRM a ser passado para o atributo registro da instância
     */
    public void setRegistro(String registro) {
        this.registro = registro;
    }

    /**
     * Setter do atributo espec
     * @param especialidade a nova especialidade a ser passada para o atributo especialidade da instância
     */
    public void setEspecialidade(String especialidade) {
        for(Especialidade it : Especialidade.values()){
            if(it.getWord() == especialidade) this.espec = it;
        }
    }

    /**
     * Método que sobrepõe o toString() da superclasse. Fornece os dados formatados da instância de forma organizada
     * @return Uma string com os dados organizados da instância
     */
    @Override
    public String toString() {
        String str = super.toString();
        str += "\nNúmero CRM: " + this.registro + "\nEspecialidade: " + this.espec.getWord();
        return str;
    }
}
