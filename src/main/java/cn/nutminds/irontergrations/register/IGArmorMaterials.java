package cn.nutminds.irontergrations.register;

import cn.nutminds.irontergrations.Irontergrations;
import net.enderitemc.enderitemod.EnderiteMod;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

import static cn.nutminds.irontergrations.CompatChecker.isEnderiteModLoaded;
import static io.redspace.ironsspellbooks.registries.ArmorMaterialRegistry.makeArmorMap;

public class IGArmorMaterials {
    private static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister.create(Registries.ARMOR_MATERIAL, Irontergrations.MODID);

    public static final TagKey<Item> INGOTS_ENDERITE =
            ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "ingots/enderite"));

    public static void register(IEventBus eventBus) {
        ARMOR_MATERIALS.register(eventBus);
    }

    public static DeferredHolder<ArmorMaterial, ArmorMaterial> ENDERITE_BATTLEMAGE;
    static {
        if (isEnderiteModLoaded()) {
            ENDERITE_BATTLEMAGE = register("enderite_battlemage",
                    makeArmorMap(
                            EnderiteMod.CONFIG.armor.helmetProtection,
                            EnderiteMod.CONFIG.armor.chestplateProtection,
                            EnderiteMod.CONFIG.armor.leggingsProtection,
                            EnderiteMod.CONFIG.armor.bootsProtection),
                    EnderiteMod.CONFIG.armor.enchantability,
                    SoundEvents.ARMOR_EQUIP_NETHERITE,
                    () -> Ingredient.of(INGOTS_ENDERITE),
                    EnderiteMod.CONFIG.armor.toughness,
                    EnderiteMod.CONFIG.armor.knockbackResistance);
        }
        else {
            ENDERITE_BATTLEMAGE = null;
        }
    }

    private static DeferredHolder<ArmorMaterial, ArmorMaterial> register(
            String name,
            EnumMap<ArmorItem.Type, Integer> defense,
            int enchantmentValue,
            Holder<SoundEvent> equipSound,
            Supplier<Ingredient> repairIngredient,
            float toughness,
            float knockbackResistance
    ) {
        List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(Irontergrations.id(name)));
        return ARMOR_MATERIALS.register(name, ()-> new ArmorMaterial(defense, enchantmentValue, equipSound, repairIngredient, list, toughness, knockbackResistance));
    }
}
