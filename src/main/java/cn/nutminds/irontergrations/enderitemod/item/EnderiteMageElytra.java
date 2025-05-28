package cn.nutminds.irontergrations.enderitemod.item;

import cn.nutminds.irontergrations.enderitemod.client.EnderiteMageElytraModel;
import cn.nutminds.irontergrations.register.IGArmorMaterials;
import cn.nutminds.irontergrations.register.IGItems;
import io.redspace.ironsspellbooks.entity.armor.GenericCustomArmorRenderer;
import io.redspace.ironsspellbooks.item.armor.ImbuableChestplateArmorItem;
import net.enderitemc.enderitemod.EnderiteMod;
import net.enderitemc.enderitemod.forge.tools.EnderiteElytraChestplate;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class EnderiteMageElytra extends ImbuableChestplateArmorItem {
    public EnderiteMageElytra(Type type, Properties settings) {
        super(IGArmorMaterials.ENDERITE_BATTLEMAGE, type, settings, withManaAndSpellPowerAttribute(125, 0.05));
    }

    public static void init() {
        ItemProperties.register((Item) IGItems.ENDERITE_MAGE_ELYTRA.get(), ResourceLocation.parse("broken"), (itemStack, clientWorld, livingEntity, id) -> {
            return EnderiteElytraChestplate.isUsable(itemStack) ? 0.0F : 1.0F;
        });
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new GenericCustomArmorRenderer<>(new EnderiteMageElytraModel());
    }

    public static boolean isUsable(ItemStack stack) {
        return stack.getDamageValue() < stack.getMaxDamage() - 10;
    }

    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == Items.PHANTOM_MEMBRANE;
    }

    public boolean canElytraFly(ItemStack stack, LivingEntity entity) {
        return true;
    }

    public boolean elytraFlightTick(ItemStack stack, LivingEntity entity, int flightTicks) {
        if (!entity.level().isClientSide() && (flightTicks + 1) % 20 == 0) {
            stack.hurtAndBreak(1, entity, EquipmentSlot.CHEST);
        }

        return isUsable(stack);
    }

}