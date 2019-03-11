/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sic.mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;




public class JCMail {
    private String from = "";
    private String password = "";
    private InternetAddress[] addressTo;
    private String subject = "";
    private String messageMail = "";
    
    public JCMail(){
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public InternetAddress[] getAddressTo() {
        return addressTo;
    }

    public void setAddressTo(InternetAddress[] addressTo) {
        this.addressTo = addressTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessageMail() {
        return messageMail;
    }

    public void setMessageMail(String messageMail) {
        this.messageMail = messageMail;
    }

    public void enviar( ) throws AddressException, MessagingException{
    	
    	Properties props = new Properties();
        props.put("mail.smtp.host", "10.20.100.70");
        //props.put("mail.smtp.auth", "true");
        //props.put("mail.smtp.user", "usuario");
        props.put("mail.smtp.port", 25);
        props.put("mail.smtp.timeout",  5000*60 );
        SMTPAuthenticator auth = new SMTPAuthenticator( getFrom(), getPassword() );
        Session session = Session.getInstance(props, auth);
        session.setDebug(false);
        MimeMessage mimemessage = new MimeMessage(session);
        InternetAddress addressFrom = new InternetAddress( getFrom() );
        mimemessage.setFrom(addressFrom);
        mimemessage.setRecipients(Message.RecipientType.TO, addressTo);
        mimemessage.setSubject( getSubject() );
        MimeBodyPart mimebodypart = new MimeBodyPart();
        mimebodypart.setText( getMessageMail() );
        mimebodypart.setContent( getMessageMail() , "text/html");
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimebodypart);
        mimemessage.setContent(multipart);
        mimemessage.setSentDate(new Date());
        Transport.send(mimemessage);
    }

       
    
    public void setTo( String mails ){
        String[] tmp =mails.split(",");
        addressTo = new InternetAddress[tmp.length];
        for (int i = 0; i < tmp.length; i++) {
            try {
                addressTo[i] = new InternetAddress(tmp[i]);
            } catch (AddressException ex) {
                System.out.println(ex);
            }
        }
    }


}