package net.mcreator.vvfdfc.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BlockEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;
import net.minecraft.entity.Entity;

import net.mcreator.vvfdfc.VvfdfcMod;

import java.util.Map;
import java.util.HashMap;

public class WaterBottleWithWaterPlantsDangYouJianDianJiKongQiShiShiTiDeWeiZhiProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
			Entity entity = event.getEntity();
			IWorld world = event.getWorld();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", event.getPos().getX());
			dependencies.put("y", event.getPos().getY());
			dependencies.put("z", event.getPos().getZ());
			dependencies.put("px", entity.getPosX());
			dependencies.put("py", entity.getPosY());
			dependencies.put("pz", entity.getPosZ());
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("blockstate", event.getState());
			dependencies.put("placedagainst", event.getPlacedAgainst());
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				VvfdfcMod.LOGGER
						.warn("Failed to load dependency world for procedure WaterBottleWithWaterPlantsDangYouJianDianJiKongQiShiShiTiDeWeiZhi!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				VvfdfcMod.LOGGER.warn("Failed to load dependency x for procedure WaterBottleWithWaterPlantsDangYouJianDianJiKongQiShiShiTiDeWeiZhi!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				VvfdfcMod.LOGGER.warn("Failed to load dependency y for procedure WaterBottleWithWaterPlantsDangYouJianDianJiKongQiShiShiTiDeWeiZhi!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				VvfdfcMod.LOGGER.warn("Failed to load dependency z for procedure WaterBottleWithWaterPlantsDangYouJianDianJiKongQiShiShiTiDeWeiZhi!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (world instanceof World && !((World) world).isRemote) {
			((World) world).createExplosion(null, (int) x, (int) y, (int) z, (float) 10000000000, Explosion.Mode.BREAK);
		}
	}
}
