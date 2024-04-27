package collectors.model;

import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class Dish {
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return name;
    }

    public enum Type {MEAT, FISH, OTHER}

    public static void main(String[] args) {

        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("muscle", false, 800, Dish.Type.FISH),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));

        List<String> threeHighCaloricDishNames =
                menu.stream()
                        .filter(dish -> dish.getCalories() > 300)
                        .sorted(comparing(Dish::getCalories))
                        .map(Dish::getName)
                        .limit(3)
                        .collect(toList());
        System.out.println(threeHighCaloricDishNames);

        List<Dish> filteredMenu
                = specialMenu.stream()
                .filter(dish -> dish.getCalories() < 800)
                .collect(toList());
        System.out.println("filteredMenu:" + threeHighCaloricDishNames);

        List<Dish> slicedMenu1
                = specialMenu.stream()
                .takeWhile(dish -> dish.getCalories() < 800)
                .collect(toList());

        System.out.println("slicedMenu1:" + slicedMenu1);

        List<Dish> sortedSlicedMenu1
                = specialMenu.stream()
                .sorted(comparing(Dish::getCalories))
                .takeWhile(dish -> dish.getCalories() < 800)
                .collect(toList());

        System.out.println("sortedSlicedMenu1:" + sortedSlicedMenu1);


    }
}