package threads;

public class ExemploImpressora extends Thread {
    private String user;
    private String[] docs;
    private static Impressora impressora;

    public static void main(String[] args) {
        String[] documents = {"Doc 1", "Doc 2", "Doc 3"};
        ExemploImpressora ex1 = new ExemploImpressora("Gabriel", documents);
        ExemploImpressora ex2 = new ExemploImpressora("Thais", documents);

        ex1.start();
        ex2.start();
    }

    private ExemploImpressora(String user, String[] docs) {
        this.user = user;
        this.docs = docs;
        this.impressora = new Impressora();
    }

    public void run() {
        impressora.imprimir(user, docs);
    }
}
