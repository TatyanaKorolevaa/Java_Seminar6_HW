
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FinalWork {
   public static void main(String[] args) {
      Notebook notebook1 = new Notebook("Asus", "8", "1000", "Windows", "grey");
      Notebook notebook2 = new Notebook("Realme", "16", "500", "Linux", "black");
      Notebook notebook3 = new Notebook("Lenovo", "4", "500", "Windows", "red");
      Notebook notebook4 = new Notebook("Asus", "16", "1000", "Linux", "grey");
      Notebook notebook5 = new Notebook("Huawei", "8", "500", "Windows", "black");

      Set<Notebook> notebooks = new HashSet<>(List.of(notebook1, notebook2,
            notebook3, notebook4, notebook5));

      Map<String, String> sel = selectCriteria();
      sort(sel, notebooks);

   }

   public static String scanner() {
      
      Scanner scann = new Scanner(System.in);
      String scan = scann.nextLine();
      return scan;
      
      
   }

   public static Map<String, String> selectCriteria() {
      Map<String, String> resultCriterias = new HashMap<>();
      System.out.println("Введите число, обозначающее необходимый критерий: \n 1 - Бренд \n 2 - ОЗУ \n 3 - Объем ЖД \n 4 - Операционная система \n 5 - Цвет");
      String key = scanner();
      System.out.println("Введите значения для выбранного критерия: ");
      String value = scanner();
      resultCriterias.put(key, value);
      System.out.println(resultCriterias);
      return resultCriterias;
   }

   public static void sort(Map<String, String> criterias, Set<Notebook> notebooks) {

      Set<Notebook> temp = new HashSet<>(notebooks);
      for (Notebook notebook : notebooks) {

         for (Object pair : criterias.keySet()) {

            if (pair.equals("1") && !notebook.getName().equals(criterias.get(pair))) {
               temp.remove(notebook);
            }
            for (Object pair1 : criterias.keySet()) {

               if (pair1.equals("2") && !notebook.getRam().equals(criterias.get(pair1))) {
                  temp.remove(notebook);

               }
               for (Object pair2 : criterias.keySet()) {

                  if (pair2.equals("3") && !notebook.getHardDisk().equals(criterias.get(pair2))) {
                     temp.remove(notebook);

                  }
                  for (Object pair3 : criterias.keySet()) {

                     if (pair3.equals("4") && !notebook.getOperatingSystem().equals(criterias.get(pair3))) {
                        temp.remove(notebook);

                     }
                     for (Object pair4 : criterias.keySet()) {

                        if (pair4.equals("5") && !notebook.getColour().equals(criterias.get(pair4))) {
                           temp.remove(notebook);

                        }
                     }
                  }
               }
            }
         }

      }
      if (temp.isEmpty()) {
         System.out.println("Ничего не найдено!");
      } else {
         System.out.println("Результат поиска: \n" + temp.toString());
      }

   }

}