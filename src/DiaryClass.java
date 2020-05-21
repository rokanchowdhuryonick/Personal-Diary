import java.io.Serializable;
import java.time.*;
import java.time.format.*;

public class DiaryClass implements Serializable{
	private String title, text;
	private String now;
	
	public DiaryClass(String title, String text, String now) {
		this.title = title;
		this.text = text;
		this.now = now;
	}
	public DiaryClass(String title, String text) {
		this.title = title;
		this.text = text;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		this.now = dtf.format(LocalDateTime.now());
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getNow() {
		return now;
	}

	@Override
	public String toString() {
		return "[Title: " + title + ", Text: " + text + ", Time:" + now + "]";
	} 
	

}
