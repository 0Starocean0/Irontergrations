package cn.nutminds.irontergrations;

import net.neoforged.fml.ModList;

public class CompatChecker {
    public static boolean isIllagerInvasionLoaded() {
        return ModList.get().isLoaded("illagerinvasion");
    }
    public static boolean isEnderiteModLoaded() {
        return ModList.get().isLoaded("enderitemod");
    }

    public static boolean isCATSLoaded() {
        return ModList.get().isLoaded("cataclysm_spellbooks");
    }
    public static boolean isDTELoaded() {
        return ModList.get().isLoaded("discerning_the_eldritch");
    }
    public static boolean isAeromancyLoaded() {
        return ModList.get().isLoaded("aero_additions");
    }
    public static boolean isMFTELoaded() {
        return ModList.get().isLoaded("iss_magicfromtheeast");
    }
    public static boolean isTOExtrasLoaded() {
        return ModList.get().isLoaded("traveloptics");
    }
}
