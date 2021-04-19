package inf.services;

import domain.Recipe;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class RecipeService {
    private EntityManager em;

    public RecipeService(EntityManager em) {
        this.em = em;
    }

    public Recipe add(Recipe recipe) {
        em.getTransaction().begin();
        Recipe recipeDB = em.merge(recipe);
        em.getTransaction().commit();
        return recipeDB;
    }

    public void refresh(Recipe recipe){
        em.refresh(recipe);
    }

    public void delete(int id) {
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public List<Recipe> getAll() {
        TypedQuery<Recipe> recipes = em.createNamedQuery("domain.Recipe.getAll", Recipe.class);
        return recipes.getResultList();
    }

    public List<String> getButtons(String filter){
        String query = "SELECT DISTINCT(c."+filter+") from domain.Recipe c";
        TypedQuery<String> cuisines = em.createQuery(query, String.class);
        return cuisines.getResultList();
    }

    public  List<Recipe> getByParameter(String parameter, String value){
        TypedQuery<Recipe> recipes= em.createQuery("SELECT c From domain.Recipe c WHERE c." + parameter + " LIKE :" + parameter , Recipe.class)
                .setParameter(parameter, value);
        return recipes.getResultList();
    }

    public Recipe get(int id) {return em.find(Recipe.class, id);
    }
}