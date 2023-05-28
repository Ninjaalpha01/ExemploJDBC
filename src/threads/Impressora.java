package threads;

public class Impressora {
    public synchronized void imprimir(String user, String[] docs) {
        try {
            System.out.println("Usuario: " + user + ". Iniciando impressao");

            for (int i = 0; i < docs.length; i++) {
                System.out.println("Imprimindo documento: " + docs[i]);
                Thread.sleep(500);
            }

            System.out.println("Usuario: " + user + ". Impressao finalizada");
        } catch (InterruptedException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
