package net.lastcraft.packetlib.nms.v1_12_R1.entity;

import net.lastcraft.packetlib.nms.interfaces.entity.DEntityMushroomCow;
import net.minecraft.server.v1_12_R1.EntityMushroomCow;
import net.minecraft.server.v1_12_R1.World;

public class DEntityMushroomCowImpl extends DEntityLivingBase<EntityMushroomCow> implements DEntityMushroomCow {

    public DEntityMushroomCowImpl(World world) {
        super(new EntityMushroomCow(world));
    }
}

