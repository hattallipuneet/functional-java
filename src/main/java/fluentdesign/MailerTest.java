package fluentdesign;

import java.util.function.Consumer;

public class MailerTest {

    public static void main(String[] args) {

    }

    /**
     * Code smell in this code :
     *  1. Repeated use of mailer instance
     *  2. Lifetime of mailer instance.
     *      ( Whether mailer instance can be used again to send another mail )
     * */
    private static void legacySmellyWay() {
        Mailer mailer = new Mailer();
        mailer.from("build@agiledeveloper.com");
        mailer.to("phattall@agiledeveloper.com");
        mailer.subject("build notification");
        mailer.body("...your code sucks...");
        mailer.send();
    }

    /**
     * Disadvantages of chaining technique:
     *  The design does not prevent someone from storing the reference from new and
     *  then chaining from that reference.
     *
     *
     * */
    private static void usingChaningMethod() {
        new MailBuilder()
                .from("build@agiledeveloper.com")
                .to("phattall@agiledeveloper.com")
                .subject("build notification")
                .body("...your code sucks...")
                .send();
    }

    private static void lambdaBasedDesign() {
        FluentMailer.send(
                mailer -> mailer.from("build@agiledeveloper.com")
                                .to("phattall@agiledeveloper.com")
                                .subject("build notification")
                                .body("...much better...")
        );
    }
}
