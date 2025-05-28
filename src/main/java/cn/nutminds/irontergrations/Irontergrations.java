package cn.nutminds.irontergrations;

import cn.nutminds.irontergrations.register.*;
import com.mojang.logging.LogUtils;
import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

@Mod(Irontergrations.MODID)
public class Irontergrations {
    public static final String MODID = "irontergrations";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Irontergrations(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::onCommonSetup);
        IGItems.register(modEventBus);
        IGCreativeTabs.register(modEventBus);
        IGEntities.register(modEventBus);
        IGArmorMaterials.register(modEventBus);
    }

    public static ResourceLocation id(@NotNull String path) {
        return ResourceLocation.fromNamespaceAndPath(Irontergrations.MODID, path);
    }

    @SubscribeEvent
    public void onCommonSetup(FMLCommonSetupEvent event) {
    }
}