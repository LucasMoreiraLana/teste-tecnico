package org.example.question2;

public class SistemaNotificacao {
    private final EnviaEmail envia;

    public SistemaNotificacao(EnviaEmail envia) {
        this.envia = envia;
    }

    public void notificarUsuario(String destinatario, String mensagem) {
        envia.enviar(destinatario, mensagem);
    }

    public static void main(String[] args) {
        EmailLib emailLib = new EmailLib();
        EnviaEmail adaptador = new EmailLibAdapter(emailLib);
        SistemaNotificacao sistema = new SistemaNotificacao(adaptador);

        sistema.notificarUsuario("joao@email.com", "Bem-vindo!");
    }

    //Esperamos a saída:
    //Enviando e-mail para joao@email.com: Bem-vindo!
}