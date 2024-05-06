import java.util.Date;

public class Operacao {

    public Date data;
    public char tipo;
    public double valor;
    public static int totalOperacoes = 0;

    Operacao(){
        this.data = new Date();
        totalOperacoes++;
    }

    public void imprimirExtrato(){

        System.out.println(this.data + "\t" + this.tipo + "\t" + this.valor);

    }

    // Encapsulation
    public Date getData(){
        return this.data;
    }
    public char getTipo(){
        return this.tipo;
    }
    public void setTipo(char novoTipo){
        this.tipo = novoTipo;
    }
    public double getValor(){
        return this.valor;
    }
    public void setValor(double novoValor){
        this.valor = novoValor;
    }
    //

}