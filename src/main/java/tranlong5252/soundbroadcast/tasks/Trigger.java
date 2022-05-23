package tranlong5252.soundbroadcast.tasks;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.SoundCategory;
import org.bukkit.scheduler.BukkitRunnable;
import tranlong5252.soundbroadcast.config.Config;

public class Trigger extends BukkitRunnable {

    private final String msg;
    private final String ins = "block.note_block." + Config.getInstrument();
    //private final Instrument ins = Instrument.valueOf(Config.getInstrument());
    private int remaining;

    public Trigger(String msg, int remaining) {
        this.msg = msg;
        this.remaining = remaining;
    }

    @Override
    public void run() {
        Bukkit.getOnlinePlayers().forEach(p -> {
            Location loc = p.getLocation();
            switch (remaining) {
                case 4:
                    //p.playNote(loc, ins, Note.sharp(1, Note.Tone.F));
                    p.playSound(loc, ins, SoundCategory.RECORDS, 100000000, 0.5f);
                    break;
                case 3:
                    //p.playNote(loc, ins, Note.sharp(1, Note.Tone.A));
                    p.playSound(loc, ins, SoundCategory.RECORDS, 100000000, 0.629961f);
                    break;
                case 2:
                    //p.playNote(loc, ins, Note.sharp(1, Note.Tone.C));
                    p.playSound(loc, ins, SoundCategory.RECORDS, 100000000, 0.749154f);
                    break;
                case 1:
                    //p.playNote(loc, ins, Note.sharp(2, Note.Tone.F));
                    p.playSound(loc, ins, SoundCategory.RECORDS, 100000000, 1);
                    break;
            }
        });
//0 4 7 12
        if (remaining <= 0) {
            Bukkit.broadcastMessage(Config.getPrefix() + msg);
            cancel();
        }
        remaining--;
    }
}