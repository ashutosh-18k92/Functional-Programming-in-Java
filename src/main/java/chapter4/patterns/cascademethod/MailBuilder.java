package chapter4.patterns.cascademethod;

public class MailBuilder {
    /*Cascade method pattern.
    * --------------------------
    * rather than having void methods, we make each
    * method return an instance. we use this returned method object
    * to build on or chain the subsequent calls. */

    public MailBuilder from(final String address){
        return this;
    }
    public MailBuilder to(final String subject){
        return this;
    }

    public MailBuilder subject(final String subject){
        return this;
    }
    public MailBuilder body(final String body){
        return this;
    }

}
