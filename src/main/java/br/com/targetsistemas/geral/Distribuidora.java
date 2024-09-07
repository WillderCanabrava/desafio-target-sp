package br.com.targetsistemas.geral;

public class Distribuidora {
    public static void main(String[] args) {

        double sp = 67836.43;
        double rj = 36678.66;
        double mg = 29229.88;
        double es = 27165.48;
        double outros = 19849.53;

        double soma = sp + rj + mg + es + outros;

        double percentSp = (sp/soma) * 100;
        double percentRj = (rj/soma) * 100;
        double percentMg = (mg/soma) * 100;
        double percentEs = (es/soma) * 100;
        double percentOutros = (outros/soma) * 100;

        System.out.println(" SP: " + percentSp + "%\n RJ: " + percentRj + "%\n MG: "
                + percentMg + "%\n ES: " + percentEs + "%\n Outros: " + percentOutros + "%");
    }
}
