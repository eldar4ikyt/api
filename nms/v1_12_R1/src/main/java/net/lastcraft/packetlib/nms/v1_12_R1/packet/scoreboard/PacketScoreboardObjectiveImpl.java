package net.lastcraft.packetlib.nms.v1_12_R1.packet.scoreboard;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.lastcraft.packetlib.nms.interfaces.packet.scoreboard.PacketScoreboardObjective;
import net.lastcraft.packetlib.nms.scoreboard.DObjective;
import net.lastcraft.packetlib.nms.scoreboard.ObjectiveActionMode;
import net.lastcraft.packetlib.nms.util.ReflectionUtils;
import net.lastcraft.packetlib.nms.v1_12_R1.packet.DPacketBase;
import net.minecraft.server.v1_12_R1.IScoreboardCriteria;
import net.minecraft.server.v1_12_R1.PacketPlayOutScoreboardObjective;

@AllArgsConstructor
@Getter
public class PacketScoreboardObjectiveImpl extends DPacketBase<PacketPlayOutScoreboardObjective>
        implements PacketScoreboardObjective {

    private DObjective objective;
    private ObjectiveActionMode mode;

    @Override
    public void setObjective(DObjective objective) {
        this.objective = objective;
        init();
    }

    @Override
    public void setMode(ObjectiveActionMode mode) {
        this.mode = mode;
        init();
    }

    @Override
    protected PacketPlayOutScoreboardObjective init() {
        PacketPlayOutScoreboardObjective packet = new PacketPlayOutScoreboardObjective();

        ReflectionUtils.setFieldValue(packet, "a", objective.getName());
        ReflectionUtils.setFieldValue(packet, "b", objective.getDisplayName());
        ReflectionUtils.setFieldValue(packet, "c",
                IScoreboardCriteria.EnumScoreboardHealthDisplay.valueOf(objective.getType().name()));
        ReflectionUtils.setFieldValue(packet, "d", mode.ordinal());

        return packet;
    }
}