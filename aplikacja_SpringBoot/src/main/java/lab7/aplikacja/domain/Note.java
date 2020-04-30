package lab7.aplikacja.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Note {
	
	@Id
	@GeneratedValue
	@Column
	private long id;
	@Column
    private String importance;
	@Column
    private String text;
	@Column
	@GeneratedValue
    private String timestamp;
     
    public long getId() {
    	return id;
    }
    public void setId(long id) {
    	this.id = id;
    }
    public String getImportance() {
        return importance;
    }
 
    public void setImportance(String importance) {
        this.importance = importance;
    }
 
    public String getText() {
        return text;
    }
 
    public void setText(String text) {
        this.text = text;
    }
    public String getTimestamp() {
    	return timestamp;
    }
    public void setTimestamp(String timestamp) {
    	this.timestamp = timestamp;
    }
}
