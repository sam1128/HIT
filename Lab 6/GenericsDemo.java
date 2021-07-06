package hit.week6;

public class GenericsDemo {
	public static void main(String[] args) {
//		Paint paint=new RedPaint();
//		
//		Powder powder=new RosePowder();
//		
		//GoodPaintBrush brush=new GoodPaintBrush();
		//brush.obj=powder;		
		//brush.execute();
		
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

//class BadPaintBrush3{// I have made my paintbrush generic
//	Object obj; // by declaring a object reference u can consume any object
//	public void execute() {
//		if(obj instanceof Paint) {
//			Paint paint=(Paint)obj;
//			paint.color();
//		}
//		if(obj instanceof Powder) {
//			Powder makeup=(Powder)obj;
//			makeup.doMakeup();
//		}
//	}
//}
//
//class BadPaintBrush2{// this paintbrush was specific
//	Paint paint; // by declaring a specific type, you can consume only an object of that type - because java is a strongly typed language...
//	public void doPaint() {
//		System.out.println(paint);
//	}
//}
//
//class BadPaintBrush{
//	public void doPaint(int i) {
//		if(i==1) {
//			RedPaint rp=new RedPaint();
//			System.out.println("red paint...."+rp);
//		}
//		else if(i==2) {
//			BluePaint bp=new BluePaint();
//			System.out.println("blue paint...:"+bp);
//		}
//	}
//}
