package me.melonboy10.colorfulShulkers.mixin;

import net.minecraft.entity.mob.ShulkerEntity;
import net.minecraft.util.DyeColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(ShulkerEntity.class)
public class ShulkerEntityMixin {

    @Redirect(method = "spawnNewShulker()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/mob/ShulkerEntity;getColor()Lnet/minecraft/util/DyeColor;"))
    private DyeColor injected(ShulkerEntity shulkerEntity) {
        return DyeColor.values()[new Random().nextInt(DyeColor.values().length)];
    }
}
