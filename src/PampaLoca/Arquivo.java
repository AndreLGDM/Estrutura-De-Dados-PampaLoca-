package PampaLoca;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Arquivo {

    public static void lerArquivoCSV(ILista ldeVeiculos, ILista ldeClientes, ILista ldeLocacao, ILista ldeCategorias){
        try{
            File csvFile = new File("lib\\Veiculos.csv");
            Scanner fileScanner = new Scanner(csvFile);

            fileScanner.nextLine();
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] linhas = line.split(";");
                Categoria categoria = new Categoria(Integer.parseInt(linhas[6]), line);
                Veiculo v = new Veiculo(linhas[0], linhas[1], linhas[2], Integer.parseInt(linhas[3]), Integer.parseInt(linhas[4]), Integer.parseInt(linhas[5]), categoria); 
                ldeVeiculos.insereFim(v);
            }
            fileScanner.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

        try{
            File csvFile = new File("lib\\Clientes.csv");
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
            File csvFile = new File("lib\\Locações.csv");
            Scanner fileScanner = new Scanner(csvFile);
        
            fileScanner.nextLine();
            while (fileScanner.hasNextLine()) {
                String[] linhas = fileScanner.nextLine().split(";");
                Veiculo v = new Veiculo(linhas[0]);
                Cliente c = new Cliente(linhas[1], linhas[2]);
        
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate dataDeRetirada = LocalDate.parse(linhas[3], formatter);
                LocalDate dataDeDevolucao = LocalDate.parse(linhas[4], formatter);
        
                Locacao L = new Locacao(c, v, dataDeRetirada, dataDeDevolucao);
                ldeLocacao.insereFim(L);
            }
            fileScanner.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        

        try{
            File csvFile = new File("lib\\Categorias.csv");
            Scanner fileScanner = new Scanner(csvFile);

            fileScanner.nextLine();
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] linhas = line.split(";");

                Categoria cl = new Categoria(Integer.parseInt(linhas[0]), linhas[1]);
                ldeCategorias.insereFim(cl);
            }
            fileScanner.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
    
    public static void gravarArquivoCSV(Cliente c) {

        try (FileOutputStream fos = new FileOutputStream("lib\\Clientes.csv", true);
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8)) {

            String data = String.join(";", c.getNome(), c.getCNH(), c.getTelefone(), c.getCPF());
            osw.write(data + "\n");
            osw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void gravarArquivoCSV(Veiculo v) {

        try (FileOutputStream fos = new FileOutputStream("lib\\Veiculos.csv", true);
                OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8)) {

            String ano = Integer.toString(v.getAnoVeiculo());
            String lugares = Integer.toString(v.getLugaresVeiculo());
            String potencia = Integer.toString(v.getPotenciaVeiculo());
            String categoria = Integer.toString(v.getCategoria().getIdCategoria());

            String data =  v.getPlacaVeiculo() + ";" + v.getModeloVeiculo() + ";" + v.getMarcaVeiculo() + ";" + ano + ";" + potencia
                    + ";" + lugares + ";" + categoria + "\n";
            osw.write(data);
            osw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void gravarArquivoCSV(Locacao l) {
        try {
            FileOutputStream fos = new FileOutputStream("lib\\Locações.csv", true);
            OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
    
            String modelo = l.getVeiculo().getModeloVeiculo().toString();
            String nome = l.getCliente().getNome().toString();
            String cnh = l.getCliente().getCNH().toString();
            String dataRetirada = l.getDataDeRetirada().toString();
            String dataDevolucao = l.getDataDeDevolucao().toString();
    
            String data = modelo + ";" + nome + ";" + cnh + ";" + dataRetirada + ";" + dataDevolucao;
            osw.write(data);
            osw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    public static void gravarArquivoCSV(Categoria c){
        try (FileOutputStream fos = new FileOutputStream("lib\\Categorias.csv", true);
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8)) {

            String Id = Integer.toString(c.getIdCategoria());
            String data = String.join(";", Id, c.getNomeCategoria());
            osw.write(data + "\n");
            osw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void editarArquivoCSV(String nomeArquivo, String identificador, int posicaoIdentificador, String antigo, int posicaoChave, String novo, int posicaoNovoValor) {
        try {
            File arquivoOriginal = new File(nomeArquivo);
            File arquivoTemporario = new File("lib\\temp.csv");
    
            FileReader fr = new FileReader(arquivoOriginal);
            BufferedReader br = new BufferedReader(fr);
    
            FileWriter fw = new FileWriter(arquivoTemporario);
            BufferedWriter bw = new BufferedWriter(fw);
    
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(";");
                if (campos[posicaoIdentificador].equals(identificador) && campos[posicaoChave].equals(antigo)) {
                    campos[posicaoNovoValor] = novo;
                    String novaLinha = String.join(";", campos);
                    bw.write(novaLinha + "\n");
                } else {
                    bw.write(linha + "\n");
                }
            }
    
            br.close();
            fr.close();
            bw.close();
            fw.close();
    
            arquivoOriginal.delete();
            arquivoTemporario.renameTo(arquivoOriginal);
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    

    public static void removerArquivoCSV(String nomeArquivo, String chave, int posicaoChave) {
        try {
            File arquivoOriginal = new File(nomeArquivo);
            File arquivoTemporario = new File("lib\\temp.csv");
    
            FileReader fr = new FileReader(arquivoOriginal);
            BufferedReader br = new BufferedReader(fr);
    
            FileWriter fw = new FileWriter(arquivoTemporario);
            BufferedWriter bw = new BufferedWriter(fw);
    
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(";");
                if (!campos[posicaoChave].equals(chave)) {
                    bw.write(linha + "\n");
                }
            }
    
            br.close();
            fr.close();
            bw.close();
            fw.close();
    
            arquivoOriginal.delete();
            arquivoTemporario.renameTo(arquivoOriginal);
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
