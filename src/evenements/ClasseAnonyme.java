package evenements;


import java.util.function.Function;

public class ClasseAnonyme {

  public static void main(String[] args) {
    // Classe anonyme = définition d'une sous-classe + instanciation.
    Function<Double, Double> cos = new Function<Double, Double>() {
      @Override
      public Double apply(Double t) {
        return Math.cos(t);
      }
    };
    Function<Double, Double> sin = new Function<Double, Double>() {
      @Override
      public Double apply(Double t) {
        return Math.sin(t);
      }
    };

    executeAndPrint(cos, Math.PI / 3);
    executeAndPrint(sin, Math.PI / 3);
  }

  private static void executeAndPrint(Function<Double, Double> f, double x) {
    System.out.println(f.apply(x));
  }

}
