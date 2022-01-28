/**
 * Tipo enumerado que lista as especialidade médicas disponíveis para cadastro no sistema.
 * Essas são especialidade procuradas pelos idealixadores da clínica.
 * Conforme a necessidade, novas especialidades estarão disponíveis para cadastro
 * @author Ítalo Moraes
 * @version 1.0
 */
enum Especialidade {
    CARDIOLOGIA("Cardiologia"), DERMATOLOGIA("Dermatologia"), GINECOLOGIA("Ginecologia"),
    ENDOCRINOLOGIA("Endocrinologia"), PNEUMOLOGIA("Pneumologia"), PSIQUIATRIA("Psiquiatria"),
    PEDIATRIA("Pediatria"), MEDICINA_DENTARIA("Medicina dentária");

    /**
     * Variável que encapsula a string de cada atributo enumerado
     */
    private final String word;

    /**
     * Construtor da enum. Inicializa a string representativa dos tipos enumerados
     * @param word a string que irá representar cada atributo do enum
     */
    Especialidade(String word){
        this.word = word;
    }

    /**
     * Getter dos atributos enumerados
     * @return a string que representa o atributo enumerado selecionado
     */
    String getWord(){ return this.word; }
}
