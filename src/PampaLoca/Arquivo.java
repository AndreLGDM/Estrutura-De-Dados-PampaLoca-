package PampaLoca;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Arquivo {

    public static void lerArquivoCSV(ILista ldeVeiculos, ILista ldeClientes, ILista ldeLocacao, ILista ldeCategorias){
        try{
            File csvFile = new File("Veiculos.csv");
            Scanner fileScanner = new Scanner(csvFile);

            fileScanner.nextLine();
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] linhas = line.split(";");
                Veiculo v = new Veiculo(linhas[0], linhas[1], linhas[2], Integer.parseInt(linhas[4], linhas [5], linhas[6]), linhas[7]); 
                // linha 7 é uma classe, talvez tenha complicações ao passar a informação do arquivo para ela
                ldeVeiculos.insereFim(v);
            }
            fileScanner.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

        try{
            File csvFile = new File("Clientes.csv");
            Scanner fileScanner = new Scanner(csvFile);

            fileScanner.nextLine();
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] linhas = line.split(";");

                Cliente c = new Cliente(linhas[0], linhas[1], linhas[2], linhas[3]);
                ldeClientes.insereFim(c);

            }
            fileScanner.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

        try{
            File csvFile = new File("Locações.csv");
            Scanner fileScanner = new Scanner(csvFile);

            fileScanner.nextLine();
            while (fileScanner.hasNextLine()) {
                String[] linhas = fileScanner.nextLine().split(";");
                Veiculo v = new Veiculo("", linhas[0], "", 0, 0, 0, 0);
                //novamente checar se esse construtor funciona com a classe categoria no 0 final
                Cliente c = new Cliente(linhas[1], linhas[2], "", "");
                Locacao L = new Locacao(v, c);
                ldeLocacao.insereFim(L);

            }
            fileScanner.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try{
            File csvFile = new File("Categorias.csv");
            Scanner fileScanner = new Scanner(csvFile);

            fileScanner.nextLine();
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] linhas = line.split(";");

                Categoria cl = new Categoria(linhas[0], linhas[1]);
                ldeCategorias.insereFim(cl);
            }
            fileScanner.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
    
    public static void gravarArquivoCSV(Cliente c) {

        try (FileOutputStream fos = new FileOutputStream("Clientes.csv", true);
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8)) {
            String data = String.join(";", c.getNome(), c.getCNH(), c.getTelefone(), c.getCPF());
            osw.write(data + "\n");
            osw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void gravarArquivoCSV(Veiculo v) {

        try (FileOutputStream fos = new FileOutputStream("Veiculos.csv", true);
                OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8)) {

            String ano = Integer.toString(v.getAnoVeiculo());
            String lugares = Integer.toString(v.getLugaresVeiculo());
            String potencia = Integer.toString(v.getPotenciaVeiculo());
            String categoria = Categoria.toString(v.getCategoria());
            // não sei se a linha acima funciona, é um teste

            String data =  ca.getPlacaVeiculo() + ";" + ca.getModeloVeiculo() + ";" + ca.getMarcaVeiculo() + ";" + ano + ";" + potencia
                    + ";" + lugares + ";" + categoria + "\n";
            osw.write(data);
            osw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void gravarArquivoCSV(Locacao l) {
        try {
            FileOutputStream fos = new FileOutputStream("Locações.csv", true);
            OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);

            String Modelo = l.getVeiculo().getModeloVeiculo().toString();
            String Nome = l.getCliente().getNome().toString();
            String CNH = l.getCliente().getCnh().toString();

            String data = Modelo + ";" + Nome + ";" + CNH;
            osw.write(data);
            osw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void gravarArquivoCSV(Categoria c){
        try (FileOutputStream fos = new FileOutputStream("Categorias.csv", true);
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8)) {
            String data = String.join(";", c.getIdCategoria(), c.getNomeCategoria());
            osw.write(data + "\n");
            osw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
