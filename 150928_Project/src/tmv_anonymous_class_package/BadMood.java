package tmv_anonymous_class_package;

public class BadMood implements BrainState {

	@Override
	public void feed() {
//		Dog2.this.eat();
//		Dog2.this.brainState = Dog2.this.new GoodMood();
		Dog2.eat();
		Dog2.brainState = new GoodMood();
	}

	@Override
	public void stroke() {
//		Dog2.this.bite();
		Dog2.bite();
	}
	
}
