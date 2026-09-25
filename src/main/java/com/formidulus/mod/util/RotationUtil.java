package com.formidulus.mod.util;

import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector2f;

public class RotationUtil {
   public static Vector2f getRotationTowards(Vec3 origin, Vec3 destination) {
      double dx = destination.x - origin.x;
      double dy = destination.y - origin.y;
      double dz = destination.z - origin.z;
      double g = Math.sqrt(dx * dx + dz * dz);
      return new Vector2f((float)Mth.wrapDegrees(Math.toDegrees(Mth.atan2(dz, dx)) - 90.0), (float)Mth.wrapDegrees(-Math.toDegrees(Mth.atan2(dy, g))));
   }
}
