import java.util.Arrays;
import java.util.List;
import java.util.Locale;

// Aviso: Este código em java foi uma conversão da minha solucão em kotlin feita pelo gemini. Se possível avaliar minha solucão. desde ja agradeço

public class SalesProcessor {

    private static class SalesResult {
        int count;
        double amount;

        SalesResult(int count, double amount) {
            this.count = count;
            this.amount = amount;
        }
    }
    public static void main(String[] args) {
        List<String> salesData = Arrays.asList(
                "8349,14/09/2024,899.9,ESPORTE",
                "4837,17/09/2024,530.0,VESTUARIO",
                "15281,21/09/2024,1253.99,ESPORTE",
                "15344,27/09/2024,1000.9,VESTUARIO",
                "18317,04/10/2024,250.4,VESTUARIO",
                "18972,11/10/2024,385.5,JARDINAGEM"
        );

        String department = "VESTUARIO";
        Double[] result = totalSales(salesData, department);
        String numberFormat = String.format(Locale.US, "%.2f", result[1]);
        System.out.println((int) result[0].doubleValue() + " VENDAS");
        System.out.println("TOTAL = $ " + numberFormat);
    }

    public static Double[] totalSales(List<String> sales, String department) {
        SalesResult resultPair = calculateSales(sales, department);
        return new Double[]{ (double) resultPair.count, resultPair.amount };
    }

    private static SalesResult calculateSales(List<String> sales, String department) {
        double amount = 0.0;
        int count = 0;

        for (String saleRecord : sales) {
            String[] parsed = saleRecord.split(",");
            String recordDepartment = parsed[3];

            if (recordDepartment.equals(department)) {
                amount += Double.parseDouble(parsed[2]);
                count++;
            }
        }

        return new SalesResult(count, amount);
    }
}
