package com.pronaca.poc.mailhog;

import java.util.Properties;

import jakarta.mail.*;
import jakarta.mail.internet.*;

public class SimpleEmailSender {
	public static void main(String[] args) {
        // Configuración del correo
        String host = "127.0.0.1";
        String port = "1025";
        String usuario = "tucorreo@gmail.com";       // Tu correo
        String clave = "tu_contraseña_o_app_password"; // Tu contraseña o app password

        String destinatario = "destinatario@ejemplo.com";
        String asunto = "Invitación HTML";
        String cuerpo = "Hola, este es un correo enviado desde Java puro.";
        String html = generarHtmlInvitacion();
        enviarCorreo(host, port, usuario, clave, destinatario, asunto, html);
    }

    public static void enviarCorreo(String host, String puerto, final String usuario, final String clave,
                                    String destino, String asunto, String htmlBody) {
        // Propiedades del servidor SMTP
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", puerto);
        props.put("mail.smtp.auth", "false");
        props.put("mail.smtp.starttls.enable", "false"); // Para TLS

        // Autenticación y sesión
        Session sesion = Session.getInstance(props);

        try {
            // Crear el mensaje
            Message mensaje = new MimeMessage(sesion);
            mensaje.setFrom(new InternetAddress(usuario));
            mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destino));
            mensaje.setSubject(asunto);
            mensaje.setContent(htmlBody, "text/html; charset=utf-8");
            //mensaje.setText(texto);

            // Enviar
            Transport.send(mensaje);
            System.out.println("Correo enviado correctamente.");
        } catch (MessagingException e) {
            System.out.println("Error al enviar el correo:");
            e.printStackTrace();
        } catch (Exception e) {
			System.err.println("ERROR GENERAL");
			e.printStackTrace();
		}
    }
    
    public static String generarHtmlInvitacion() {
        return "<html>" +
            "<head>" +
            "<style>" +
            "body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 20px; }" +
            ".card { background-color: #ffffff; padding: 30px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); max-width: 600px; margin: auto; }" +
            "h1 { color: #2c3e50; }" +
            "p { color: #555555; }" +
            ".btn { display: inline-block; margin-top: 20px; padding: 10px 20px; background-color: #007bff; color: white; text-decoration: none; border-radius: 4px; }" +
            "</style>" +
            "</head>" +
            "<body>" +
            "<div class=\"card\">" +
            //"<img src=\"https://img.freepik.com/vector-premium/ilustracion-isometrica-3d-tecnologia-digital_1284-42134.jpg\" width=\"100%\" style=\"border-radius: 8px 8px 0 0;\" alt=\"Evento de tecnología\" />" +
            "<h1>🚀 Invitación al Tech Connect 2025</h1>" +
            "<p>Estás cordialmente invitado a nuestro evento exclusivo de tecnología, donde exploraremos las últimas tendencias en innovación, inteligencia artificial, y desarrollo de software.</p>" +
            "<p><strong>📅 Fecha:</strong> 12 de junio de 2025<br/>" +
            "<strong>📍 Lugar:</strong> Centro de Convenciones, Quito<br/>" +
            "<strong>🕘 Hora:</strong> 09h00 - 17h00</p>" +
            "<p>No te pierdas esta oportunidad de conectar con profesionales, startups y líderes del sector.</p>" +
            "<a class=\"btn\" href=\"https://tuevento-tecnologia.com/registro\" target=\"_blank\">Confirmar Asistencia</a>" +
            "</div>" +
            "</body>" +
            "</html>";
    }

}
