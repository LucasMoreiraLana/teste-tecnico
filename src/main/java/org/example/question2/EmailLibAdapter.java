package org.example.question2;

public class EmailLibAdapter implements EnviaEmail {
    private final EmailLib emailLib;

    public EmailLibAdapter(EmailLib emailLib) {
        this.emailLib = emailLib;
    }

    // Aqui traduzimos a chamada
    @Override
    public void enviar(String destinatario, String mensagem) {
        emailLib.enviarEmail(destinatario, mensagem);
    }
}
