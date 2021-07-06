package hit.week6;

public class GenericsDemo {
	public static void main(String[] args) {
		
		GoodPaintBrush<Paint> brush=new GoodPaintBrush<>();
		brush.setObj(new BluePaint());
		Paint mypaint=brush.getObj();
		mypaint.color();
		
		GoodPaintBrush<Powder> brush2= new GoodPaintBrush<>();
		brush2.setObj(new RosePowder());
		Powder mypowder=brush2.getObj();
		mypowder.doMakeup();
		
		GoodPaintBrush<ToothBrush> brush3= new GoodPaintBrush<>();
		brush3.setObj(new Colgate());
		ToothBrush tbrush=brush3.getObj();
		tbrush.ApplyPaste();
	}
}
abstract class Paint{
	public abstract void color();
}
class RedPaint extends Paint{
	@Override
	public void color() {
		System.out.println("red colour...");
	}
}
class BluePaint extends Paint{
	@Override
	public void color() {
		System.out.println("blue colour...");
	}
}

abstract class Powder{
	public abstract void doMakeup();
}
class WhitePowder extends Powder{
	@Override
	public void doMakeup() {
		System.out.println("applying powder....");
	}
}
class RosePowder extends Powder{
	@Override
	public void doMakeup() {
		System.out.println("rose powder applied..");
	}
}

abstract class ToothBrush{
	public abstract void ApplyPaste();
}
class Colgate extends ToothBrush{
	@Override
	public void ApplyPaste() {
		System.out.println("colgate is applied.....");
	}
}
class Dantkanti extends ToothBrush{
	@Override
	public void ApplyPaste() {
		System.out.println("dantkanti is applied.....");	
	}
}

class GoodPaintBrush<T>{
	T obj;
	public void setObj(T obj) {
		this.obj=obj;
	}
	public T getObj() {
		return obj;
	}
}
