public class Main{
    public static void main(String[] args){
        Conta c1 = new Conta("Lobato",2300,"105-69",314159265,"pf");
        Conta c2 = new Conta("Ana",100,"105-70",1618033988,"pf");

        c1.saque(100);
        c1.deposito(600);
        c2.saque(100);
        c2.deposito(1000);
        c2.transferir(c1, 500);
        c2.saque(300);
        c1.extrato();
        System.err.println("......");
        c2.extrato();
        System.out.printf("Media de operacoes por conta : %.3f\n",(float) ((float)Operacao.totalOperacoes/(float)Conta.totalContas));

    }
}