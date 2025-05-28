package cn.nutminds.irontergrations.enderitemod.item;

import cn.nutminds.irontergrations.enderitemod.client.EnderiteMageArmorModel;
import cn.nutminds.irontergrations.register.IGArmorMaterials;
import io.redspace.ironsspellbooks.entity.armor.GenericCustomArmorRenderer;
import io.redspace.ironsspellbooks.item.armor.ImbuableChestplateArmorItem;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class EnderiteMageArmorItem extends ImbuableChestplateArmorItem {
    public EnderiteMageArmorItem(Type type, Properties settings) {
        super(IGArmorMaterials.ENDERITE_BATTLEMAGE, type, settings, withManaAndSpellPowerAttribute(125, 0.05));
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new GenericCustomArmorRenderer<>(new EnderiteMageArmorModel());
    }

}