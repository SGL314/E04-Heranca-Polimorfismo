public class PessoaFisica extends Cliente {
    String cpf;
    int idade;
    char sexo;
    void imprimir(){
        System.out.println(this.cpf + " : " +this.idade+" : "+this.sexo);
    }
}
