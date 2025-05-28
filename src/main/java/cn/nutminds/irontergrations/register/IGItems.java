package cn.nutminds.irontergrations.register;

import cn.nutminds.irontergrations.Irontergrations;
import cn.nutminds.irontergrations.enderitemod.item.EnderiteMageArmorItem;
import cn.nutminds.irontergrations.enderitemod.item.EnderiteMageElytra;
import cn.nutminds.irontergrations.illagerinvasions.item.NecromancyRing;
import cn.nutminds.irontergrations.item.*;
import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.registry.*;
import io.redspace.ironsspellbooks.item.*;
import io.redspace.ironsspellbooks.item.curios.CurioBaseItem;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import io.redspace.ironsspellbooks.item.weapons.StaffItem;
import io.redspace.ironsspellbooks.registries.ComponentRegistry;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Collection;
import java.util.function.Supplier;

import static cn.nutminds.irontergrations.CompatChecker.*;
import static cn.nutminds.irontergrations.register.IGArmorMaterials.ENDERITE_BATTLEMAGE;
import static net.enderitemc.enderitemod.EnderiteMod.CONFIG;

public class IGItems {
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Irontergrations.MODID);

    //I know this is a stupid way to fix :(
    public static final DeferredHolder<Item, Item> PLACEHOLDER_SPELL_BOOK = ITEMS.register(
            "placeholder_spell_book", () -> new SpellBook(0));
    public static final DeferredHolder<Item, Item> PLACEHOLDER_STAFF = ITEMS.register(
            "placeholder_staff", () -> new StaffItem(ItemPropertiesHelper.equipment(1)));

    public static final DeferredHolder<Item, Item> LARGE_UPGRADE_ORB = ITEMS.register(
            "large_upgrade_orb", () -> new Item(
                    ItemPropertiesHelper.material().rarity(Rarity.UNCOMMON)));
    public static final DeferredHolder<Item, Item> LARGE_FIRE_UPGRADE_ORB = ITEMS.register(
            "large_fire_upgrade_orb", () -> new UpgradeOrbItem(
                    ItemPropertiesHelper.material()
                            .rarity(Rarity.UNCOMMON)
                            .component(ComponentRegistry.UPGRADE_ORB_TYPE, IGUpgradeOrbTypes.ADVANCED_FIRE_SPELL_POWER)));
    public static final DeferredHolder<Item, Item> LARGE_ICE_UPGRADE_ORB = ITEMS.register(
            "large_ice_upgrade_orb", () -> new UpgradeOrbItem(
                    ItemPropertiesHelper.material()
                            .rarity(Rarity.UNCOMMON)
                            .component(ComponentRegistry.UPGRADE_ORB_TYPE, IGUpgradeOrbTypes.ADVANCED_ICE_SPELL_POWER)));
    public static final DeferredHolder<Item, Item> LARGE_LIGHTNING_UPGRADE_ORB = ITEMS.register(
            "large_lightning_upgrade_orb", () -> new UpgradeOrbItem(
                    ItemPropertiesHelper.material()
                            .rarity(Rarity.UNCOMMON)
                            .component(ComponentRegistry.UPGRADE_ORB_TYPE, IGUpgradeOrbTypes.ADVANCED_LIGHTNING_SPELL_POWER)));
    public static final DeferredHolder<Item, Item> LARGE_HOLY_UPGRADE_ORB = ITEMS.register(
            "large_holy_upgrade_orb", () -> new UpgradeOrbItem(
                    ItemPropertiesHelper.material()
                            .rarity(Rarity.UNCOMMON)
                            .component(ComponentRegistry.UPGRADE_ORB_TYPE, IGUpgradeOrbTypes.ADVANCED_HOLY_SPELL_POWER)));
    public static final DeferredHolder<Item, Item> LARGE_ENDER_UPGRADE_ORB = ITEMS.register(
            "large_ender_upgrade_orb", () -> new UpgradeOrbItem(
                    ItemPropertiesHelper.material()
                            .rarity(Rarity.UNCOMMON)
                            .component(ComponentRegistry.UPGRADE_ORB_TYPE, IGUpgradeOrbTypes.ADVANCED_ENDER_SPELL_POWER)));
    public static final DeferredHolder<Item, Item> LARGE_BLOOD_UPGRADE_ORB = ITEMS.register(
            "large_blood_upgrade_orb", () -> new UpgradeOrbItem(
                    ItemPropertiesHelper.material()
                            .rarity(Rarity.UNCOMMON)
                            .component(ComponentRegistry.UPGRADE_ORB_TYPE, IGUpgradeOrbTypes.ADVANCED_BLOOD_SPELL_POWER)));
    public static final DeferredHolder<Item, Item> LARGE_EVOCATION_UPGRADE_ORB = ITEMS.register(
            "large_evocation_upgrade_orb", () -> new UpgradeOrbItem(
                    ItemPropertiesHelper.material()
                            .rarity(Rarity.UNCOMMON)
                            .component(ComponentRegistry.UPGRADE_ORB_TYPE, IGUpgradeOrbTypes.ADVANCED_EVOCATION_SPELL_POWER)));
    public static final DeferredHolder<Item, Item> LARGE_NATURE_UPGRADE_ORB = ITEMS.register(
            "large_nature_upgrade_orb", () -> new UpgradeOrbItem(
                    ItemPropertiesHelper.material()
                            .rarity(Rarity.UNCOMMON)
                            .component(ComponentRegistry.UPGRADE_ORB_TYPE, IGUpgradeOrbTypes.ADVANCED_NATURE_SPELL_POWER)));
    //Large Orbs for other mods
    public static final DeferredHolder<Item, Item> LARGE_ABYSSAL_UPGRADE_ORB;
    public static final DeferredHolder<Item, Item> LARGE_ELDRITCH_UPGRADE_ORB;
    public static final DeferredHolder<Item, Item> LARGE_WIND_UPGRADE_ORB;
    public static final DeferredHolder<Item, Item> LARGE_SYMMETRY_UPGRADE_ORB;
    public static final DeferredHolder<Item, Item> LARGE_AQUA_UPGRADE_ORB;
    static {
        if (isCATSLoaded()) {
            LARGE_ABYSSAL_UPGRADE_ORB = ITEMS.register(
                    "large_abyssal_upgrade_orb", () -> new UpgradeOrbItem(
                            ItemPropertiesHelper.material()
                                    .rarity(Rarity.UNCOMMON)
                                    .component(ComponentRegistry.UPGRADE_ORB_TYPE, IGUpgradeOrbTypes.ADVANCED_ABYSSAL_SPELL_POWER)));
        } else {
            LARGE_ABYSSAL_UPGRADE_ORB = null;
        }} static {
        if (isDTELoaded()) {
            LARGE_ELDRITCH_UPGRADE_ORB = ITEMS.register(
                    "large_eldritch_upgrade_orb", () -> new UpgradeOrbItem(
                            ItemPropertiesHelper.material()
                                    .rarity(Rarity.UNCOMMON)
                                    .component(ComponentRegistry.UPGRADE_ORB_TYPE, IGUpgradeOrbTypes.ADVANCED_ELDRITCH_SPELL_POWER)));
        } else {
            LARGE_ELDRITCH_UPGRADE_ORB = null;
        }} static {
        if (isAeromancyLoaded()) {
            LARGE_WIND_UPGRADE_ORB = ITEMS.register(
                    "large_eldritch_upgrade_orb", () -> new UpgradeOrbItem(
                            ItemPropertiesHelper.material()
                                    .rarity(Rarity.UNCOMMON)
                                    .component(ComponentRegistry.UPGRADE_ORB_TYPE, IGUpgradeOrbTypes.ADVANCED_WIND_SPELL_POWER)));
        } else {
            LARGE_WIND_UPGRADE_ORB = null;
        }} static {
        if (isMFTELoaded()) {
            LARGE_SYMMETRY_UPGRADE_ORB = ITEMS.register(
                    "large_symmetry_upgrade_orb", () -> new UpgradeOrbItem(
                            ItemPropertiesHelper.material()
                                    .rarity(Rarity.UNCOMMON)
                                    .component(ComponentRegistry.UPGRADE_ORB_TYPE, IGUpgradeOrbTypes.ADVANCED_SYMMETRY_SPELL_POWER)));
        } else {
            LARGE_SYMMETRY_UPGRADE_ORB = null;
        }} static {
        if (isTOExtrasLoaded()) {
            LARGE_AQUA_UPGRADE_ORB = ITEMS.register(
                    "large_aqua_upgrade_orb", () -> new UpgradeOrbItem(
                            ItemPropertiesHelper.material()
                                    .rarity(Rarity.UNCOMMON)
                                    .component(ComponentRegistry.UPGRADE_ORB_TYPE, IGUpgradeOrbTypes.ADVANCED_AQUA_SPELL_POWER)));
        } else {
            LARGE_AQUA_UPGRADE_ORB = null;
        }}
    //Illager Invasion
    public static final DeferredHolder<Item, Item> HALLOWED_STAFF;
    public static final DeferredHolder<Item, Item> INVOKER_SPELL_BOOK;
    public static final DeferredHolder<Item, Item> ARCHIVIST_SPELL_BOOK;
    public static final Supplier<CurioBaseItem> NECROMANCY_RING;
    static {
        if (isIllagerInvasionLoaded()) {
            HALLOWED_STAFF = ITEMS.register(
                    "hallowed_staff",
                    () -> new StaffItem(
                            ItemPropertiesHelper.equipment(1)
                                    .attributes(ExtendedSwordItem
                                            .createAttributes(IGStaffTier.DIVINE))));
            INVOKER_SPELL_BOOK = ITEMS.register(
                    "invoker_spell_book", () -> new UniqueSpellBook(
                            new SpellDataRegistryHolder[]{
                                    new SpellDataRegistryHolder(SpellRegistry.FANG_STRIKE_SPELL, 8),
                                    new SpellDataRegistryHolder(SpellRegistry.FANG_WARD_SPELL, 5),
                                    new SpellDataRegistryHolder(SpellRegistry.SUMMON_VEX_SPELL, 4)},
                            8)
                            .withSpellbookAttributes(
                                    new AttributeContainer(
                                            AttributeRegistry.EVOCATION_SPELL_POWER,
                                            .15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                                    new AttributeContainer(AttributeRegistry.MAX_MANA,
                                            220, AttributeModifier.Operation.ADD_VALUE)));
            ARCHIVIST_SPELL_BOOK = ITEMS.register(
                    "archivist_spell_book", () -> new SpellBook(16)
                            .withSpellbookAttributes(
                                    new AttributeContainer(
                                            AttributeRegistry.CAST_TIME_REDUCTION,
                                            -0.25, AttributeModifier.Operation.ADD_VALUE)));
            NECROMANCY_RING = ITEMS.register("necromancy_ring", NecromancyRing::new);
        } else {
            HALLOWED_STAFF = null;
            INVOKER_SPELL_BOOK = null;
            ARCHIVIST_SPELL_BOOK = null;
            NECROMANCY_RING = null;
        }
    }
    //Enderite Mod
    public static final DeferredHolder<Item, Item> ENDERITE_MAGE_HELMET;
    public static final DeferredHolder<Item, Item> ENDERITE_MAGE_CHESTPLATE;
    public static final DeferredHolder<Item, Item> ENDERITE_MAGE_LEGGINGS;
    public static final DeferredHolder<Item, Item> ENDERITE_MAGE_BOOTS;
    public static final DeferredHolder<Item, Item> ENDERITE_MAGE_ELYTRA;
    static {
        if (isEnderiteModLoaded()) {
            ENDERITE_MAGE_HELMET = ITEMS.register("enderite_mage_helmet", () -> new EnderiteMageArmorItem(
                    ArmorItem.Type.HELMET,
                    ItemPropertiesHelper
                            .equipment(1)
                            .fireResistant()
                            .durability(ArmorItem.Type.LEGGINGS.getDurability(CONFIG.armor.durabilityMultiplier))));
            ENDERITE_MAGE_CHESTPLATE = ITEMS.register("enderite_mage_chestplate", () -> new EnderiteMageArmorItem(
                    ArmorItem.Type.CHESTPLATE,
                    ItemPropertiesHelper
                            .equipment(1)
                            .fireResistant()
                            .durability(ArmorItem.Type.LEGGINGS.getDurability(CONFIG.armor.durabilityMultiplier))));
            ENDERITE_MAGE_LEGGINGS = ITEMS.register("enderite_mage_leggings", () -> new EnderiteMageArmorItem(
                    ArmorItem.Type.LEGGINGS,
                    ItemPropertiesHelper
                            .equipment(1)
                            .fireResistant()
                            .durability(ArmorItem.Type.LEGGINGS.getDurability(CONFIG.armor.durabilityMultiplier))));
            ENDERITE_MAGE_BOOTS = ITEMS.register("enderite_mage_boots", () -> new EnderiteMageArmorItem(
                    ArmorItem.Type.BOOTS,
                    ItemPropertiesHelper
                            .equipment(1)
                            .fireResistant()
                            .durability(ArmorItem.Type.LEGGINGS.getDurability(CONFIG.armor.durabilityMultiplier))));
            ENDERITE_MAGE_ELYTRA = ITEMS.register("enderite_mage_elytra", () -> new EnderiteMageElytra(
                    ArmorItem.Type.CHESTPLATE,
                    ItemPropertiesHelper
                            .equipment(1)
                            .fireResistant()
                            .durability(1024)
                            .rarity(Rarity.EPIC)));
            }
        else {
            ENDERITE_MAGE_HELMET = null;
            ENDERITE_MAGE_CHESTPLATE = null;
            ENDERITE_MAGE_LEGGINGS = null;
            ENDERITE_MAGE_BOOTS = null;
            ENDERITE_MAGE_ELYTRA = null;
        }
    }

    public static Collection<DeferredHolder<Item, ? extends Item>> getIGItems()
    {
        return ITEMS.getEntries();
    }
}