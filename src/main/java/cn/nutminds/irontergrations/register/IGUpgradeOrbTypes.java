package cn.nutminds.irontergrations.register;

import cn.nutminds.irontergrations.Irontergrations;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.armor.UpgradeOrbType;
import io.redspace.ironsspellbooks.registries.UpgradeOrbTypeRegistry;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

import static cn.nutminds.irontergrations.CompatChecker.*;

public class IGUpgradeOrbTypes extends UpgradeOrbTypeRegistry {

    public static ResourceKey<UpgradeOrbType> ADVANCED_FIRE_SPELL_POWER = ResourceKey.create(
            UPGRADE_ORB_REGISTRY_KEY,
            Irontergrations.id("advanced_fire_power"));
    public static ResourceKey<UpgradeOrbType> ADVANCED_ICE_SPELL_POWER = ResourceKey.create(
            UPGRADE_ORB_REGISTRY_KEY,
            Irontergrations.id("advanced_ice_power"));
    public static ResourceKey<UpgradeOrbType> ADVANCED_LIGHTNING_SPELL_POWER = ResourceKey.create(
            UPGRADE_ORB_REGISTRY_KEY,
            Irontergrations.id("advanced_lightning_power"));
    public static ResourceKey<UpgradeOrbType> ADVANCED_HOLY_SPELL_POWER = ResourceKey.create(
            UPGRADE_ORB_REGISTRY_KEY,
            Irontergrations.id("advanced_holy_power"));
    public static ResourceKey<UpgradeOrbType> ADVANCED_ENDER_SPELL_POWER = ResourceKey.create(
            UPGRADE_ORB_REGISTRY_KEY,
            Irontergrations.id("advanced_ender_power"));
    public static ResourceKey<UpgradeOrbType> ADVANCED_BLOOD_SPELL_POWER = ResourceKey.create(
            UPGRADE_ORB_REGISTRY_KEY,
            Irontergrations.id("advanced_blood_power"));
    public static ResourceKey<UpgradeOrbType> ADVANCED_EVOCATION_SPELL_POWER = ResourceKey.create(
            UPGRADE_ORB_REGISTRY_KEY,
            Irontergrations.id("advanced_evocation_power"));
    public static ResourceKey<UpgradeOrbType> ADVANCED_NATURE_SPELL_POWER = ResourceKey.create(
            UPGRADE_ORB_REGISTRY_KEY,
            Irontergrations.id("advanced_nature_power"));

    public static ResourceKey<UpgradeOrbType> ADVANCED_ABYSSAL_SPELL_POWER;
    public static ResourceKey<UpgradeOrbType> ADVANCED_ELDRITCH_SPELL_POWER;
    public static ResourceKey<UpgradeOrbType> ADVANCED_WIND_SPELL_POWER;
    public static ResourceKey<UpgradeOrbType> ADVANCED_SYMMETRY_SPELL_POWER;
    public static ResourceKey<UpgradeOrbType> ADVANCED_AQUA_SPELL_POWER;
    static {
        if (isCATSLoaded()){
            ADVANCED_ABYSSAL_SPELL_POWER = ResourceKey.create(
                    UPGRADE_ORB_REGISTRY_KEY,
                    Irontergrations.id("advanced_abyssal_power"));
        }
        else {
            ADVANCED_ABYSSAL_SPELL_POWER = null;
        }
        if (isCATSLoaded()){
            ADVANCED_ELDRITCH_SPELL_POWER = ResourceKey.create(
                    UPGRADE_ORB_REGISTRY_KEY,
                    Irontergrations.id("advanced_eldritch_power"));
        }
        else {
            ADVANCED_ELDRITCH_SPELL_POWER = null;
        }
        if (isCATSLoaded()){
            ADVANCED_WIND_SPELL_POWER = ResourceKey.create(
                    UPGRADE_ORB_REGISTRY_KEY,
                    Irontergrations.id("advanced_wind_power"));
        }
        else {
            ADVANCED_WIND_SPELL_POWER = null;
        }
        if (isCATSLoaded()){
            ADVANCED_SYMMETRY_SPELL_POWER = ResourceKey.create(
                    UPGRADE_ORB_REGISTRY_KEY,
                    Irontergrations.id("advanced_symmetry_power"));
        }
        else {
            ADVANCED_SYMMETRY_SPELL_POWER = null;
        }
        if (isTOExtrasLoaded()){
            ADVANCED_AQUA_SPELL_POWER = ResourceKey.create(
                    UPGRADE_ORB_REGISTRY_KEY,
                    Irontergrations.id("advanced_aqua_power"));
        }
        else {
            ADVANCED_AQUA_SPELL_POWER = null;
        }
    }

    public static void bootstrap(BootstrapContext<UpgradeOrbType> bootstrap) {
        bootstrap.register(ADVANCED_FIRE_SPELL_POWER,
                new UpgradeOrbType(AttributeRegistry.FIRE_SPELL_POWER,
                        0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE,
                        IGItems.LARGE_FIRE_UPGRADE_ORB));
        bootstrap.register(ADVANCED_ICE_SPELL_POWER,
                new UpgradeOrbType(AttributeRegistry.ICE_SPELL_POWER,
                        .1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE,
                        IGItems.LARGE_ICE_UPGRADE_ORB));
        bootstrap.register(ADVANCED_LIGHTNING_SPELL_POWER,
                new UpgradeOrbType(AttributeRegistry.LIGHTNING_SPELL_POWER,
                        .1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE,
                        IGItems.LARGE_LIGHTNING_UPGRADE_ORB));
        bootstrap.register(ADVANCED_HOLY_SPELL_POWER,
                new UpgradeOrbType(AttributeRegistry.HOLY_SPELL_POWER,
                        .1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE,
                        IGItems.LARGE_HOLY_UPGRADE_ORB));
        bootstrap.register(ADVANCED_ENDER_SPELL_POWER,
                new UpgradeOrbType(AttributeRegistry.ENDER_SPELL_POWER,
                        .1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE,
                        IGItems.LARGE_ENDER_UPGRADE_ORB));
        bootstrap.register(ADVANCED_BLOOD_SPELL_POWER,
                new UpgradeOrbType(AttributeRegistry.BLOOD_SPELL_POWER,
                        .1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE,
                        IGItems.LARGE_BLOOD_UPGRADE_ORB));
        bootstrap.register(ADVANCED_EVOCATION_SPELL_POWER,
                new UpgradeOrbType(AttributeRegistry.EVOCATION_SPELL_POWER,
                        .1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE,
                        IGItems.LARGE_EVOCATION_UPGRADE_ORB));
        bootstrap.register(ADVANCED_NATURE_SPELL_POWER,
                new UpgradeOrbType(AttributeRegistry.NATURE_SPELL_POWER,
                        .1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE,
                        IGItems.LARGE_NATURE_UPGRADE_ORB));
    }
}
