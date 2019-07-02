import java.util.Scanner;
public class Cripto {

    public static void main(String[] args){
        try {
            Scanner captura = new Scanner(System.in);
            System.out.println("*********************************");

            //Leitura da mensagem e chave de criptografia
            System.out.println("Informe a mensagem a ser criptografada!");
            String mensagem = captura.nextLine();

            System.out.println("Informe o numero que servira de chave de codificação!");
            int chave = captura.nextInt();

            //Codificando
            System.out.println("*******  Codificando  *******");
            String mensagemCodificada = encriptador(chave, mensagem);

            //Decodificando
            System.out.println("*******  Decodificando  *******");
            String mensagemDecodificada = desencripta(chave, mensagemCodificada);

            //Impressão dos resultados

            System.out.println("\n\n MENSAGEM CRIPTOGRAFADA :" + mensagemCodificada);
            System.out.println("\n\n MENSAGEM DECRIPTOGRAFADA :" + mensagemDecodificada);


            System.out.println("*********************************");
        }catch (RuntimeException e){
            System.out.println(" A chave de codificação foi informada incorretamente");
            System.out.println(" Execute o programa novamente e entre com uma chave válida.");
        }
    }

    /*
    *
    *  Encriptador da mensagem.
    *
    */
    public static String encriptador( int chave, String mensagem){

        StringBuilder mensagemCodificada = new StringBuilder();

        int tamanhoMensagem = mensagem.length();

        for(int l= 0 ;l< tamanhoMensagem; l++ ){

            int letraCodificada = ((int)mensagem.charAt(l))+ chave;

            while(letraCodificada > 126){
                letraCodificada -= 94;
            }

            mensagemCodificada.append((char)letraCodificada);
        }
        return mensagemCodificada.toString();
    }

    /*
     *
     *  Desencriptador da mensagem.
     *
     */
    public static  String desencripta(int chave, String mensagemCodificada){

        StringBuilder mensagem = new StringBuilder();

        int tamanhoMensagem = mensagemCodificada.length();

        for(int l= 0; l < tamanhoMensagem; l++ ){

            int letraDecodificada = ((int)mensagemCodificada.charAt(l)) - chave;

            while(letraDecodificada < 32){
                letraDecodificada += 94;
            }

            mensagem.append((char)letraDecodificada);
        }
        return mensagem.toString();
    }
}
