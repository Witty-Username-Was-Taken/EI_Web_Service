package edu.uga.cs.ei.finalwebservice;

public class Test {

    public static void main(String[] args) {
        FoodService f = new FoodService();
        f.getMainCourses();
        IngredientService i = new IngredientService();
        System.out.println("==============================================");
        i.getFoodUsedIn("Biryani");
    }
}
