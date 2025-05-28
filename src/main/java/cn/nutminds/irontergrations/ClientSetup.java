package cn.nutminds.irontergrations;

import cn.nutminds.irontergrations.register.IGItems;
import fuzs.illagerinvasion.client.model.InvokerFangsModel;
import io.redspace.ironsspellbooks.entity.spells.ExtendedEvokerFang;
import io.redspace.ironsspellbooks.item.SpellBook;
import io.redspace.ironsspellbooks.item.weapons.StaffItem;
import io.redspace.ironsspellbooks.registries.EntityRegistry;
import io.redspace.ironsspellbooks.render.ClientStaffItemExtensions;
import io.redspace.ironsspellbooks.render.SpellBookCurioRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.EvokerFangsRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.ModelEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

import static cn.nutminds.irontergrations.CompatChecker.isIllagerInvasionLoaded;

@EventBusSubscriber(modid = Irontergrations.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {
    @SubscribeEvent
    public static void registerClientExtensions(RegisterClientExtensionsEvent event) {
        event.registerItem(new ClientStaffItemExtensions(),
                IGItems.getIGItems()
                        .stream()
                        .filter(item -> item.get()
                                instanceof StaffItem staffItem && !staffItem.hasCustomRendering())
                        .map(holder -> (Item) holder.get())
                        .toArray(Item[]::new));
    }
    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent e) {
        e.enqueueWork(() -> {
            IGItems.getIGItems()
                    .stream()
                    .filter(item -> item.get() instanceof SpellBook)
                    .forEach((item) -> CuriosRendererRegistry.register(item.get(), SpellBookCurioRenderer::new));
        });
    }
}
