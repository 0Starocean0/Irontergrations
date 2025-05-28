package cn.nutminds.irontergrations.register;

import cn.nutminds.irontergrations.Irontergrations;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class IGEntities {
    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, Irontergrations.MODID);
}
