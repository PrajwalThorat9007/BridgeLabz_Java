package generics;

/*
4. Personalized Meal Plan Generator
Concepts: Generic Methods, Type Parameters, Bounded Type Parameters

Problem Statement:
Design a Personalized Meal Plan Generator where users can choose
different meal categories like Vegetarian, Vegan, Keto, or High-Protein.
The system should ensure only valid meal plans are generated.
*/

interface MealPlan {
    String getPlanType();
}

/* ---- Meal Types ---- */

class VegetarianMeal implements MealPlan {
    public String getPlanType() {
        return "Vegetarian Meal Plan";
    }
}

class VeganMeal implements MealPlan {
    public String getPlanType() {
        return "Vegan Meal Plan";
    }
}

class KetoMeal implements MealPlan {
    public String getPlanType() {
        return "Keto Meal Plan";
    }
}

class HighProteinMeal implements MealPlan {
    public String getPlanType() {
        return "High Protein Meal Plan";
    }
}

/* ---- Generic Meal Class ---- */

class Meal<T extends MealPlan> {

    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public void displayMeal() {
        System.out.println("Generated: " + mealPlan.getPlanType());
    }
}

/* ---- Generic Method for Validation & Generation ---- */

class MealGenerator {

    public static <T extends MealPlan> Meal<T> generateMeal(T plan) {

        // Simple validation (ensures not null)
        if (plan == null) {
            throw new IllegalArgumentException("Invalid Meal Plan");
        }

        return new Meal<>(plan);
    }
}

/* ---- Main Class ---- */

public class MealPlanner {

    public static void main(String[] args) {

        Meal<VegetarianMeal> vegMeal =
                MealGenerator.generateMeal(new VegetarianMeal());

        Meal<KetoMeal> ketoMeal =
                MealGenerator.generateMeal(new KetoMeal());

        vegMeal.displayMeal();
        ketoMeal.displayMeal(); 
    }
}
