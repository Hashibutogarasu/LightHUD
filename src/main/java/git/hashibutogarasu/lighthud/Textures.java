package git.hashibutogarasu.lighthud;

import net.minecraft.util.Identifier;

public enum Textures {
    SUNRISE_TEXTURE(new Identifier("timehud:textures/hud/sunrise.png")),
    DAY_TEXTURE(new Identifier("timehud:textures/hud/day.png")),
    NOON_TEXTURE(new Identifier("timehud:textures/hud/noon.png")),
    EVENING_TEXTURE(new Identifier("timehud:textures/hud/evening.png")),
    SUNSET_TEXTURE(new Identifier("timehud:textures/hud/sunset.png")),
    NIGHT_TEXTURE(new Identifier("timehud:textures/hud/night.png")),
    MIDNIGHT_TEXTURE(new Identifier("timehud:textures/hud/midnight.png"));

    public Identifier identifier;

    Textures(Identifier identifier){
        this.identifier = identifier;
    }
}
