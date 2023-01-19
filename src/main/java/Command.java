public enum Command {
	BYE			("bye", false),
	LIST		("list", false),
	MARK		("mark ", true),
	MARK_BAD	("mark", false),
	UNMARK		("unmark ", true),
	UNMARK_BAD	("unmark", false),
	TODO		("todo ", true),
	TODO_BAD	("todo", false),
	DEADLINE	("deadline ", true),
	DEADLINE_BAD("deadline", false),
	EVENT		("event ", true),
	EVENT_BAD	("event", false),
	//
	NOMATCH		("", false);
	
	private final String str;
	private final boolean hasText;
	
	Command(String str, boolean hasText) {
		this.str = str;
		this.hasText = hasText;
	}
	
	int getLen() {
		return this.str.length();
	}
	
	boolean match(String input) {
		if (this.hasText && input.length() > getLen()) {
			return input.substring(0, getLen()).equals(this.str);
		} else {
			return input.equals(this.str);
		}
	}
	
	String getText(String input) {
		if (this.hasText) {
			return input.substring(getLen());
		}
		
		return "";
	}
	
	boolean missingText(String input) {
		return (this.hasText && getText(input).length() == 0);
	}
}