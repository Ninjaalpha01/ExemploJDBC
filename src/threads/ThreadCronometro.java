package threads;

import javax.swing.JFrame;

public class ThreadCronometro extends Thread {
    private JFrame cronometro;
    private long contador;

    public ThreadCronometro(JFrame cronometro) {
        this.contador = 0;
        this.cronometro = cronometro;
    }

    public void run() {
        System.out.println("iniciando contagem");
        iniciarContagem();
    }

    private void iniciarContagem() {
        while (true) {
            contador++;
            this.cronometro.getLblContador().setText(String.valueOf(this.cronometro.getContador()));
            System.out.println(contador);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
