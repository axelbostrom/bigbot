import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {

    static StupidQ stupidQ;
    static Quote quotes;

    public static void main(String[] args) throws LoginException {
        stupidQ = new StupidQ();
        quotes = new Quote();
        JDA jda = JDABuilder.createDefault(args[0]).addEventListeners(new Main()).build();
        try {
            jda.awaitReady();
            System.out.println("Finished building JDA");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();
        String name = event.getAuthor().getName();
        if (!name.equals("Big Bot")) {
            System.out.println("We recieved a message from " + name + ": " + message);
            if (message.equals("!stupid")) {
                stupidQ.increment();
                event.getChannel().sendMessage("Someone said something stupid. That was the " + stupidQ.getAmount() + "th time.").queue();
            }
            else if (message.equals("!counter")) {
                event.getChannel().sendMessage("Someone has said something stupid " + stupidQ.getAmount() + " times...").queue();
            }
            else if (message.contains("!quote")) {
                String[] test = message.split("!quote ");
                if (!test[1].equals("")) {
                    System.out.println(test[1]);
                    quotes.append(test[1]);
                    event.getChannel().sendMessage("Adding new quote...").queue();
                } else {
                    event.getChannel().sendMessage("No amazing quote was added, please type !quote <quote> to add a quote.").queue();
                }
            }
        }
    }
}
