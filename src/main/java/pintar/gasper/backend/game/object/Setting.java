package pintar.gasper.backend.game.object;

public class Setting {

    private String keyLeft;
    private String keyRight;
    private String keyJump;
    private String keyShoot;
    private String music;
    private String soundEffect;
    private String language;

    public Setting() {}

    public Setting(String keyLeft, String keyRight, String keyJump, String keyShoot, String music, String soundEffect, String language) {
        this.keyLeft = keyLeft;
        this.keyRight = keyRight;
        this.keyJump = keyJump;
        this.keyShoot = keyShoot;
        this.music = music;
        this.soundEffect = soundEffect;
        this.language = language;
    }

    public String getKeyLeft() {
        return keyLeft;
    }

    public String getKeyRight() {
        return keyRight;
    }

    public String getKeyJump() {
        return keyJump;
    }

    public String getKeyShoot() {
        return keyShoot;
    }

    public String getMusic() {
        return music;
    }

    public String getSoundEffect() {
        return soundEffect;
    }

    public String getLanguage() {
        return language;
    }
}