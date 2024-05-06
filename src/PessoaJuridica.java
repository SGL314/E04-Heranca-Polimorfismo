public class PessoaJuridica extends Cliente{
    String cnpj,setor;
    int numFuncionarios;
    void imprimir(){
        System.out.println(this.cnpj+" : "+this.setor+" : "+this.numFuncionarios);
    }
}
