package domain;

import domain.Ingredient;

import javax.persistence.*;

@Entity
@Table(name = "RecipesIngredients")
@IdClass(RecipeIngredientId.class)
public class RecipeIngredient {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipeId")
    private Recipe recipe;
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredientId")
    private Ingredient ingredient;
    private String amount;

    public RecipeIngredient() {
    }

    public RecipeIngredient(Recipe recipe, Ingredient ingredient, String amount) {
        this.recipe = recipe;
        this.ingredient = ingredient;
        this.amount = amount;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public String getAmount() {
        return amount;
    }
}