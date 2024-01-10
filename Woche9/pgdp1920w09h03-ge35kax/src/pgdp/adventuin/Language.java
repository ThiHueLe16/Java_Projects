package pgdp.adventuin;

public enum Language {
	ENGLISH{
		public String getLocalizedChristmasGreeting(String greeterName) {
			return "Fröhliche Weihnachten wünscht dir "+greeterName+"!";
		};
	},
	GERMAN{
		public String getLocalizedChristmasGreeting(String greeterName) {
			return greeterName+" wishes you a Merry Christmas!";
		};
	};
	public abstract String getLocalizedChristmasGreeting(String greeterName);
	
}
