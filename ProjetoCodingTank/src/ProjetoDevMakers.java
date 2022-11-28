import java.util.InputMismatchException;
import java.util.Scanner;

public class ProjetoDevMakers {
    public static void main(String[] args) {
        int valores = 0;
        double media = 0;
        String operacao = "";

        //Pede o número de entradas para o usuário
        //Apenas números inteiros e positivos
        valores = getNumber();

        //Pergunta ao usuário o tipo de operação
        //media aritmetica ou media harmonica
        operacao = getOperation();

        //Pede os valores para o usuário e armazena numa array
        int[] arr =  getNumbers(valores);

        //Verifica se a operação é aritmetica ou harmonica
        if (operacao.equalsIgnoreCase("aritmetica")){
            media = calcularMediaAritmetica(arr);
            System.out.printf("O calculo da media aritmetica é %.2f!", media);
        } else if (operacao.equalsIgnoreCase("harmonica")) {
            media = calcularMediaHarmonica(arr);
            System.out.printf("O calculo da media harmonica é %.2f!", media);
        }

    }

    // Pede um número para o usuário
    //Deve ser inteiro e positivo
    public static int getNumber(){
        boolean teste = true;
        int num = 0;

        try {
            while (teste == true) {
                Scanner entrada = new Scanner(System.in);
                System.out.println("Digite o número de entradas(somente numeros inteiros e postivos): ");
                num = entrada.nextInt();
                if (num > 0) {
                    teste = false;
                } else {
                    System.out.println("Erro! O número deve ser maior que zero.");
                }
            }
            return num;
        } catch (InputMismatchException e) {
            System.out.println("Input inválido.");
            return getNumber();
        }
    }

    //Recebe o tipo de operação
    //Aritmetica ou Harmonica
    public static String getOperation(){
        boolean teste = true;
        String operacao = "";
        String aritmetica = "ARITMETICA";
        String harmonica = "HARMONICA";

        try {
            while (teste == true) {
                Scanner entrada = new Scanner(System.in);
                System.out.println("Digite a operação (ARITMETICA ou HARMONICA): ");
                operacao = entrada.nextLine();
                if (operacao.equalsIgnoreCase(aritmetica) || operacao.equalsIgnoreCase(harmonica)) {
                    teste = false;
                } else {
                    System.out.println("Operacao invalida!");
                }
            }
            return operacao;
        } catch (InputMismatchException e) {
            System.out.println("Operacao invalida!");
            return getOperation();
        }
    }

    //Recebe os valores para cálculo da média
    public static int[] getNumbers(int tamanho){
        int[] arr = new int[tamanho];
        boolean teste = true;
        int num = 0;
        try {
            for (int i = 0; i < arr.length; i++){
            Scanner entrada = new Scanner(System.in);
            System.out.printf("Digite o %dº número (somente numeros inteiros e positivos): ",i+1);
            num = entrada.nextInt();
            while (num < 0) {
                System.out.println("O número deve ser maior ou igual a zero.");
                System.out.printf("Digite o %dº número (somente numeros inteiros e positivos): ",i+1);
                num = entrada.nextInt();
            }
            arr[i] = num;
            }
        } catch (InputMismatchException e) {
                System.out.println("Numero inválido!Comece novamente!\n");
                return getNumbers(tamanho);
        }
        return arr;
    }

    //Retorna o cálculo da média aritmética
    public static double calcularMediaAritmetica(int[] arr){
        double media = 0;

        for (int i = 0; i < arr.length; i++) {
            media = media + arr[i];
        }

        media = media / (arr.length);
        return media;
    }

    //Retorna o cálculo da média harmônica
    public static double calcularMediaHarmonica(int[] arr){
        double media = 0;

        for (int i = 0; i < arr.length; i++) {
            media = media + (1.0 / arr[i]);
        }
        return arr.length/media;
    }
}