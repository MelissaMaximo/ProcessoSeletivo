import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class Questao3 {

    public static void main(String[] args) {
        // Nome do arquivo XML
        String arquivoXML = "faturamento.xml";

        List<Double> valores = new ArrayList<>();

        try {
            // Configurar o parser XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Abrir o arquivo XML
            InputStream inputStream = new FileInputStream(arquivoXML);

            // Parsear o XML
            Document document = builder.parse(inputStream);
            document.getDocumentElement().normalize();

            // Obter a lista de elementos <faturamento>
            NodeList nodeList = document.getElementsByTagName("faturamento");

            // Iterar sobre os elementos <faturamento>
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                String valorStr = element.getElementsByTagName("valor").item(0).getTextContent();
                double valor = Double.parseDouble(valorStr);
                
                // Adicionar valores maiores que 0 para cálculos
                if (valor > 0) {
                    valores.add(valor);
                }
            }

            if (valores.isEmpty()) {
                System.out.println("Nenhum valor de faturamento encontrado.");
                return;
            }

            // Calcular o menor, maior valor e a média
            double menorValor = Double.MAX_VALUE;
            double maiorValor = Double.MIN_VALUE;
            double somaValores = 0;

            for (Double valor : valores) {
                if (valor < menorValor) {
                    menorValor = valor;
                }
                if (valor > maiorValor) {
                    maiorValor = valor;
                }
                somaValores += valor;
            }

            double mediaMensal = valores.size() > 0 ? somaValores / valores.size() : 0;

            // Contar os dias com faturamento acima da média
            int diasAcimaDaMedia = 0;
            for (Double valor : valores) {
                if (valor > mediaMensal) {
                    diasAcimaDaMedia++;
                }
            }

            // Exibir os resultados
            System.out.println("Menor valor de faturamento: " + menorValor);
            System.out.println("Maior valor de faturamento: " + maiorValor);
            System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);

        } catch (Exception e) {
            System.err.println("Erro ao processar o arquivo XML: " + e.getMessage());
        }
    }
}
