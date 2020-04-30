
package lab7.aplikacja.domain;

public enum ImportanceEnum {
	URGENT("URGENT"),
	STANDARD("STANDARD"), 
	OPTIONAL("OPTIONAL");

    private final String displayName;

    private ImportanceEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

