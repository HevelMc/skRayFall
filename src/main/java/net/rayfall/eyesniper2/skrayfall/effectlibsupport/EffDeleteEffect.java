package net.rayfall.eyesniper2.skrayfall.effectlibsupport;

import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Examples;
import ch.njol.skript.doc.Name;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;

import net.rayfall.eyesniper2.skrayfall.Core;

import org.bukkit.event.Event;
import org.eclipse.jdt.annotation.Nullable;

@Name("Delete/Stop Effect")
@Description("Stops a EffectLib effect that matches the id value.")
@Examples({"command /bleedtest:",
        "\ttrigger:",
        "\t\tcreate a bleed effect to player with id \"bleedtest\"",
        "\t\twait 10 seconds",
        "\t\tmessage \"&cDelete\"",
        "\t\tdelete effect \"bleedtest\""})
public class EffDeleteEffect extends Effect {

    // (delete|stop) (effect|formation) %string%

    private Expression<String> id;

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] exp, int arg1, Kleenean arg2, ParseResult arg3) {
        id = (Expression<String>) exp[0];
        return true;
    }

    @Override
    public String toString(@Nullable Event arg0, boolean arg1) {
        return null;
    }

    @Override
    protected void execute(Event evt) {
        Core.rayfallEffectManager.deleteEffect(id.getSingle(evt).replace("\"", ""));
    }

}
