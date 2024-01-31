# jmail-sender
Developed based on java mail mail service small framework , quickly implanted in your springboot server .


How to use in my springboot application?
Here's a basic smtp mailer use case.

```java
@Component
public class SmtpMailSender {

    private MailSender mailSender;

    @Value("${mail.account}")
    public String mailAccount;
    @Value("${mail.authentication}")
    public String mailAuthentication;
    @Value("${mail.smtp-host}")
    public String smtpHost;
    @Value("${mail.smtp-port}")
    public String smtpPort;
    @Value("${mail.auth-enable}")
    public String authenticationEnable;
    @Value("${mail.tls-enable}")
    public String useTLS;

    @PostConstruct
    public void init(){
        MailFactory mailFactory = new MailFactory();
        SmtpHostRegistrar smtpHostRegistrar = new SmtpHostRegistrarImpl()
                .setHost(smtpHost)
                .setPort(smtpPort)
                .setUseTLS(Boolean.valueOf(useTLS));

        if (Boolean.valueOf(authenticationEnable) != null && Boolean.valueOf(authenticationEnable)){
            smtpHostRegistrar.setAuth(new SmtpAuthenticator(mailAccount, mailAuthentication));
        }

        mailSender = mailFactory.getSender(smtpHostRegistrar,true);
    }

    public void send(String subject, String context, String receiver){
        try {
            mailSender.send(subject, context, receiver);
        } catch (MessagingException e) {
            throw new RuntimeException("邮件发送异常");
        }
    }

}
```
