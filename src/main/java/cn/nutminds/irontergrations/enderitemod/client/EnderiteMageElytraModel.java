package cn.nutminds.irontergrations.enderitemod.client;

import cn.nutminds.irontergrations.Irontergrations;
import cn.nutminds.irontergrations.enderitemod.item.EnderiteMageArmorItem;
import cn.nutminds.irontergrations.enderitemod.item.EnderiteMageElytra;
import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class EnderiteMageElytraModel extends DefaultedItemGeoModel<EnderiteMageElytra> {

    public EnderiteMageElytraModel() {
        super(ResourceLocation.fromNamespaceAndPath(Irontergrations.MODID, ""));
    }

    @Override
    public ResourceLocation getModelResource(EnderiteMageElytra object) {
        return ResourceLocation.fromNamespaceAndPath(Irontergrations.MODID, "geo/enderite_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EnderiteMageElytra object) {
        return ResourceLocation.fromNamespaceAndPath(Irontergrations.MODID, "textures/models/armor/enderite.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EnderiteMageElytra animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}