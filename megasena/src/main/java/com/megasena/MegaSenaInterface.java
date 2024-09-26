package com.megasena;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Random;


public class MegaSenaInterface extends JFrame {
    private Leitura leitura;

    public MegaSenaInterface(Leitura leitura) {
        this.leitura = leitura;
        setTitle("Mega Sena");
        setSize(400, 300); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setResizable(false); 
        initComponents();

    }

    private JTextField[] textFieldNumerosUsuario;

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1)); 

        textFieldNumerosUsuario = new JTextField[6];
        for (int i = 0; i < 6; i++) {
            textFieldNumerosUsuario[i] = new JTextField(5); 
        }
        
        JButton btnContarRepeticoes = new JButton("Contar Repetições");
        JButton btnVezesSemSeis = new JButton("Vezes Sem Seis");
        JButton btnMaiorMenor4Acertos = new JButton("Maior/Menor 4 Acertos");
        JButton btnMaiorMenor5Acertos = new JButton("Maior/Menor 5 Acertos");
        JButton btnMaiorMenor6Acertos = new JButton("Maior/Menor 6 Acertos");
        JButton btnTotalGanhadores = new JButton("Total de Ganhadores (4, 5 e 6 acertos)");
        JButton btnRealizarSorteio = new JButton("Realizar Sorteio");
        JButton btnSorteioAleatorio = new JButton("Sorteio Aleatório");
        JButton btnSair = new JButton("Sair");


        panel.add(btnContarRepeticoes);
        panel.add(btnVezesSemSeis);
        panel.add(btnMaiorMenor4Acertos);
        panel.add(btnMaiorMenor5Acertos);
        panel.add(btnMaiorMenor6Acertos);
        panel.add(btnTotalGanhadores);
        panel.add(btnRealizarSorteio);
        panel.add(btnSorteioAleatorio);
        panel.add(btnSair);

        add(panel);

        btnContarRepeticoes.addActionListener(e -> {
            exibirMensagem("Contando repetições...\n" +
                    "Resultado no console.");
            leitura.contarRepeticoes(leitura.getSorteios());
        });

        
        btnVezesSemSeis.addActionListener(e -> {
            int qtd = leitura.vezesQueNaoTeveSeis(leitura.getSorteios());
            String resultado = "Vezes que não teve 6 ganhadores: " + qtd;
            exibirMensagem(resultado);
        });

        btnMaiorMenor4Acertos.addActionListener(e -> {
            double[] resultado = leitura.maiorMenorQuatroAcertos(leitura.getSorteios());

            exibirMensagem(""+"O menor valor pago para 4 dezenas foi: " + leitura.formatarDoubleComoMoeda(resultado[0]) +
            "\nO maior valor pago para 4 dezenas foi: " + leitura.formatarDoubleComoMoeda(resultado[1]));
        });

        btnMaiorMenor5Acertos.addActionListener(e -> {
            double[] resultado = leitura.maiorMenorCincoAcertos(leitura.getSorteios());

            exibirMensagem(""+"O menor valor pago para 5 dezenas foi: " + leitura.formatarDoubleComoMoeda(resultado[0]) +
            "\nO maior valor pago para 5 dezenas foi: " + leitura.formatarDoubleComoMoeda(resultado[1]));
        });

        btnMaiorMenor6Acertos.addActionListener(e -> {
            BigDecimal[] resultado = leitura.maiorMenorSeisAcertos(leitura.getSorteios());

            exibirMensagem(""+"O menor valor pago para 6 dezenas foi: " + leitura.formatarBigDecimalComoMoeda(resultado[0]) +
            "\nO maior valor pago para 6 dezenas foi: " + leitura.formatarBigDecimalComoMoeda(resultado[1]));
        });

        btnTotalGanhadores.addActionListener(e -> {
            int totalQuatro = leitura.totalDeGanhadoresQuatro(leitura.getSorteios());
            int totalCinco = leitura.totalDeGanhadoresCinco(leitura.getSorteios());
            int totalSeis = leitura.totalDeGanhadoresSeis(leitura.getSorteios());
            String resultado = "Total de ganhadores: " +
                    "\nCom 4 dezenas: " + totalQuatro + " ganhadores" +
                    "\nCom 5 dezenas: " + totalCinco + " ganhadores" +
                    "\nCom 6 dezenas: " + totalSeis + " ganhadores";
            exibirMensagem(resultado);

        });

        btnRealizarSorteio.addActionListener(new ActionListener() {
            int dezenaAtual = 0;
            int[] numerosUsuario = new int[6];

            @Override
            public void actionPerformed(ActionEvent event) {
                if (dezenaAtual >= 6) {
                    String resultado = leitura.realizarSorteio(leitura.getSorteios(), numerosUsuario);
                    exibirMensagem(resultado);
                    dezenaAtual = 0;
                    return;
                }

                int proximaDezena = dezenaAtual + 1;

                String mensagem = "Digite a " + proximaDezena + "ª dezena:";
                String numeroDigitado = JOptionPane.showInputDialog(null, mensagem);

                if (numeroDigitado == null || numeroDigitado.isEmpty()) {
                    return;
                }

                try {
                    int numero = Integer.parseInt(numeroDigitado);
                    if (numero < 1 || numero > 60) {
                        JOptionPane.showMessageDialog(null, "Digite um número entre 1 e 60.", "Erro",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    numerosUsuario[dezenaAtual] = numero;
                    dezenaAtual++;
                    actionPerformed(event);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Digite um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnSorteioAleatorio.addActionListener(e -> {
            int[] numAleatorios = new int[6];
            Random random = new Random();
            int numeroAleatorio;
            for (int i = 0; i < 6; i++) {
                numeroAleatorio = random.nextInt(60) + 1;
                numAleatorios[i] = numeroAleatorio;
            }
            exibirMensagem("Seus numeros aleatórios são: " + numAleatorios[0] + ", " + numAleatorios[1] + ", "
                    + numAleatorios[2] + ", " + numAleatorios[3] + ", " + numAleatorios[4] + ", " + numAleatorios[5]);
            String resultado = leitura.sorteioAleatorio(leitura.getSorteios(), numAleatorios);
            exibirMensagem(resultado);
        });

        btnSair.addActionListener(e -> System.exit(0));
    }

    private void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Resultado", JOptionPane.INFORMATION_MESSAGE);
    }


}


