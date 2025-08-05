import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvFileReader {
    public static void main(String[] args) {
        String fileName = "funcionarios.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String linha;

            String labelNome = null;
            String labelIdade = null;
            String labelDepto = null;
            String labelSalario = null;

            while ((linha = reader.readLine()) != null) {

               String[] dados = linha.split(",");

                if (labelNome == null) {
                    labelNome = dados[0];
                    labelIdade = dados[1];
                    labelDepto = dados[2];
                    labelSalario = dados[3];
                }

                if (dados.length == 4) {
                    String nome = dados[0];
                    String idade = dados[1];
                    String departamento = dados[2];
                    String salario = dados[3];

                    System.out.println(labelNome + ": " + nome);
                    System.out.println(labelIdade + ": " + idade);
                    System.out.println(labelDepto + ": " + departamento);
                    System.out.println(labelSalario + ": " + salario);
                    System.out.println("------------------------");
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ");
        } finally {
            System.out.println("Leitura do arquivo concluída.");
        }
    }
}