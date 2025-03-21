import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;

public class Util {
    private Bilhete[] bilhete = new Bilhete[5];
    private int index = 0;

    public void menu() {


        String aux = "Escolha uma opção\n";
        aux += "1. Emitir bilhete\n";
        aux += "2. Carregar bilhete\n";
        aux += "3. Consultar saldo\n";
        aux += "4. Passar na catraca\n";
        aux += "5. Finalizar\n";
        int opcao;

        while (true) {
            opcao = parseInt(showInputDialog(aux));
            if (opcao == 5) {
                break;
            }
            if (opcao < 1 || opcao > 5) {
                showInputDialog(null, "Opçao invalida");
            } else {
                switch (opcao) {
                    case 1:
                        emitirBilhete();
                        break;
                    case 2:
                        carregarBilhete();
                        break;
                    case 3:
                        consultarSaldo();
                        break;
                    case 4:
                        passarNaCatraca();
                }
            }
        }
    }

    public void emitirBilhete() {

        if (index < bilhete.length) {
            String nome = showInputDialog("Nome =>");
            String perfil = showInputDialog("Perfil => comum ou estudante ou professor");
            long cpf = parseLong(showInputDialog("CPF => "));
            Usuario usuario = new Usuario(nome, perfil, cpf);
            bilhete[index] = new Bilhete(usuario);
            index++;
        }

        else{
            showInputDialog("Bilhete não cadastrado");
        }

    }

    public void consultarSaldo(){
    int posicao = pesquisar();
    if (posicao == -1){
        showInputDialog("CPF não encontrado");
    }
    else {
        showInputDialog(null, bilhete[posicao].consultarSaldo());
    }
    }

    public void carregarBilhete(){
       int posicao = pesquisar();
       double valor;
        if (posicao != -1) {
            valor = parseDouble(showInputDialog("Valor para recarga do bilhete => "));
            bilhete[posicao].carregar(valor);
        }
    }

    public void passarNaCatraca(){
        int posicao = pesquisar();
        if (posicao != -1){
            showInputDialog(null, bilhete[posicao].passarCatraca());
        }
    }

    public int pesquisar(){
        long cpfConsulta = parseLong(showInputDialog("Digite seu CPF => "));
        for(int i = 0; i < index; i++) {
            if (bilhete[i].usuario.cpf == cpfConsulta) {
                return i;
            }
        }
        return -1;
    }
}
