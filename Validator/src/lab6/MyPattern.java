package lab6;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyPattern {
	String regex();
	String message();
}
