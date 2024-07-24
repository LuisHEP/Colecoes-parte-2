import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ListaNomesOrdenadaComSexo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Pessoa> pessoas = new ArrayList<>();
        final int MAX_PESSOAS = 4; // Número máximo de pessoas

        System.out.println("Digite os nomes e sexos das pessoas (máximo de 4).");

        int count = 0;
        while (count < MAX_PESSOAS) {
            System.out.print("Digite um nome: ");
            String nome = scanner.nextLine();

            if (nome.equalsIgnoreCase("sair")) {
                break;
            }

            System.out.print("Digite o sexo (Feminino/Masculino): ");
            String sexo = scanner.nextLine();

            Pessoa pessoa = new Pessoa(nome, sexo);
            pessoas.add(pessoa);
            count++;
        }

        ordenarPessoas(pessoas);
        exibirPessoasPorSexo(pessoas);
    }

    private static void ordenarPessoas(List<Pessoa> pessoas) {
        Collections.sort(pessoas);
    }

    private static void exibirPessoasPorSexo(List<Pessoa> pessoas) {
        List<Pessoa> feminino = new ArrayList<>();
        List<Pessoa> masculino = new ArrayList<>();

        // Separando as pessoas por sexo
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getSexo().equalsIgnoreCase("Feminino")) {
                feminino.add(pessoa);
            } else if (pessoa.getSexo().equalsIgnoreCase("Masculino")) {
                masculino.add(pessoa);
            }
        }

        // Exibindo as pessoas separadas por sexo
        System.out.println("\nPessoas do sexo Feminino:");
        for (Pessoa pessoa : feminino) {
            System.out.println("Nome: " + pessoa.getNome() + ", Sexo: " + pessoa.getSexo());
        }

        System.out.println("\nPessoas do sexo Masculino:");
        for (Pessoa pessoa : masculino) {
            System.out.println("Nome: " + pessoa.getNome() + ", Sexo: " + pessoa.getSexo());
        }
    }
}

class Pessoa implements Comparable<Pessoa> {
    private String nome;
    private String sexo;

    public Pessoa(String nome, String sexo) {
        this.nome = nome;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }

    @Override
    public int compareTo(Pessoa outraPessoa) {
        return this.nome.compareTo(outraPessoa.getNome());
    }
}
