import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        Random randomizacao = new Random();
        
        String logo = """
                    
                        .___.__      .__       .__            
            _____     __| _/|__|__  _|__| ____ |  |__ _____   
            \\__  \\   / __ | |  \\  \\/ /  |/    \\|  |  \\\\__  \\  
            / __ \\_/ /_/ | |  |\\   /|  |   |  \\   Y  \\/ __ \\_
            (____  /\\____ | |__| \\_/ |__|___|  /___|  (____  /
                \\/      \\/                  \\/     \\/     \\/ 

                    """;
        System.out.println(logo);

        // Loop principal do jogo
        while (true) {
            int intervalStart = 1, intervalEnd = 10, maxTentativas = 10;
            int choose = 0, tentativas = 0, cpu;
            ArrayList<Integer> historico = new ArrayList<>();
            String resposta;

            System.out.println("Escolha o nível de dificuldade:");
            System.out.println("1. Fácil (1-10)");
            System.out.println("2. Médio (1-50)");
            System.out.println("3. Difícil (1-100)");
            int nivel = leitura.nextInt();

            // Ajustando intervalo e número de tentativas com base no nível
            switch (nivel) {
                case 1:
                    intervalEnd = 10;
                    maxTentativas = 15;
                    break;
                case 2:
                    intervalEnd = 50;
                    maxTentativas = 10;
                    break;
                case 3:
                    intervalEnd = 100;
                    maxTentativas = 7;
                    break;
                default:
                    System.out.println("Nível inválido. Escolhendo nível Fácil.");
                    intervalEnd = 10;
                    maxTentativas = 15;
                    break;
            }

            cpu = randomizacao.nextInt(intervalEnd) + intervalStart; // Número aleatório dentro do intervalo escolhido

            System.out.println("Você tem " + maxTentativas + " tentativas. Boa sorte!");

            // Loop de tentativas
            while (choose != cpu && tentativas < maxTentativas) {
                System.out.println("Tente adivinhar o número escolhido:");
                choose = leitura.nextInt();
                historico.add(choose);
                tentativas++;

                if (choose == cpu) {
                    System.out.println("Parabéns, você acertou!");
                    System.out.println("Tentativas necessárias: " + tentativas);
                    break;
                } else {
                    System.out.println("Você errou...");
                    if (choose < cpu) {
                        System.out.println("O número é maior.");
                    } else {
                        System.out.println("O número é menor.");
                    }
                }

                // Dica especial após 3 tentativas
                if (tentativas == 3) {
                    if (cpu % 2 == 0) {
                        System.out.println("Dica: O número é PAR.");
                    } else {
                        System.out.println("Dica: O número é ÍMPAR.");
                    }
                }
            }

            if (choose != cpu) {
                System.out.println("Você não acertou. O número era " + cpu);
            }

            // Mostrar o histórico de tentativas
            System.out.println("Histórico de tentativas: " + historico);

            // Perguntar se o jogador quer jogar novamente
            System.out.println("Deseja jogar novamente? (sim/nao)");
            resposta = leitura.next();

            if (resposta.equalsIgnoreCase("nao")) {
                System.out.println("Obrigado por jogar! Fim de jogo.");
                break; // Encerra o loop e o programa
            } else if (resposta.equalsIgnoreCase("sim")) {
                System.out.println("Iniciando um novo jogo...");
            } else {
                System.out.println("Resposta inválida. Fim de jogo.");
                break; // Encerra o loop caso a resposta seja algo inesperado
            }
        }

        leitura.close(); // Fecha o scanner após o uso
    }
}
