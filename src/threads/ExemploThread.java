package threads;

public class ExemploThread implements Runnable {
    private String nome;
    private int tempo;

    public static void main(String[] args) throws InterruptedException {
        ExemploThread exThread1 = new ExemploThread("Primeira", 400);
        Thread thread1 = new Thread(exThread1);

        ExemploThread exThread2 = new ExemploThread("Segundo", 600);
        Thread thread2 = new Thread(exThread2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Todas as threads foram finalizadas");
    }

    public ExemploThread(String nome, int tempo) {
        this.nome = nome;
        this.tempo = tempo;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(this.nome + ":\tcontador " + i);
                Thread.sleep(this.tempo);
            }
        } catch (InterruptedException e) {
            System.out.println("A thread " + nome + " foi interrompida.");
        } finally {
            System.out.println(this.nome + " finalizada.");
        }
    }
}
