public class BreakFast{
  public static void main(String[] args){
    Dish a=new Upma(new Shev(new Poha(new Chivda())));
    System.out.println("bill: "+a.cost()+"/-Rs");
  }
}

abstract class Dish{
  public abstract int cost();
}

abstract class Top extends Dish{
  
}

abstract class Bot extends Dish{
  
}

class Poha extends Bot{
  Dish d;
  public Poha(){
  }
  public Poha(Dish d){
    this.d= d;
  }
  public int cost(){
    if(d==null){
      return 20;
    }
    else{
      return 20+d.cost();
    }
  }
}

class Upma extends Bot{
  Dish d;
  public Upma(){
  }
  public Upma(Dish d){
    this.d= d;
  }
  public int cost(){
    if(d==null){
      return 30;
    }
    else{
      return 30+d.cost();
    }
  }
}

class Shev extends Top{
  Dish d;
  public Shev(){
  }
  public Shev(Dish d){
    this.d= d;
  }
  public int cost(){
    if(d==null){
      return 10;
    }
    else{
      return 10+d.cost();
    }
  }
}

class Chivda extends Top{
  Dish d;
  public Chivda(){
  }
  public Chivda(Dish d){
    this.d= d;
  }
  public int cost(){
    if(d==null){
      return 12;
    }
    else{
      return 12+d.cost();
    }
  }
}
