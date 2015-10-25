package tmv_anonymous_class_package;

public class GoodMood implements BrainState {
	
//BrainState brainState = Dog2.this.new BadMood();		
	
private static final int MAX_STROKES = 3;
int count;

@Override
public void feed() {
//	Dog2.this.eat();
//	Dog2.this.wag();
	Dog2.eat();
	Dog2.wag();
}

@Override
public void stroke() {
//	Dog2.this.wag(); Dog2.this.bark();
	Dog2.wag(); Dog2.bark();
	
	count++;
	if (count >= MAX_STROKES) {
//		Dog2.this.brainState = new Dog2.this.BadMood();
		Dog2.brainState = new BadMood();
	}
}
}
