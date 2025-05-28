package cn.nutminds.irontergrations.register;

import cn.nutminds.irontergrations.CompatChecker;
import cn.nutminds.irontergrations.Irontergrations;
import io.redspace.ironsspellbooks.registries.CreativeTabRegistry;
import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class IGCreativeTabs {
    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }
    private static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Irontergrations.MODID);
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> IRONTERGRATIONS_TAB = TABS.register(
            "irontergrations_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + Irontergrations.MODID + ".irontergrations_tab"))
            .icon(() -> new ItemStack(ItemRegistry.DIAMOND_SPELL_BOOK.get()))
            .displayItems((enabledFeatures, entries) -> {
                entries.accept(IGItems.LARGE_UPGRADE_ORB.get());
                entries.accept(IGItems.LARGE_FIRE_UPGRADE_ORB.get());
                entries.accept(IGItems.LARGE_ICE_UPGRADE_ORB.get());
                entries.accept(IGItems.LARGE_LIGHTNING_UPGRADE_ORB.get());
                entries.accept(IGItems.LARGE_HOLY_UPGRADE_ORB.get());
                entries.accept(IGItems.LARGE_ENDER_UPGRADE_ORB.get());
                entries.accept(IGItems.LARGE_BLOOD_UPGRADE_ORB.get());
                entries.accept(IGItems.LARGE_EVOCATION_UPGRADE_ORB.get());
                entries.accept(IGItems.LARGE_NATURE_UPGRADE_ORB.get());
                if (CompatChecker.isIllagerInvasionLoaded()){
                entries.accept(IGItems.HALLOWED_STAFF.get());
                entries.accept(IGItems.INVOKER_SPELL_BOOK.get());
                entries.accept(IGItems.ARCHIVIST_SPELL_BOOK.get());
                entries.accept(IGItems.NECROMANCY_RING.get());
                }
                if (CompatChecker.isEnderiteModLoaded()){
                    entries.accept(IGItems.ENDERITE_MAGE_HELMET.get());
                    entries.accept(IGItems.ENDERITE_MAGE_CHESTPLATE.get());
                    entries.accept(IGItems.ENDERITE_MAGE_LEGGINGS.get());
                    entries.accept(IGItems.ENDERITE_MAGE_BOOTS.get());
                    entries.accept(IGItems.ENDERITE_MAGE_ELYTRA.get());
                }
            })
            .withTabsBefore(CreativeTabRegistry.EQUIPMENT_TAB.getKey())
            .build());
}
