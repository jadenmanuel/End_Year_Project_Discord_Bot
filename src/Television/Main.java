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
		//jda = (new JDABuilder(AccountType.BOT)).setToken("ODUxODg5Mjk0Nzk1OTk3Mjcz.YL-1uw.1dyGK_Wt_8Xh5aCW4vdYYDBWZ3M").buildAsync();
		 JDABuilder builder = JDABuilder.createDefault("ODUxODg5Mjk0Nzk1OTk3Mjcz.YL-1uw.1dyGK_Wt_8Xh5aCW4vdYYDBWZ3M");
		 //builder.setToken("ODUxODg5Mjk0Nzk1OTk3Mjcz.YL-1uw.1dyGK_Wt_8Xh5aCW4vdYYDBWZ3M");
		 
		 builder.setStatus(OnlineStatus.ONLINE); 
		 jda = builder.build();
		 //jda.getPresence().setStatus(OnlineStatus.IDLE);
		 
		 jda.addEventListener(new Clear());
		 
		
	}
	
}
