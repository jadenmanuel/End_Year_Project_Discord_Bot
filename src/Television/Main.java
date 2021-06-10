package Television;

import javax.security.auth.login.LoginException;

import Television.Commands.Clear;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.JDA;

public class Main {
	public static net.dv8tion.jda.api.JDA jda;
	public static String prefix = "~";
	
	
	public static void main(String[] args) throws LoginException {
		 JDABuilder builder = JDABuilder.createDefault(DiscordSecrets.token);

		 
		 builder.setStatus(OnlineStatus.ONLINE); 
		 jda = builder.build();
		 //jda.getPresence().setStatus(OnlineStatus.IDLE);
		 
		 jda.addEventListener(new Clear());
		 
		
	}
	
}
