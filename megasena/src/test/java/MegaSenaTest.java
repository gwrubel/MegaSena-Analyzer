
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.megasena.Leitura;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.megasena.MegaSena;

public class MegaSenaTest {

    private Leitura leitura;

    @Before
    public void setUp() {
        leitura = new Leitura();
    }

    @Test
    public void testTratarValorMonetario() {

        String valor = "R$ 700,00";
        double expectativa = 700.00;

        Assert.assertEquals(expectativa, leitura.tratarValorMonetario(valor), 0);
    }

    @Test
    public void testTratarValorMonetarioBig() {

        String valor = "R$ 90.000.000,00";
        BigDecimal expectativa = new BigDecimal("90000000.00");

        Assert.assertEquals(expectativa, leitura.tratarValorMonetarioBig(valor));
    }



    @Test
    public void testVezesQueNaoTeveSeis() {
        MegaSena sorteio1 = new MegaSena();
        MegaSena sorteio2 = new MegaSena();
        MegaSena sorteio3 = new MegaSena();
        MegaSena sorteio4 = new MegaSena();
        MegaSena sorteio5 = new MegaSena();
        MegaSena sorteio6 = new MegaSena();

        sorteio1.setGanhadores6Acertos(1);
        sorteio2.setGanhadores6Acertos(0);
        sorteio3.setGanhadores6Acertos(0);
        sorteio4.setGanhadores6Acertos(1);
        sorteio5.setGanhadores6Acertos(0);
        sorteio6.setGanhadores6Acertos(1);

        List<MegaSena> sorteios = new ArrayList<>();
        sorteios.add(sorteio1);
        sorteios.add(sorteio2);
        sorteios.add(sorteio3);
        sorteios.add(sorteio4);
        sorteios.add(sorteio5);
        sorteios.add(sorteio6);

        int expectativa = 3;

        Assert.assertEquals(expectativa,leitura.vezesQueNaoTeveSeis(sorteios));
    }

    @Test
    public void testMaiorMenorQuatroAcertos() {
        // Crie alguns objetos MegaSena com valores de rateio4Acertos diferentes
        MegaSena sorteio1 = new MegaSena();
        sorteio1.setRateio4Acertos(100.00);

        MegaSena sorteio2 = new MegaSena();
        sorteio2.setRateio4Acertos(150.00);

        List<MegaSena> sorteios = new ArrayList<>();
        sorteios.add(sorteio1);
        sorteios.add(sorteio2);

        double[] expectativa = { 100.00, 150.00 };
        Assert.assertArrayEquals(expectativa, leitura.maiorMenorQuatroAcertos(sorteios), 0.001);
    }

    @Test
    public void testMaiorMenorCincoAcertos() {
        MegaSena sorteio1 = new MegaSena();
        sorteio1.setRateio5Acertos(1000.00);

        MegaSena sorteio2 = new MegaSena();
        sorteio2.setRateio5Acertos(10.00);

        List<MegaSena> sorteios = new ArrayList<>();
        sorteios.add(sorteio1);
        sorteios.add(sorteio2);

        double[] expectativa = { 10.00, 1000.00 };
        Assert.assertArrayEquals(expectativa, leitura.maiorMenorCincoAcertos(sorteios), 0.001);
    }

    @Test
    public void testMaiorMenorSeisAcertos() {
        MegaSena sorteio1 = new MegaSena();
        sorteio1.setRateio6Acertos(new BigDecimal("100.0"));

        MegaSena sorteio2 = new MegaSena();
        sorteio2.setRateio6Acertos(new BigDecimal("200.0"));

        MegaSena sorteio3 = new MegaSena();
        sorteio3.setRateio6Acertos(new BigDecimal("4400.0"));

        List<MegaSena> sorteios = new ArrayList<>();
        sorteios.add(sorteio1);
        sorteios.add(sorteio2);
        sorteios.add(sorteio3);

        BigDecimal[] expected = { BigDecimal.valueOf(100.00), BigDecimal.valueOf(4400.00) };
        BigDecimal[] result = leitura.maiorMenorSeisAcertos(sorteios);

        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void testTotalDeGanhadores4Acertos() {
        MegaSena ganhadores = new MegaSena();
        ganhadores.setGanhadores4Acertos(100);

        List<MegaSena> sorteios = new ArrayList<>();
        sorteios.add(ganhadores);

        int expectativa = 100;
        int resultado = leitura.totalDeGanhadoresQuatro(sorteios);

        Assert.assertEquals(expectativa, resultado);
    }

    @Test
    public void testTotalDeGanhadores5Acertos() {
        MegaSena ganhadores = new MegaSena();
        ganhadores.setGanhadores5Acertos(500);

        List<MegaSena> sorteios = new ArrayList<>();
        sorteios.add(ganhadores);

        int expectativa = 500;
        int resultado = leitura.totalDeGanhadoresCinco(sorteios);

        Assert.assertEquals(expectativa, resultado);
    }

    @Test
    public void testTotalDeGanhadores6Acertos() {
        MegaSena ganhadores = new MegaSena();
        ganhadores.setGanhadores6Acertos(6000);

        List<MegaSena> sorteios = new ArrayList<>();
        sorteios.add(ganhadores);

        int expectativa = 6000;
        int resultado = leitura.totalDeGanhadoresSeis(sorteios);

        Assert.assertEquals(expectativa, resultado);
    }

    @Test
    public void testFormatarDoubleComoMoeda() {

        double valorPositvo = 55.00;
        double valorNegativo = -60.00;
        double zero = 0;

        Assert.assertEquals("R$ 55,00", leitura.formatarDoubleComoMoeda(valorPositvo));
        Assert.assertEquals("-R$ 60,00", leitura.formatarDoubleComoMoeda(valorNegativo));
        Assert.assertEquals("R$ 0,00", leitura.formatarDoubleComoMoeda(zero));
    }

    @Test
    public void testFormatarBigDecimalComoMoeda() {

        BigDecimal valorPositivo = new BigDecimal("1000.0");
        BigDecimal valorNegativo = new BigDecimal("-500.75");
        BigDecimal zero = BigDecimal.ZERO;

        Assert.assertEquals("R$ 1.000,00", leitura.formatarBigDecimalComoMoeda(valorPositivo));
        Assert.assertEquals("-R$ 500,75", leitura.formatarBigDecimalComoMoeda(valorNegativo));
        Assert.assertEquals("R$ 0,00", leitura.formatarBigDecimalComoMoeda(zero));
    }

    @Test
    public void testSaoIguais (){
        MegaSena sorteio = new MegaSena();

        sorteio.setBola1(6);
        sorteio.setBola2(5);
        sorteio.setBola3(4);
        sorteio.setBola4(3);
        sorteio.setBola5(2);
        sorteio.setBola6(1);

        int numerosUsuario []= {1,2,3,4,5,6};

        boolean expectativa = leitura.saoIguais(sorteio, numerosUsuario);

        Assert.assertTrue(expectativa);
    }


    @Test
    public void testFormatarDataBR(){

        LocalDate data = LocalDate.of(2022,5,12);
        String expectativa = "12/05/2022";

        Assert.assertEquals(expectativa,leitura.formatarDataBrasileira(data));
    }
}
