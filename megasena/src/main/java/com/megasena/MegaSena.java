package com.megasena;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.math.BigDecimal;

public class MegaSena {
    
        private int concurso;
        private LocalDate dataSorteio;
        private int bola1;
        private int bola2;
        private int bola3;
        private int bola4;
        private int bola5;
        private int bola6;
        private int ganhadores6Acertos;
        private String cidadeUF;
        private BigDecimal rateio6Acertos;
        private int ganhadores5Acertos;
        private double rateio5Acertos;
        private int ganhadores4Acertos;
        private double rateio4Acertos;
        private boolean acumulado6Acertos;
        private double arrecadacaoTotal;
        private double estimativaPremio;
        private double acumuladoSorteioEspecialMegaDaVirada;
        private String observacao;

        public MegaSena(){
            
        }
        
        public MegaSena(int concurso, LocalDate dataSorteio, int bola1, int bola2, int bola3, int bola4, int bola5,
                int bola6, int ganhadores6Acertos, String cidadeUF, BigDecimal rateio6Acertos, int ganhadores5Acertos,
                double rateio5Acertos, int ganhadores4Acertos, double rateio4Acertos, boolean acumulado6Acertos,
                double arrecadacaoTotal, double estimativaPremio, double acumuladoSorteioEspecialMegaDaVirada,
                String observacao) {
            this.concurso = concurso;
            this.dataSorteio = dataSorteio;
            this.bola1 = bola1;
            this.bola2 = bola2;
            this.bola3 = bola3;
            this.bola4 = bola4;
            this.bola5 = bola5;
            this.bola6 = bola6;
            this.ganhadores6Acertos = ganhadores6Acertos;
            this.cidadeUF = cidadeUF;
            this.rateio6Acertos = rateio6Acertos;
            this.ganhadores5Acertos = ganhadores5Acertos;
            this.rateio5Acertos = rateio5Acertos;
            this.ganhadores4Acertos = ganhadores4Acertos;
            this.rateio4Acertos = rateio4Acertos;
            this.acumulado6Acertos = acumulado6Acertos;
            this.arrecadacaoTotal = arrecadacaoTotal;
            this.estimativaPremio = estimativaPremio;
            this.acumuladoSorteioEspecialMegaDaVirada = acumuladoSorteioEspecialMegaDaVirada;
            this.observacao = observacao;
        }


        public int getConcurso() {
            return concurso;
        }


        public void setConcurso(int concurso) {
            this.concurso = concurso;
        }


        public LocalDate getDataSorteio() {
            return dataSorteio;
        }


        public void setDataSorteio(LocalDate dataSorteio) {
            this.dataSorteio = dataSorteio;
        }


        public int getBola1() {
            return bola1;
        }


        public void setBola1(int bola1) {
            this.bola1 = bola1;
        }


        public int getBola2() {
            return bola2;
        }


        public void setBola2(int bola2) {
            this.bola2 = bola2;
        }


        public int getBola3() {
            return bola3;
        }


        public void setBola3(int bola3) {
            this.bola3 = bola3;
        }


        public int getBola4() {
            return bola4;
        }


        public void setBola4(int bola4) {
            this.bola4 = bola4;
        }


        public int getBola5() {
            return bola5;
        }


        public void setBola5(int bola5) {
            this.bola5 = bola5;
        }


        public int getBola6() {
            return bola6;
        }


        public void setBola6(int bola6) {
            this.bola6 = bola6;
        }


        public int getGanhadores6Acertos() {
            return ganhadores6Acertos;
        }


        public void setGanhadores6Acertos(int ganhadores6Acertos) {
            this.ganhadores6Acertos = ganhadores6Acertos;
        }


        public String getCidadeUF() {
            return cidadeUF;
        }


        public void setCidadeUF(String cidadeUF) {
            this.cidadeUF = cidadeUF;
        }


        public BigDecimal getRateio6Acertos() {
            return rateio6Acertos;
        }


        public void setRateio6Acertos(BigDecimal rateio6Acertos) {
            this.rateio6Acertos = rateio6Acertos;
        }


        public int getGanhadores5Acertos() {
            return ganhadores5Acertos;
        }


        public void setGanhadores5Acertos(int ganhadores5Acertos) {
            this.ganhadores5Acertos = ganhadores5Acertos;
        }


        public double getRateio5Acertos() {
            return rateio5Acertos;
        }


        public void setRateio5Acertos(double rateio5Acertos) {
            this.rateio5Acertos = rateio5Acertos;
        }


        public int getGanhadores4Acertos() {
            return ganhadores4Acertos;
        }


        public void setGanhadores4Acertos(int ganhadores4Acertos) {
            this.ganhadores4Acertos = ganhadores4Acertos;
        }


        public double getRateio4Acertos() {
            return rateio4Acertos;
        }


        public void setRateio4Acertos(double rateio4Acertos) {
            this.rateio4Acertos = rateio4Acertos;
        }


        public boolean isAcumulado6Acertos() {
            return acumulado6Acertos;
        }


        public void setAcumulado6Acertos(boolean acumulado6Acertos) {
            this.acumulado6Acertos = acumulado6Acertos;
        }


        public double getArrecadacaoTotal() {
            return arrecadacaoTotal;
        }


        public void setArrecadacaoTotal(double arrecadacaoTotal) {
            this.arrecadacaoTotal = arrecadacaoTotal;
        }


        public double getEstimativaPremio() {
            return estimativaPremio;
        }


        public void setEstimativaPremio(double estimativaPremio) {
            this.estimativaPremio = estimativaPremio;
        }


        public double getAcumuladoSorteioEspecialMegaDaVirada() {
            return acumuladoSorteioEspecialMegaDaVirada;
        }


        public void setAcumuladoSorteioEspecialMegaDaVirada(double acumuladoSorteioEspecialMegaDaVirada) {
            this.acumuladoSorteioEspecialMegaDaVirada = acumuladoSorteioEspecialMegaDaVirada;
        }


        public String getObservacao() {
            return observacao;
        }


        public void setObservacao(String observacao) {
            this.observacao = observacao;
        }


        @Override
        public String toString() {
            return "MegaSena [concurso=" + concurso + ", dataSorteio=" + dataSorteio + ", bola1=" + bola1 + ", bola2="
                    + bola2 + ", bola3=" + bola3 + ", bola4=" + bola4 + ", bola5=" + bola5 + ", bola6=" + bola6
                    + ", ganhadores6Acertos=" + ganhadores6Acertos + ", cidadeUF=" + cidadeUF + ", rateio6Acertos="
                    + rateio6Acertos + ", ganhadores5Acertos=" + ganhadores5Acertos + ", rateio5Acertos="
                    + rateio5Acertos + ", ganhadores4Acertos=" + ganhadores4Acertos + ", rateio4Acertos="
                    + rateio4Acertos + ", acumulado6Acertos=" + acumulado6Acertos + ", arrecadacaoTotal="
                    + arrecadacaoTotal + ", estimativaPremio=" + estimativaPremio
                    + ", acumuladoSorteioEspecialMegaDaVirada=" + acumuladoSorteioEspecialMegaDaVirada + ", observacao="
                    + observacao + "]";
        }

        public LocalDate converterData(String dataString) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(dataString, formatter);
            return data;
        }
    }