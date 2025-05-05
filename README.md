# poc-send-mail-mailhog
POC envío mail mediante SMPT con mailhog (simulador de SMTP)

### Pasos para levantar el aplicativo

1. Descargamos desde dockerhub la imagen de mailhog
```bash
https://hub.docker.com/r/mailhog/mailhog
```
2. Levantamos el POD en modo demonio
```bash
docker run --rm --name mailhog -p8025:8025 -p1025:1025 -d mailhog/mailhog
```
3. Accedemos a la consola administrativa para ver los correos
```bash
http://localhost:8025/#
```
4. Ejecutamos la clase SimplaEmailSender.java