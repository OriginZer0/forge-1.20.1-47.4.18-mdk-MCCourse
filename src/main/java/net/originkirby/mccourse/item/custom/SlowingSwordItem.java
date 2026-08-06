package net.originkirby.mccourse.item.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class SlowingSwordItem extends SwordItem {
    public SlowingSwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if(entity instanceof LivingEntity livingEntity) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 400, 4), player);
        }
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        var level = pTarget.level();

        if(!level.isClientSide() && level instanceof ServerLevel serverLevel) {
            LightningBolt lightningBolt = EntityType.LIGHTNING_BOLT.create(serverLevel);

            if (lightningBolt !=null) {
                lightningBolt.moveTo(pTarget.getX(), pTarget.getY(), pTarget.getZ());
                lightningBolt.setCause(pAttacker instanceof net.minecraft.server.level.ServerPlayer player ? player : null);
                serverLevel.addFreshEntity(lightningBolt);
            }
        }
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
}
