package com.megasena;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.log4j.Logger;
import java.util.Iterator;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Leitura {

    private static final Logger log = Logger.getLogger(Leitura.class);

    private List<MegaSena> sorteios = new ArrayList<>();

    public List<MegaSena> getSorteios() {
        return sorteios;
    }

    public void setSorteios(List<MegaSena> sorteios) {
        this.sorteios = sorteios;
    }

    @SuppressWarnings("deprecation")
    public void lerArquivoMegaSena(String caminhoArquivo) {
        log.info("Lendo arquivo...");
        try {
            XSSFWorkbook pasta = new XSSFWorkbook(caminhoArquivo);
            Sheet planilha = pasta.getSheetAt(0);
            Iterator<?> linhas = planilha.rowIterator();

            if (linhas.hasNext()) {
                linhas.next();
            }

            while (linhas.hasNext()) {
                XSSFRow linha = (XSSFRow) linhas.next();
                Iterator<?> celulas = linha.cellIterator();

                MegaSena megasena = new MegaSena();

                while (celulas.hasNext()) {
                    XSSFCell celula = (XSSFCell) celulas.next();
                    int coluna = celula.getColumnIndex();

                    switch (celula.getCellTypeEnum()) {
                        case NUMERIC:
                            switch (coluna) {
                                case 0:
                                    megasena.setConcurso((int) celula.getNumericCellValue());
                                    break;
                                case 2:
                                    megasena.setBola1((int) celula.getNumericCellValue());
                                    break;
                                case 3:
                                    megasena.setBola2((int) celula.getNumericCellValue());
                                    break;
                                case 4:
                                    megasena.setBola3((int) celula.getNumericCellValue());
                                    break;
                                case 5:
                                    megasena.setBola4((int) celula.getNumericCellValue());
                                    break;
                                case 6:
                                    megasena.setBola5((int) celula.getNumericCellValue());
                                    break;
                                case 7:
                                    megasena.setBola6((int) celula.getNumericCellValue());
                                    break;
                                case 8:
                                    megasena.setGanhadores6Acertos((int) celula.getNumericCellValue());
                                    break;
                                case 11:
                                    megasena.setGanhadores5Acertos((int) celula.getNumericCellValue());
                                    break;
                                case 13:
                                    megasena.setGanhadores4Acertos((int) celula.getNumericCellValue());
                                    break;

                                case 15:
                                    megasena.setAcumulado6Acertos(celula.getBooleanCellValue());
                                    break;

                                default:

                                    break;
                            }
                            break;
                        case STRING:
                            switch (coluna) {
                                case 1:
                                    megasena.setDataSorteio(megasena.converterData(celula.getStringCellValue()));
                                    break;
                                case 9:
                                    megasena.setCidadeUF(celula.getStringCellValue());
                                    break;
                                case 10:
                                    megasena.setRateio6Acertos(tratarValorMonetarioBig(celula.getStringCellValue()));
                                    break;
                                case 12:
                                    megasena.setRateio5Acertos(tratarValorMonetario(celula.getStringCellValue()));
                                    break;
                                case 14:
                                    megasena.setRateio4Acertos(tratarValorMonetario(celula.getStringCellValue()));
                                    break;
                                case 16:
                                    megasena.setArrecadacaoTotal(tratarValorMonetario(celula.getStringCellValue()));
                                    break;
                                case 17:
                                    megasena.setEstimativaPremio(tratarValorMonetario(celula.getStringCellValue()));
                                    break;
                                case 18:
                                    megasena.setAcumuladoSorteioEspecialMegaDaVirada(
                                            tratarValorMonetario(celula.getStringCellValue()));
                                    break;
                                case 19:
                                    megasena.setObservacao(celula.getStringCellValue());
                                    break;
                                default:

                                    break;
                            }
                            break;
                        default:

                            break;
                    }
                }
                sorteios.add(megasena);
            }
            pasta.close();
        } catch (Exception e) {

            log.info("Erro ao ler o arquivo da Mega Sena: " + e.getMessage());
        }
    }

    public double tratarValorMonetario(String valorMonetario) {
        valorMonetario = valorMonetario.replace("R$", "").replace(".", "").replace(",", ".").trim();
        return Double.parseDouble(valorMonetario);
    }

    public BigDecimal tratarValorMonetarioBig(String valorMonetario) {
        valorMonetario = valorMonetario.replace("R$", "").replace(".", "").replace(",", ".").trim();
        return new BigDecimal(valorMonetario);
    }

   

    public void contarRepeticoes(List<MegaSena> sorteios) {
        log.info("Iniciando contagem de vezes que cada numero se repete.");
        int[] contadores = new int[61];
        int numeroMaisRepetido = 1;
        int numeroMenosRepetido = 1;
        int maiorContagem = 0;
        int menorContagem = Integer.MAX_VALUE;

        for (MegaSena sorteio : sorteios) {

            contadores[sorteio.getBola1()]++;
            contadores[sorteio.getBola2()]++;
            contadores[sorteio.getBola3()]++;
            contadores[sorteio.getBola4()]++;
            contadores[sorteio.getBola5()]++;
            contadores[sorteio.getBola6()]++;
        }
        for (int i = 1; i <= 60; i++) {
            System.out.println("Número " + i + ": (" + contadores[i] + " vezes)");
            if (contadores[i] > maiorContagem) {
                numeroMaisRepetido = i;
                maiorContagem = contadores[i];
            }
            if (contadores[i] < menorContagem) {
                numeroMenosRepetido = i;
                menorContagem = contadores[i];
            }
        }
        System.out.println("informaçoes extras:");
        System.out.println("O número que mais se repete é o " + numeroMaisRepetido + " (" + maiorContagem + " vezes)");
        System.out.println("O número que menos se repete é o " + numeroMenosRepetido + " (" + menorContagem + " vezes)");
    }

    public int vezesQueNaoTeveSeis(List<MegaSena> sorteios) {
        log.info("Iniciando funcao de contar vezes que nao teve 6 ganhadores");
        int contador = 0;
        for (MegaSena sorteio : sorteios) {
            if (sorteio.getGanhadores6Acertos() == 0) {
                contador++;
            }
        }
        return contador;
    }

    public double[] maiorMenorQuatroAcertos(List<MegaSena> sorteios) {
        log.info("Iniciando funcao maior e menor acerto (4)");
        double menorValor = sorteios.get(0).getRateio4Acertos();
        double maiorValor = 0;

        for (MegaSena sorteio : sorteios) {

            if (sorteio.getRateio4Acertos() < menorValor) {
                menorValor = sorteio.getRateio4Acertos();
            }
            if (sorteio.getRateio4Acertos() > maiorValor) {
                maiorValor = sorteio.getRateio4Acertos();
            }
        }
        return new double[] { menorValor, maiorValor };

    }

    public double[] maiorMenorCincoAcertos(List<MegaSena> sorteios) {
        log.info("Iniciando funcao maior e menor acerto (5)");
        double menorValor = sorteios.get(0).getRateio5Acertos();
        double maiorValor = 0;
        for (MegaSena sorteio : sorteios) {

            if (sorteio.getRateio5Acertos() < menorValor) {
                menorValor = sorteio.getRateio5Acertos();
            }
            if (sorteio.getRateio5Acertos() > maiorValor) {
                maiorValor = sorteio.getRateio5Acertos();
            }
        }

        return new double[] { menorValor, maiorValor };

    }

    public BigDecimal[] maiorMenorSeisAcertos(List<MegaSena> sorteios) {
        log.info("Iniciando funcao maior e menor acerto (6)");
        BigDecimal menorValor = null;
        BigDecimal maiorValor = null;

        for (MegaSena sorteio : sorteios) {
            BigDecimal rateio6Acertos = sorteio.getRateio6Acertos();

            if (rateio6Acertos.compareTo(BigDecimal.ZERO) > 0) {

                if (menorValor == null || rateio6Acertos.compareTo(menorValor) < 0) {
                    menorValor = rateio6Acertos;
                }
                if (maiorValor == null || rateio6Acertos.compareTo(maiorValor) > 0) {
                    maiorValor = rateio6Acertos;
                }
            }
        }

        return new BigDecimal[] { menorValor, maiorValor };

    }

    public int totalDeGanhadoresQuatro(List<MegaSena> sorteios) {
        log.info("Iniciando funcao contador de 4 acertos");
        int total = 0;

        for (MegaSena sorteio : sorteios) {
            total += sorteio.getGanhadores4Acertos();
        }

        return total;

    }

    public int totalDeGanhadoresCinco(List<MegaSena> sorteios) {
        log.info("Iniciando funcao contador de 5 acertos");

        int total = 0;

        for (MegaSena sorteio : sorteios) {
            total += sorteio.getGanhadores5Acertos();
        }

        return total;

    }

    public int totalDeGanhadoresSeis(List<MegaSena> sorteios) {
        log.info("Iniciando funcao contador de 6 acertos");

        int total = 0;

        for (MegaSena sorteio : sorteios) {

            total += sorteio.getGanhadores6Acertos();

        }

        return total;

    }

    public String formatarDoubleComoMoeda(double valor) {
        DecimalFormat df = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(Locale.getDefault()));
        df.setPositivePrefix("R$ ");
        df.setNegativePrefix("-R$ ");
        df.setNegativeSuffix("");

        return df.format(valor);
    }

    public String formatarBigDecimalComoMoeda(BigDecimal valor) {
        DecimalFormat df = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(Locale.getDefault()));
        df.setPositivePrefix("R$ ");
        df.setNegativePrefix("-R$ ");
        df.setNegativeSuffix("");

        return df.format(valor);
    }

    public String realizarSorteio(List<MegaSena> sorteios, int[] numerosUsuario) {
        log.info("Iniciando funcao sorteio de numeros do usuario");

        boolean houveGanhador = false;
        String mensagem = "";

        for (MegaSena sorteio : sorteios) {
            if (saoIguais(sorteio, numerosUsuario)) {
                houveGanhador = true;
                mensagem = "Esses numeros foram sorteados, no concurso n° " + sorteio.getConcurso() + " no dia: "
                        + formatarDataBrasileira(sorteio.getDataSorteio());
                break;
            }
        }

        if (!houveGanhador) {
            mensagem = "Não houve ganhador com essas dezenas.";
        }

        return mensagem;
    }

    public boolean saoIguais(MegaSena sorteio, int[] numerosUsuario) {
        int[] numerosSorteio = new int[]{sorteio.getBola1(), sorteio.getBola2(), sorteio.getBola3(),
                sorteio.getBola4(), sorteio.getBola5(), sorteio.getBola6()};

        Arrays.sort(numerosSorteio);
        Arrays.sort(numerosUsuario);

        return Arrays.equals(numerosSorteio, numerosUsuario);
    }

    public String sorteioAleatorio(List<MegaSena> sorteios, int[] numAleatorios) {
        log.info("Iniciando funcao sorteio de numeros aleatorios");
        String mensagem = "";
        boolean houveGanhador = false;

        for (MegaSena sorteio : sorteios) {
            if (saoIguais(sorteio, numAleatorios)) {
                mensagem = "Esses numeros foram sorteados, no concurso n° " + sorteio.getConcurso() + " no dia: "
                        + formatarDataBrasileira(sorteio.getDataSorteio());
                houveGanhador = true;
            }
        }

        if (!houveGanhador) {
            mensagem = "Não houve ganhador com essas dezenas.";
        }

        return mensagem;
    }

    public String formatarDataBrasileira(LocalDate data) {
        DateTimeFormatter formatoBrasileiro = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = data.format(formatoBrasileiro);
        return dataFormatada;
    }
}
