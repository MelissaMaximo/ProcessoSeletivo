public class Questao4 {
    public static void main(String[] args) {
        double totalFaturamento = 67_836.43 + 36_678.66 + 29_229.88 + 27_165.48 + 19_849.53;
        double sp = 67_836.43;
        double rj = 36_678.66;
        double mg = 29_229.88;
        double es = 27_165.48;
        double outros = 19_849.53;

        System.out.printf("Percentual de SP: %.2f%%\n", (sp / totalFaturamento) * 100);
        System.out.printf("Percentual de RJ: %.2f%%\n", (rj / totalFaturamento) * 100);
        System.out.printf("Percentual de MG: %.2f%%\n", (mg / totalFaturamento) * 100);
        System.out.printf("Percentual de ES: %.2f%%\n", (es / totalFaturamento) * 100);
        System.out.printf("Percentual de Outros: %.2f%%\n", (outros / totalFaturamento) * 100);
    }
}
