package cn.leomc.teamprojecte;

import net.minecraftforge.eventbus.api.Event;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

/**
 * Fired on the server when either:
 * <ul>
 *     <li>A player leaves or joins a team</li>
 *     <li>A team has changed its owner or whether it is sharing EMC or knowledge</li>
 * </ul>
 * In the latter case, the values for a player UUID and new team will be {@code null}.
 * <p>
 * This event is fired on {@link net.minecraftforge.common.MinecraftForge#EVENT_BUS}. It is not
 * {@link net.minecraftforge.eventbus.api.Cancelable}, and has no result.
 */
public class TeamChangeEvent extends Event {
    @Nullable
    private final UUID playerUUID;
    @Nullable
    private final TPTeam team;
    @Nullable
    private final TPTeam newTeam;

    public TeamChangeEvent(@Nullable UUID playerUUID, @Nullable TPTeam team, @Nullable TPTeam newTeam) {
        this.playerUUID = playerUUID;
        this.team = team;
        this.newTeam = newTeam;
    }

    /**
     * @return The UUID of the player changing teams, or {@code null} if no team member changes have occurred.
     */
    @Nullable
    public UUID getPlayerUUID() {
        return playerUUID;
    }

    /**
     * @return The team being changed, either in members, owner or sharing status, or {@code null} if a player joins
     * a team but was not already in another team.
     */
    @Nullable
    public TPTeam getTeam() {
        return team;
    }

    /**
     * @return The new team that a player has joined, or {@code null} if either no team member changes have occurred
     * or a player has left or been kicked from their old team.
     */
    @Nullable
    public TPTeam getNewTeam() {
        return newTeam;
    }
}
