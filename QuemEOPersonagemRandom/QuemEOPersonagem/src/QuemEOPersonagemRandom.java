import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class QuemEOPersonagemRandom {

    public static String tela(String[] vetor, ImageIcon icon) {
        String[] vetorAux = new String[3]; // alternativas
        vetorAux[0] = vetor[1]; // alternativa a
        vetorAux[1] = vetor[2]; // alternativa b
        vetorAux[2] = vetor[3]; // alternativa c

        String opcaoEscolhida = (String) JOptionPane.showInputDialog(null, vetor[0], "Quem é este Personagem?", JOptionPane.QUESTION_MESSAGE, icon, vetorAux, vetorAux[0]);
        return opcaoEscolhida;
    }

    public static void vetor(String[][] matriz) {
        // vetor de indice para pergintas
        int[] indices = {0, 1, 2, 3, 4};

        //random nos índices para decidir a ordem das perguntas
        Random rand = new Random();
        for (int i = indices.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = indices[i];
            indices[i] = indices[j];
            indices[j] = temp;
        }

        //vetor dos icons
        ImageIcon[] icons = {
            new ImageIcon("imagens/zenitsu.png"),
            new ImageIcon("imagens/nezuko.png"),
            new ImageIcon("imagens/inosuke.png"),
            new ImageIcon("imagens/tanjiro.png"),
            new ImageIcon("imagens/tomioka.png")
        };

        //random nas perguntas com icones correspondentes
        String[][] perguntas = new String[5][5];
        ImageIcon[] perguntasIcons = new ImageIcon[5];
        for (int i = 0; i < 5; i++) {
            perguntas[i] = matriz[indices[i]];
            perguntasIcons[i] = icons[indices[i]];
        }

        //respostas
        String[] respostas = new String[5];
        for (int i = 0; i < 5; i++) {
            respostas[i] = tela(perguntas[i], perguntasIcons[i]);
        }

        // acertos
        int acertos = 0;
        for (int i = 0; i < 5; i++) {
            if (perguntas[i][4].charAt(0) == respostas[i].charAt(0)) {
                acertos++;
            }
        }
        //tela final
        ImageIcon imagem = new ImageIcon("imagens/bye-icon.jpg");
        JOptionPane.showMessageDialog(null, "Você acertou " + acertos + " personagens", "Resultado", JOptionPane.QUESTION_MESSAGE, imagem);
        ImageIcon again = new ImageIcon("imagens/again.jpg");
        int entrada = JOptionPane.showOptionDialog(null, "Deseja jogar novamente ?", "Quem é o Personagem?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, again, null, null);
        if (entrada == JOptionPane.YES_OPTION){
            matrizJogo();
        }else {
            ImageIcon end = new ImageIcon("imagens/end.jpg");
            JOptionPane.showMessageDialog(null, "Nos vemos no proximo Jogo !!", "Bye Bye", JOptionPane.QUESTION_MESSAGE, end);
        }
    }

    public static void matrizJogo() {
        String[][] matriz = new String[5][5];
        // matriz de cada pergunta
        matriz[0][0] = "Quem é este personagem?";
        matriz[0][1] = "A) Nezuko";
        matriz[0][2] = "B) Zenitsu";
        matriz[0][3] = "C) Inosuke";
        matriz[0][4] = "B) Zenitsu";
        
        matriz[1][0] = "Quem é este personagem?";
        matriz[1][1] = "A) Tanjiro";
        matriz[1][2] = "B) Zenitsu";
        matriz[1][3] = "C) Nezuko";
        matriz[1][4] = "C) Nezuko";

        matriz[2][0] = "Quem é este personagem?";
        matriz[2][1] = "A) Nezuko";
        matriz[2][2] = "B) Zenitsu";
        matriz[2][3] = "C) Inosuke";
        matriz[2][4] = "C) Inosuke";

        matriz[3][0] = "Quem é este personagem?";
        matriz[3][1] = "A) Nezuko";
        matriz[3][2] = "B) Tanjiro";
        matriz[3][3] = "C) Inosuke";
        matriz[3][4] = "B) Tanjiro";

        matriz[4][0] = "Quem é este personagem?";
        matriz[4][1] = "A) Nezuko";
        matriz[4][2] = "B) Tanjiro";
        matriz[4][3] = "C) Tomioka";
        matriz[4][4] = "C) Tomioka";

        vetor(matriz);
    }

    public static void inicio() {
        ImageIcon icon = new ImageIcon("imagens/telainicial.jpg");
        // tela inicial
        int entrada = JOptionPane.showOptionDialog(null, "Bem-vindo ao Jogo 'Quem é Este Personagem?'\nDeseja começar o jogo?", "Quem é o Personagem?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, null, null);
        if (entrada == JOptionPane.YES_OPTION) {
            matrizJogo(); 
        } else {
            System.out.println("Nos vemos no próximo jogo !!");
        }
    }

    public static void main(String[] args) throws Exception {
        inicio();
    }
}
