package lab6;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class MyPatternValidator implements ValidatorInterface{
	
	private boolean valid;
	
	@Override
	public void validate(String value) {
		try {
			Class MyClass = Class.forName("lab6.PatternClass");
			Field pole = MyClass.getDeclaredField("MyValidatedField");
			Annotation adnotacja = pole.getAnnotation(MyPattern.class);
			if(adnotacja instanceof MyPattern){
				MyPattern pattern = (MyPattern) adnotacja;
				
				if(value.equals(pattern.regex())){
					valid=true;
				}else {
					valid=false;
				}
			}else {
				valid = false;
			}
		} catch (ClassNotFoundException | NoSuchFieldException | SecurityException e) {
			System.out.println(e.toString());
			valid = false;
		}
	}

	@Override
	public boolean isValid() {
		if(valid) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public String getMessage() {
		try {
			Class MyClass = Class.forName("lab6.PatternClass");
			Field pole = MyClass.getDeclaredField("MyValidatedField");
			Annotation adnotacja = pole.getAnnotation(MyPattern.class);
			if(adnotacja instanceof MyPattern){
				MyPattern pattern = (MyPattern) adnotacja;
				return pattern.message();
			}else {
				return null;
			}
		} catch (ClassNotFoundException | NoSuchFieldException | SecurityException e) {
			System.out.println(e.toString());
			return null;
		}
		
	}

}
