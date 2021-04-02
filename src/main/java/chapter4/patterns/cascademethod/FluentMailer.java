package chapter4.patterns.cascademethod;

import java.util.function.Consumer;

public class FluentMailer {

    public static void send(final Consumer<MailBuilder> block) {
        final MailBuilder mailBuilder = new MailBuilder();
        block.accept(mailBuilder);

    }

    public static void main(String[] args) {
        FluentMailer.send(mailBuilder ->
                mailBuilder
                        .from("ashutosh.18k092@abc.com")
                        .to("ashish@def.com")
                        .subject("hi")
                        .body("Hey, How are you?"));
    }
}
