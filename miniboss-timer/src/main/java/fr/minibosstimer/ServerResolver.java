package fr.minibosstimer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ServerData;

/** Détermine "sur quel serveur" tu te trouves. */
public final class ServerResolver {
    private ServerResolver() {}

    public static String current() {
        // 1) nom forcé avec /mbt server <nom>
        String manual = Config.data.manualServerName;
        if (manual != null && !manual.isBlank()) return manual;

        // 2) nom du serveur dans ta liste multijoueur (sinon son adresse IP)
        ServerData sd = Minecraft.getInstance().getCurrentServer();
        if (sd == null) return "Solo";
        if (sd.name != null && !sd.name.isBlank()) return sd.name;
        if (sd.ip != null && !sd.ip.isBlank()) return sd.ip;
        return "Inconnu";
    }
}
