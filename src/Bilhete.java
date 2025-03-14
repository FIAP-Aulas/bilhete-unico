import java.util.Random;

public class Bilhete {
    long numero;
    double saldo;
    static final double TARIFA = 5.20;
    Usuario usuario;

    public Bilhete(Usuario usuario) {
        numero = gerarNumero();
        this.usuario = usuario;
    }

    //gerando o numero aleatorio do bilhete
    public long gerarNumero() {
        Random random = new Random();
        return random.nextLong(1000, 10000);
    }

    //carregando o bilhete
    public void carregar(double valor) {
        saldo += valor;
    }

    //consultando o saldo do bilhete
    public double consultarSaldo(double saldo) {
        return saldo;
    }

    //passando na catraca
    public String passarCatraca() {
        double debito = TARIFA / 2;

        if (usuario.perfil.equalsIgnoreCase("comum")) {
            debito = TARIFA;
        }
        if (saldo >= debito) {
            saldo -= debito;
            return "Catraca livre";
        }
      return "Sem saldo";
    }
}