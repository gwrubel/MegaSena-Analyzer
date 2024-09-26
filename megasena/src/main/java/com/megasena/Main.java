package com.megasena;

import javax.swing.*;
import java.io.File;


    public class Main {
        public static void main(String[] args) {
            Leitura leitura = new Leitura();
            
            // Cria um JFileChooser para permitir a seleção do arquivo
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Selecione o arquivo Mega-Sena");
            
            // Define um filtro para mostrar apenas arquivos .xlsx
            fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Arquivos Excel", "xlsx"));
            
            int userSelection = fileChooser.showOpenDialog(null);
            
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToOpen = fileChooser.getSelectedFile();
                leitura.lerArquivoMegaSena(fileToOpen.getAbsolutePath());
                
                SwingUtilities.invokeLater(() -> {
                    MegaSenaInterface interfaceMegaSena = new MegaSenaInterface(leitura);
                    interfaceMegaSena.setVisible(true);
                });
            } else {
                System.out.println("Nenhum arquivo foi selecionado.");
            }
        }
    }
    

