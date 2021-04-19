package domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Ingredients")
@NamedQuery(name = "domain.Ingredient.getAll", query = "SELECT i from domain.Ingredient i")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String title;
    @OneToMany(mappedBy = "ingredient", cascade = CascadeType.ALL)
    private List<RecipeIngredient> recipesIngredients;

    public Ingredient() {
    }

    public Ingredient(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public  int getId() { return id; }
}
