package cn.nutminds.irontergrations.enderitemod.client;

import cn.nutminds.irontergrations.Irontergrations;
import cn.nutminds.irontergrations.enderitemod.item.EnderiteMageArmorItem;
import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class EnderiteMageArmorModel extends DefaultedItemGeoModel<EnderiteMageArmorItem> {

    public EnderiteMageArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(Irontergrations.MODID, ""));
    }

    @Override
    public ResourceLocation getModelResource(EnderiteMageArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath(Irontergrations.MODID, "geo/enderite_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EnderiteMageArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath(Irontergrations.MODID, "textures/models/armor/enderite.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EnderiteMageArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}