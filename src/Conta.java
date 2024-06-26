
public class Conta{
    private int numero;
    private double saldo;
    private Cliente dono;
    private String agencia;
    private Operacao[] operacoes = new Operacao[0];
    public static int totalContas = 0;

    // Encapsulation
    public Cliente getDono(){
        return this.dono;
    }
    public void setDono(Cliente novoDono){
        this.dono = novoDono;
    }
    public int getNumero(){
        return this.numero;
    }
    public void setNumero(int novoNumero){
        this.numero = novoNumero;
    }
    public double getSaldo(){
        return this.saldo;
    }
    public String getAgencia(){
        return this.agencia;
    }
    public void setAgencia(String novaAgencia){
        this.agencia = novaAgencia;
    }
    //
    Conta(String nome, double saldo, String agencia, int numero,String tipo){
        switch (tipo){
            case "pf":
                this.dono = new PessoaFisica();
                break;
            case "pj":
                this.dono =  new PessoaJuridica();
                break;
            default:
                System.out.println("Pessoa não identificada");
        }
        this.dono.nome = nome;
        this.saldo = saldo;
        this.agencia = agencia;
        this.numero = numero;
        totalContas++;
    }
    //Methods
    private void registroOperacao(){
        Operacao[] operacoesAntiga = operacoes;
        operacoes = new Operacao[operacoes.length+1];
        for (int i=0;i<operacoesAntiga.length;i++){
            operacoes[i] = operacoesAntiga[i];
        }
        
    }
    public void extrato(){
        for (Operacao opr : operacoes) {
            opr.imprimirExtrato();
        }
    }
    public boolean deposito(double valor){
        if (valor > 0) {
            this.saldo += valor;
            registroOperacao();
            operacoes[operacoes.length-1] = new OperacaoDeposito(valor);

            return true;
        }
        return false;
    }
    public boolean saque(double valor){
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            registroOperacao();
            operacoes[operacoes.length-1] = new OperacaoSaque(valor);
            return true;
        }
        return false;
    }
    public boolean transferir(Conta destino, double valor){
        boolean saque = this.saque(valor);
        if (saque){
            boolean deposito = destino.deposito(valor);
            return deposito;
        }
        return false;
    }
    public void imprimir(){
        System.out.printf("Dono : %s\nSaldo : %.2f\nNumero : %d\nAgencia : %s\n", this.dono.nome, this.saldo, this.numero, this.agencia);
    }
    //
}