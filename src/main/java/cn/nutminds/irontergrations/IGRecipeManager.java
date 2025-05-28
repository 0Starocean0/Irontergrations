package cn.nutminds.irontergrations;

import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.Optional;

public class IGRecipeManager extends RecipeManager {
    public IGRecipeManager(HolderLookup.Provider registries) {
        super(registries);
    }

}
