package com.blamejared.crafttweaker.api.action.recipe;

import com.blamejared.crafttweaker.api.ingredient.IIngredient;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import com.blamejared.crafttweaker.platform.Services;
import net.minecraft.world.item.crafting.Recipe;
import org.apache.logging.log4j.Logger;

public class ActionRemoveRecipeByOutput<T extends Recipe<?>> extends ActionRemoveRecipe<T> {
    
    private final IIngredient output;
    
    public ActionRemoveRecipeByOutput(IRecipeManager<T> manager, IIngredient output) {
        
        super(manager,
                recipe -> output.matches(Services.PLATFORM.createMCItemStackMutable(recipe.getResultItem())));
        this.output = output;
        describeDefaultRemoval(output);
    }
    
    @Override
    public boolean validate(Logger logger) {
        
        if(output == null) {
            logger.warn("Output cannot be null!", new IllegalArgumentException("output IItemStack cannot be null!"));
            return false;
        }
        return true;
    }
    
}
